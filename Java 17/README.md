# Java 17

## JEP 306: Restore Always-Strict Floating-Point Semantics

This JEP is for numerically-sensitive programs, mainly scientific purposes; It again made default floating-point operations strict or Strictfp, ensure the same results from the floating-point calculations on every platform.

Short history

- Before Java 1.2, all floating-point calculations were strict; and it caused overheats on x87-based hardware.
- Since Java 1.2, we need the keyword strictfp to enable the strict floating-point calculation. The default floating-point calculation was changed from strict to subtly different floating-point calculations (avoid overheats issues).
- Now, since Intel and AMD have both support SSE2 (Streaming SIMD Extensions 2) extensions, which could support for the strict JVM floating-point operations without the overheats, so, the previous (before Java 1.2) overheats issues on x87-based hardware are irreverent in nowaday hardware.
- Java 17 restores the pre-Java 1.2 strict floating-point calculations as default, which means the keyword strictfp is now optional.

## JEP 356: Enhanced Pseudo-Random Number Generators

This JEP introduced a new interface called RandomGenerator to make future pseudorandom number generator (PRNG) algorithms easier to implement or use.

```java
package java.util.random;
public interface RandomGenerator {
  //...
}
```

The below example uses the new Java 17 RandomGeneratorFactory to get the famous Xoshiro256PlusPlus PRNG algorithms to generate random integers within a specific range, 0 – 10.


```java
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class JEP356 {

  public static void main(String[] args) {

      // legacy
      // RandomGeneratorFactory.of("Random").create(42);

      // default L32X64MixRandom
      // RandomGenerator randomGenerator = RandomGeneratorFactory.getDefault().create();

      // Passing the same seed to random, and then calling it will give you the same set of numbers
      // for example, seed = 999
      RandomGenerator randomGenerator = RandomGeneratorFactory.of("Xoshiro256PlusPlus").create(999);

      System.out.println(randomGenerator.getClass());

      int counter = 0;
      while(counter<=10){
          // 0-10
          int result = randomGenerator.nextInt(11);
          System.out.println(result);
          counter++;
      }

  }
}
```

```
Output:

class jdk.random.Xoshiro256PlusPlus
4
6
9
5
7
6
5
0
6
10
4
```

The below code generates all the Java 17 PRNG algorithms.

```java
  RandomGeneratorFactory.all()
              .map(fac -> fac.group()+ " : " +fac.name())
              .sorted()
              .forEach(System.out::println);

```

```
LXM : L128X1024MixRandom
LXM : L128X128MixRandom
LXM : L128X256MixRandom
LXM : L32X64MixRandom
LXM : L64X1024MixRandom
LXM : L64X128MixRandom
LXM : L64X128StarStarRandom
LXM : L64X256MixRandom
Legacy : Random
Legacy : SecureRandom
Legacy : SplittableRandom
Xoroshiro : Xoroshiro128PlusPlus
Xoshiro : Xoshiro256PlusPlus
```

## JEP 382: New macOS Rendering Pipeline

Apple deprecated the OpenGL rendering library in macOS 10.14 release(September 2018), in favor of the new Metal framework for better performance.

This JEP changes the Java 2D (like Swing GUI) internal rendering pipeline for macOS from Apple OpenGL API to Apple Metal API; this is an internal change; there are no new Java 2D APIs, nor change any existing APIs.

## JEP 391: macOS/AArch64 Port

Apple has a long-term plan to transition its Mac from x64 to AArch64 (e.g., Apple M1 processors).

This JEP port JDK to run on AArch64 platforms on macOS.

## JEP 398: Deprecate the Applet API for Removal

The Java Applet API is irrelevant because most of the web-browser has removed support for Java browser plug-ins.

Java 9 deprecated the Applet API.

```java
@Deprecated(since = "9")
public class Applet extends Panel {
  //...
}
```

This JEP marked the Applet API for removal.

```java
@Deprecated(since = "9", forRemoval = true)
@SuppressWarnings("removal")
public class Applet extends Panel {
  //...
}
```

## JEP 403: Strongly Encapsulate JDK Internals

Many third-party libraries, frameworks, and tools are accessing the internal APIs and packages of the JDK. The Java 16, JEP 396 make the strong encapsulation by default (we are not allowed to access the internal APIs easily). However, we can still use --illegal-access to switch to the simple encapsulation to still access the internal APIs.

This JEP is the successor to the above Java 16 JEP 396, and it takes one more step by removing the --illegal-access option, which means we have no ways to access the internal APIs, except for critical internal APIs such as sun.misc.Unsafe.

Try the --illegal-access=warn in Java 17.

```sh
java --illegal-access=warn

OpenJDK 64-Bit Server VM warning: Ignoring option --illegal-access=warn; support was removed in 17.0  
```

## JEP 406: Pattern Matching for switch (Preview)

This JEP adds pattern matching for switch statements and expressions. Since this is a preview feature, we need to use --enable-preview option to enable it.

### if…else chain

Before Java 17, typically, we use a chain of if...else tests for several possibilities.

```java
public class JEP406 {

  public static void main(String[] args) {

      System.out.println(formatter("Java 17"));
      System.out.println(formatter(17));

  }

  static String formatter(Object o) {
      String formatted = "unknown";
      if (o instanceof Integer i) {
          formatted = String.format("int %d", i);
      } else if (o instanceof Long l) {
          formatted = String.format("long %d", l);
      } else if (o instanceof Double d) {
          formatted = String.format("double %f", d);
      } else if (o instanceof String s) {
          formatted = String.format("String %s", s);
      }
      return formatted;
  }

}
```

In Java 17, we can rewrite the above code like this:

```java
public class JEP406 {

    public static void main(String[] args) {

        System.out.println(formatterJava17("Java 17"));
        System.out.println(formatterJava17(17));

    }

    static String formatterJava17(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> o.toString();
        };
    }

}
```

### Pattern matching and null

Now we can test the null in switch directly.


Old code

```java
public class JEP406 {

  public static void main(String[] args) {

      testString("Java 16");  // Ok
      testString("Java 11");  // LTS
      testString("");         // Ok
      testString(null);       // Unknown!
  }

  static void testString(String s) {
      if (s == null) {
          System.out.println("Unknown!");
          return;
      }
      switch (s) {
          case "Java 11", "Java 17"   -> System.out.println("LTS");
          default                     -> System.out.println("Ok");
      }
  }

}
```

New code

```java
public class JEP406 {

    public static void main(String[] args) {

        testStringJava17("Java 16");  // Ok
        testStringJava17("Java 11");  // LTS
        testStringJava17("");         // Ok
        testStringJava17(null);       // Unknown!
    }

    static void testStringJava17(String s) {
        switch (s) {
            case null                   -> System.out.println("Unknown!");
            case "Java 11", "Java 17"   -> System.out.println("LTS");
            default                     -> System.out.println("Ok");
        }
    }

}
```

### Refining patterns in switch

Review the below code snippet. To test the Triangle t and t.calculateArea(), we need to create an extra if condition.

```java
class Shape {}
  class Rectangle extends Shape {}
  class Triangle  extends Shape {
      int calculateArea(){
          //...
      } }

  static void testTriangle(Shape s) {
      switch (s) {
          case null:
              break;
          case Triangle t:
              if (t.calculateArea() > 100) {
                  System.out.println("Large triangle");
                  break;
              }else{
                  System.out.println("Triangle");
              }
          default:
              System.out.println("Unknown!");
      }
  }
```

Java 17 allows so-called redefined patterns or guarded patterns like below:

```java
  static void testTriangle2(Shape s) {
      switch (s) {
          case null ->
                  {}
          case Triangle t && (t.calculateArea() > 100) ->
                  System.out.println("Large triangle");
          case Triangle t ->
                  System.out.println("Triangle");
          default ->
                  System.out.println("Unknown!");
      }
  }
```

## Remove RMI Activation

Java 15, JEP385 deprecated the RMI Activation for removal.

This JEP removed the RMI Activation or java.rmi.activation package.

## Sealed Classes

Java 15, JEP 360 and Java 16, JEP 397 introduced [sealed class(https://cr.openjdk.java.net/~briangoetz/amber/datum.html) as a preview feature.

This JEP finalized the sealed classes as the standard feature in Java 17, with no changes from Java 16.

The sealed classes and interfaces control or restrict who can be a subtype.

```java

public sealed interface Command
    permits LoginCommand, LogoutCommand, PluginCommand{
    //...
}
```

## Remove the Experimental AOT and JIT Compiler

Java 9, JEP 295 introduced the Ahead-of-time compilation (the jaotc tool) as an experimental feature. Later Java 10, JEP 317 proposed it again as an experimental JIT compiler.

However, this feature has little use since they were introduced and required significant effort to maintain it, so this JEP removed the experimental Java-based ahead-of-time (AOT) and just-in-time (JIT) compiler

The following AOT packages, classes, tools and codes are removed:

- jdk.aot — the jaotc tool
- jdk.internal.vm.compiler — the Graal compiler
- jdk.internal.vm.compiler.management — Graal’s MBean
- src/hotspot/share/aot — dumps and loads AOT code
- Additional code guarded by #if INCLUDE_AOT

## Deprecate the Security Manager for Removal

Java 1.0 introduced the Security Manager to secure the client-side Java code, and irrelevant now.

This JEP deprecates the Security Manager for removal.

```java

package java.lang;

 * @since   1.0
 * @deprecated The Security Manager is deprecated and subject to removal in a
 *       future release. There is no replacement for the Security Manager.
 *       See <a href="https://openjdk.java.net/jeps/411">JEP 411</a> for
 *       discussion and alternatives.
 */
@Deprecated(since="17", forRemoval=true)
public class SecurityManager {
  //...
}
```

## Foreign Function & Memory API (Incubator)

This Foreign Function & Memory API allows the developer to access the code outside the JVM (foreign functions), data stored outside the JVM (off-heap data), and accessing memory not managed by the JVM (foreign memory).

P.S This is an incubating feature; need add --add-modules jdk.incubator.foreign to compile and run the Java code.

History

- Java 14 JEP 370 introduced Foreign-Memory Access API (Incubator).
- Java 15 JEP 383 introduced Foreign-Memory Access API (Second Incubator).
- Java 16 JEP 389 introduced Foreign Linker API (Incubator).
- Java 16 JEP 393 introduced Foreign-Memory Access API (Third Incubator).
- Java 17 JEP 412 introduced Foreign Function & Memory API (Incubator).

## Vector API (Second incubator)

Java 16, JEP 414 introduced new Vector API as an incubating API.

This JEP improves the Vector API performance and other enhancements like support operations on characters, translating byte vectors to and from boolean arrays, etc.

## Context-Specific Deserialization Filters

In Java, deserializing untrusted data is dangerous, read the OWASP – Deserialization of untrusted data and Brian Goetz – Towards Better Serialization.

Java 9, JEP 290 introduced serialization filtering to help prevent deserialization vulnerabilities.

14.1 The below example creates a custom filter using a pattern.