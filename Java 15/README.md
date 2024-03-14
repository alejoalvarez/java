# Javas 15

## JEP 339: Edwards-Curve Digital Signature Algorithm (EdDSA)

Cryptography related stuff, Java 15 implements an additional digital signature scheme using the Edwards-Curve Digital Signature Algorithm (EdDSA) as described by RFC 8032. The EdDSA signature scheme is popular due to its improved security and performance (faster) over other signature schemes, and it is also one of the signatures schemes that are allowed in TLS 1.3.

Example 

```java
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class JEP339 {

    public static void main(String[] args)
        throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
        KeyPair kp = kpg.generateKeyPair();

        byte[] msg = "abc".getBytes(StandardCharsets.UTF_8);

        Signature sig = Signature.getInstance("Ed25519");
        sig.initSign(kp.getPrivate());
        sig.update(msg);
        byte[] s = sig.sign();

        System.out.println(Base64.getEncoder().encodeToString(s));

    }
}
```

## JEP 360: Sealed Classes (Preview)


introduced few new keywords, sealed, non-seal, permits to support sealed classes and interfaces. The sealed classes and interfaces restrict who can be a subtype.

The below sealed interface allowed three specified sub-classes to implement it.

```java
public sealed interface Command
    permits LoginCommand, LogoutCommand, PluginCommand{
    //...
}
```

For a not permitted class, it throws compile-time errors:

```java
public final class UnknownCommand implements Command {
  //...
}
```

The sealed class must have subclasses and Every permitted subclass must choose a modifier (sealed, non-seal, final) to describe how it continues the sealing initiated by its superclass

```java
  // close, dun extends me
  public final class LoginCommand implements Command{
  }

```

```java
 // open...up to you to play this
  // Create custom plugin by extending this class
  public non-sealed class PluginCommand implements Command {
  }
```

## JEP 371: Hidden Classes

introduces hidden classes that are not discoverable and have a limited lifecycle (shorter live), good for developers that generate classes dynamically at runtime. And now we can use this new Lookup::defineHiddenClass API to create a hidden class or interface from bytes.

Example code to use defineHiddenClass to create a hidden class from a Base64 encoded class, and launch the static lookup method manually.

```java
package com.alejo.java15.jep371;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Base64;

public class LookupProxyTest {

    //Here is the Base64 encoded class.
    /*
    package com.alejo.java15.jep371;

    public class LookUpProxy{

        public static Integer lookup() {
            return 1;
        }
    }*/
    static final String CLASS_IN_BASE64 =
            "yv66vgAAADcAFQoABAANCgAOAA8HABAHABEBAAY8aW5pdD4BAAMoKV" +
            "YBAARDb2RlAQAPTGluZU51bWJlclRhYmxlAQAGbG9va3VwAQAVKClM" +
            "amF2YS9sYW5nL0ludGVnZXI7AQAKU291cmNlRmlsZQEAEExvb2tVcF" +
            "Byb3h5LmphdmEMAAUABgcAEgwAEwAUAQAkY29tL21reW9uZy9qYXZh" +
            "MTUvamVwMzcxL0xvb2tVcFByb3h5AQAQamF2YS9sYW5nL09iamVjdA" +
            "EAEWphdmEvbGFuZy9JbnRlZ2VyAQAHdmFsdWVPZgEAFihJKUxqYXZh" +
            "L2xhbmcvSW50ZWdlcjsAIQADAAQAAAAAAAIAAQAFAAYAAQAHAAAAHQ" +
            "ABAAEAAAAFKrcAAbEAAAABAAgAAAAGAAEAAAADAAkACQAKAAEABwAA" +
            "AB0AAQAAAAAABQS4AAKwAAAAAQAIAAAABgABAAAABgABAAsAAAACAAw=";

    public static void main(String[] args) throws Throwable {

        //byte[] array = Files.readAllBytes(        
        //String s = Base64.getEncoder().encodeToString(array);
        //System.out.println(s);
        testHiddenClass();
    }

    // create a hidden class and run its static method
    public static void testHiddenClass() throws Throwable {

        byte[] classInBytes = Base64.getDecoder().decode(CLASS_IN_BASE64);

        Class<?> proxy = MethodHandles.lookup()
                .defineHiddenClass(classInBytes,
                        true, MethodHandles.Lookup.ClassOption.NESTMATE)
                .lookupClass();

        // output: com.alejo.java15.jep371.LookUpProxy/0x0000000800b94440
        System.out.println(proxy.getName());

        MethodHandle mh = MethodHandles.lookup().findStatic(proxy,
                "lookup",
                MethodType.methodType(Integer.class));

        Integer status = (Integer) mh.invokeExact();
        System.out.println(status);
    }
}
```

## JEP 372: Remove the Nashorn JavaScript Engine

- Java 8 JEP 174 introduced Nashorn as a replacement for the Rhino Javascript engine.
- Java 11 JEP 335 deprecated the Nashorn JavaScript Engine and jjs tool.
- Now, Java 15 removed the Nashorn JavaScript Engine and jjs tool permanently.
- This JEP also removed the below two modules:

    - jdk.scripting.nashorn – contains the jdk.nashorn.api.scripting and jdk.nashorn.api.tree packages.
    - jdk.scripting.nashorn.shell – contains the jjs tool.

## JEP 373: Reimplement the Legacy DatagramSocket API

- Java 13 JEP 353 reimplemented the legacy Socket APIs – java.net.Socket and java.net.ServerSocket.
- This time, Java 15 reimplemented the legacy DatagramSocket APIs – java.net.DatagramSocket and java.net.MulticastSocket.

## JEP 374: Disable and Deprecate Biased Locking

disable and deprecated the biased locking by default. Before Java 15, the biased locking is always enabled by default, giving performance gains for synchronized stuff.

The older or legacy Java application uses synchronize collections APIs like Hashtable and Vector, and the biased locking may giving performance gains. Nowadays, the newer Java application generally uses the non-synchronized collections HashMap and ArrayList, and the performance gains of biased locking are generally less useful now.

However, for Java 15, we still can enable the biased locking by using -XX:+UseBiasedLocking, but it will prompt VM warning for deprecated API.

## JEP 375: Pattern Matching for instanceof (Second Preview)

Java 14 JEP 305 introduced Pattern Matching as a preview feature. This JEP is a second preview of the pattern matching to gain additional feedback, with no change to the API.

A typical instanceof-and-cast to check the object’s type and cast it.

```java
  private static void print(Object obj) {

      if (obj instanceof String) {
          String s = (String) obj;

          if ("java15".equalsIgnoreCase(s)) {
              System.out.println("Hello Java 15");
          }
      } else {
          System.out.println("not a string");
      }
  }
```

For pattern matching, we can check, cast, and bind in a single line.

```java
  private static void printWithPatternMatching(Object obj) {
      // instanceof, cast and bind variable in one line.
      if (obj instanceof String s) {         

          if ("java15".equalsIgnoreCase(s)) {
              System.out.println("Hello Java 15");
          }
      } else {
          System.out.println("not a string");
      }
  }
```

## JEP 377: ZGC: A Scalable Low-Latency Garbage Collector

Java 11 JEP 333 introduced the ZGC garbage collector as an experimental feature.

This JEP fixed some bugs, added some features and enhancements, and now supported major platforms like Linux/x86_64, Linux/aarch64, Windows, and macOS.
This JEP also changes the Z Garbage Collector from an experimental feature into a product feature. However, the default garbage collector remains G1.
The below command enables the ZGC garbage collector.

```sh
$ java -XX:+UseZGC className
```

## JEP 378: Text Blocks
Finally, the multi-line string or text blocks is a permanent feature in Java 15.

History:

- Java 12 JEP 326 Raw String Literals
- Java 13 JEP 355: Text Blocks (Preview)
- Java 14 JEP 368: Text Blocks (Second Preview)
- Java 15, permanent feature.

```java
  String html = "<html>\n" +
                "   <body>\n" +
                "      <p>Hello, World</p>\n" +
                "   </body>\n" +
                "</html>\n";

  String java15 = """
                  <html>
                      <body>
                          <p>Hello, World</p>
                      </body>
                  </html>
                  """;

```

## JEP 379: Shenandoah: A Low-Pause-Time Garbage Collector

Java 12 JEP 189 introduced the Shenandoah garbage collector as an experimental feature, and now become a product feature in Java 15.

Before Java 15, we need -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC to enable the Shenandoah GC.

```
java -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC
```

In Java 15, we only need -XX:+UseShenandoahGC to enable the Shenandoah GC.

```
java -XX:+UseShenandoahGC
```

## JEP 381: Remove the Solaris and SPARC Ports

Java 14 JEP 362 deprecated the Solaris/SPARC, Solaris/x64, and Linux/SPARC ports and now it is officially removed in Java 15.

## JEP 383: Foreign-Memory Access API (Second Incubator)

Java 14 JEP 370 introduced a new Foreign-Memory Access API as an Incubator Modules. This JEP made some changes to the APIs, and it will be still in incubator modules.

## JEP 384: Records (Second Preview)

Java 14 JEP 359 introduced the records as a preview feature. This JEP enhanced the records with features like support sealed types, local records, annotation on records, and Reflection APIs for records.

Records and Sealed Types

```java
public sealed interface Fruit permits Apple, Orange {}

record Apple() implements Fruit{}
record Orange() implements Fruit{}
```

Local Records – records declare inside a method.

The below code snippet use local record to improves the readability of the stream operations.

```java

  List<Merchant> findTopMerchants(List<Merchant> merchants, int month) {

      // Local record
      record MerchantSales(Merchant merchant, double sales) {
      }

      return merchants.stream()
              .map(merchant -> new MerchantSales(merchant, computeSales(merchant, month)))
              .sorted((m1, m2) -> Double.compare(m2.sales(), m1.sales()))
              .map(MerchantSales::merchant)
              .collect(toList());
  }

  private double computeSales(Merchant merchant, int month) {
      // some business logic to get the sales...
      return ThreadLocalRandom.current().nextDouble(100, 10000);
  }
```

Annotations on records

```java
public record Game(@CustomAnno Rank rank) { ... }
```

## JEP 385: Deprecate RMI Activation for Removal

This JEP deprecated the obsolete RMI Activation mechanism. This will not affect other parts of RMI.