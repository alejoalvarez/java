# Table of Contents

## JEP 305: Pattern Matching for instanceof (Preview)

Before Java 14, we use **instanceof-and-cast** to check the object’s type and cast to a variable.

```java
  if (obj instanceof String) {        // instanceof
    String s = (String) obj;          // cast
    if("jdk14".equalsIgnoreCase(s)){
        //...
    }
  }else {
       System.out.println("not a string");
  }
```

Now Java 14, we can refactor above code like this:

```java
  if (obj instanceof String s) {      // instanceof, cast and bind variable in one line.
      if("jdk4".equalsIgnoreCase(s)){
          //...
      }
  }else {
       System.out.println("not a string");
  }
```

if **obj** is an instance of **String**, then it is cast to String and assigned to the binding variable **s**.

History
This pattern matching is a standard feature in Java 16, JEP 394.


## JEP 343: Packaging Tool (Incubator)

New **jpackage** tool to package a Java application into a platform-specific package like:

- Linux: deb and rpm
- macOS: pkg and dmg
- Windows: msi and exe

P.S This packaging tool is a standard feature in Java 16, visit this jpackage example.


## JEP 345: NUMA-Aware Memory Allocation for G1

New NUMA-aware memory allocation mode, improves the G1 performance on large machines. Add +XX:+UseNUMA option to enable it.


## JEP 349: JFR Event Streaming

Improved the existing JFR to support event streaming, it means now we can stream the JFR events in real-time, without the need to dump the recorded events to disk and parse it manually.

The JDK Flight Recorder (JFR) is a tool for collecting diagnostic and profiling data about a running Java application. Normally, we start a recording, stop it, dump the recorded events to disk for parsing, it works well for profiling, analysis, or debugging.


## JEP 352: Non-Volatile Mapped Byte Buffers

Improved FileChannel API to create MappedByteBuffer that access to non-volatile memory (NVM) – a memory that can retrieve stored data even after having been power cycled. For example, this feature ensures that any changes which might still be in the cache are written back to memory.

P.S Only Linux/x64 and Linux/AArch64 OS support this!

## JEP 358: Helpful NullPointerExceptions

Improved the description of **NullPointerExceptions** by telling which variable was null. Add ```-XX:+ShowCodeDetailsInExceptionMessages``` option to enable this feature.

A simple Java file that throws an NullPointerException.

```java

import java.util.Locale;

public class Test {

    public static void main(String[] args) {

        String input = null;
        String result = showUpperCase(input); // NullPointerException
        System.out.println(result);

    }

    public static String showUpperCase(String str){
        return str.toUpperCase(Locale.US);
    }

}
```

Before Java 14.

```
$ /usr/lib/jvm/jdk-14/bin/java Test

Exception in thread "main" java.lang.NullPointerException
    at Test.showUpperCase(Test.java:15)
    at Test.main(Test.java:9)
```

Java 14 with ```-XX:+ShowCodeDetailsInExceptionMessages``` option.

```
$ /usr/lib/jvm/jdk-14/bin/java -XX:+ShowCodeDetailsInExceptionMessages Test

Exception in thread "main" java.lang.NullPointerException:
  Cannot invoke "String.toUpperCase(java.util.Locale)" because "<parameter1>" is null
    at Test.showUpperCase(Test.java:15)
    at Test.main(Test.java:9)
```

## JEP 359: Records (Preview)

A new class called record (aka data class), it is a final class, not abstract, and all of its fields are final as well. The record will automatically generate the tedious constructors, public get, equals(), hashCode(), toString() during compile time.

P.S No setters, all fields are final.

A record or data class, create the class name and variables, and we can start using it.
Point.java

```java
record Point(int x, int y) { }
```

```java

public class Test {

    public static void main(String[] args) {

        Point p1 = new Point(10, 20);      
        System.out.println(p1.x());         // 10
        System.out.println(p1.y());         // 20

        Point p2 = new Point(11, 22);
        System.out.println(p2.x());         // 11
        System.out.println(p2.y());         // 22

          Point p3 = new Point(10, 20);     
        System.out.println(p3.x());         // 10
        System.out.println(p3.y());         // 20

        System.out.println(p1.hashCode());  // 330
        System.out.println(p2.hashCode());  // 363
        System.out.println(p3.hashCode());  // 330

        System.out.println(p1.equals(p2));  // false
        System.out.println(p1.equals(p3));  // true
        System.out.println(p2.equals(p3));  // false

    }

}
```

History

- Java 15 JEP 384 has the second preview of records, with new features like sealed types, local records, annotation on records, and Reflection APIs.
- Java 16 JEP 395, record or data class is the standard feature.

## JEP 361: Switch Expressions (Standard)

The switch expression was a preview feature in Java 12 and Java 13; now it is officially JDK standard feature, it means from Java 14 and onward, we can return value via switch expressions without specifying the --enable-preview option.

See a recap; we can use yield to return a value from a switch.

```java
    private static int getValueViaYield(String mode) {
        int result = switch (mode) {
            case "a", "b":
                yield 1;
            case "c":
                yield 2;
            case "d", "e", "f":
                                // do something here...
                             	System.out.println("Supports multi line block!");
                yield 3;
            default:
                yield -1;
        };
        return result;
    }
```

Or via a label rules or arrows.

```java
    private static int getValueViaArrow(String mode) {
        int result = switch (mode) {
            case "a", "b" -> 1;
            case "c" -> 2;
            case "d", "e", "f" -> {
                // do something here...
                System.out.println("Supports multi line block!");
                yield 3;
            }
            default -> -1;
        };
        return result;
    }
```

## JEP 362: Deprecate the Solaris and SPARC Ports

Dropping support for Solaris/SPARC, Solaris/x64, and Linux/SPARC ports, fewer platforms support means faster delivery for new features.

P.S Java 15 JEP 381 removed the above ports.


## JEP 363: Remove the Concurrent Mark Sweep (CMS) Garbage Collector

Java 9 JEP 291 deprecated this Concurrent Mark Sweep (CMS) Garbage Collector, and now it is officially removed.

```
/usr/lib/jvm/jdk-14/bin/java -XX:+UseConcMarkSweepGC Test

OpenJDK 64-Bit Server VM warning: Ignoring option UseConcMarkSweepGC; support was removed in 14.0
```

## JEP 364: ZGC on macOS (Experimental)

Java 11 JEP 333 introduced the Z Garbage Collector (ZGC) on Linux, and now it ports to macOS.

P.S This ZGC is a product feature in Java 15 JEP 377.


## JEP 365: ZGC on Windows (Experimental)

Java 11 JEP 333 introduced the Z Garbage Collector (ZGC) on Linux, and now it ports to Windows version >= 1803.

P.S This ZGC is a product feature in Java 15 JEP 377.

## JEP 366: Deprecate the ParallelScavenge + SerialOld GC Combination

Due to less use and high maintenance effort, Java 14 deprecates the combination of the parallel young generation and serial old generation GC algorithms.

```
/usr/lib/jvm/jdk-14/bin/java -XX:-UseParallelOldGC Test

OpenJDK 64-Bit Server VM warning: Option UseParallelOldGC was deprecated in version 14.0 and will likely be removed in a future release.
```

## JEP 367: Remove the Pack200 Tools and API

Java 11 JEP 336 deprecated the pack200 and unpack200 tools, and the Pack200 API in the java.util.jar package, and now it is officially removed.

## JEP 368: Text Blocks (Second Preview)

The first preview appeared in Java 13 JEP 354, now added two more new escape sequences:

- \<end-of-line> suppresses the line termination.
- \s is translated into a single space.

```java
public class Test {

    public static void main(String[] args) {

        String html = "<html>\n" +
                      "   <body>\n" +
                      "      <p>Hello, World</p>\n" +
                      "   </body>\n" +
                      "</html>\n";

        String java13 = """
                        <html>
                            <body>
                                <p>Hello, World</p>
                            </body>
                        </html>
                        """;

        String java14 = """
                        <html>
                            <body>\
                                <p>Hello, '\s' World</p>\
                            </body>
                        </html>
                        """;

        System.out.println(html);
        System.out.println(java13);
        System.out.println(java14);

    }

}
```

```
$ /usr/lib/jvm/jdk-14/bin/javac --enable-preview --release 14 Test.java
$ /usr/lib/jvm/jdk-14/bin/java --enable-preview Test

```
```
Output

html>
   <body>
      <p>Hello, World</p>
   </body>
</html>

<html>
    <body>
        <p>Hello, World</p>
    </body>
</html>

<html>
    <body>        <p>Hello, ' ' World</p>    </body>
</html>
```

P.S This text blocks is a permanent feature in Java 15.


## JEP 370: Foreign-Memory Access API (Incubator)

An incubator module, allow Java API to access foreign memory outside of the Java heap.
Test.java

```java
import jdk.incubator.foreign.*;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

public class Test {

    public static void main(String[] args) {

         VarHandle intHandle = MemoryHandles.varHandle(
            int.class, ByteOrder.nativeOrder());

        try (MemorySegment segment = MemorySegment.allocateNative(1024)) {

            MemoryAddress base = segment.baseAddress();

            // print memory address
            System.out.println(base);                 

            // set value 999 into the foreign memory
              intHandle.set(base, 999);                 

            // get the value from foreign memory
            System.out.println(intHandle.get(base));  

        }

    }

}
```

Compile and run with incubator module jdk.incubator.foreign.

```
$ /usr/lib/jvm/jdk-14/bin/javac --add-modules jdk.incubator.foreign Test.java

warning: using incubating module(s): jdk.incubator.foreign
1 warning

$ /usr/lib/jvm/jdk-14/bin/java --add-modules jdk.incubator.foreign Test

WARNING: Using incubator modules: jdk.incubator.foreign
MemoryAddress{ region: MemorySegment{ id=0x4aac6dca limit: 1024 } offset=0x0 }
999
```

History

    Java 15 JEP 383 has the second Incubator.
    Java 16 JEP 393 has the third Incubator.

