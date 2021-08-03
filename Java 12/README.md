# Table of Contents

## JEP 189: Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)

Shenandoah is a new low-pause and concurrent garbage collector, read this research paper, it reduces GC pause time and independent of the Java heap size (5M or 5G of heap size have the same pause time, useful for large heap applications.)

This GC is an experimental feature, and we need to use the following options to enable the new Shenandoah GC.

```
-XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC
```

However, both Oracle JDK and OpenJDK don’t contain this new Shenandoah GC, read this also Not all OpenJDK 12 builds include Shenandoah: Here’s why.

```
C:\Users\alejo> java -version
java version "12" 2019-03-19
Java(TM) SE Runtime Environment (build 12+33)
Java HotSpot(TM) 64-Bit Server VM (build 12+33, mixed mode, sharing)

C:\Users\alejo> java -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC
Error occurred during initialization of VM
Option -XX:+UseShenandoahGC not supported
To try Shenandoah GC, we need other JDK build like AdoptOpenJDK.
```

P.S This Shenandoah GC became a product feature in Java 15 JEP 379.

## JEP 230: Microbenchmark Suite

Added a range of Java Microbenchmark Harness (JMH) benchmarks to the JDK source code, for those interested to add or modify the JDK source code itself, now they have a way to compare the performance.
  
## JEP 325: Switch Expressions (Preview)

This JEP enhanced the existing switch statements (returns nothing) to support switch expressions (returns something).

Traditional switch statements, we can return a value by assigning the value to a variable
  
  ```java
   private static String getText(int number) {
        String result = "";
        switch (number) {
            case 1, 2:
                result = "one or two";
                break;
            case 3:
                result = "three";
                break;
            case 4, 5, 6:
                result = "four or five or six";
                break;
            default:
                result = "unknown";
                break;
        };
        return result;
    }
    ```
    
    In Java 12, we can use break or case L -> to return a value from a switch.

  ```java
    private static String getText(int number) {
        String result = switch (number) {
            case 1, 2:
                break "one or two";
            case 3:
                break "three";
            case 4, 5, 6:
                break "four or five or six";
            default:
                break "unknown";
        };
        return result;
    }
    ```
    
    case L -> syntax.

  ```java
    private static String getText(int number) {
        return switch (number) {
            case 1, 2 -> "one or two";
            case 3 -> "three";
            case 4, 5, 6 -> "four or five or six";
            default -> "unknown";
        };
    }
    ```
    
Note
```java
This switch expressions have a second preview in Java 13 (dropped the break in favor of yield), and this switch expressions became a standard feature in Java 14.
```

## JEP 334: JVM Constants API

A new package java.lang.constant, a list of new classes and interfaces to model the key class-file and run-time artifacts, for example, the constant pool.
  
## JEP 346: Promptly Return Unused Committed Memory from G1

This JEP improves the performance of the Garbage-first (G1) collector. If the application is low of the activity or idle, G1 periodically trigger a concurrent cycle to determine overall Java heap usage and return unused Java heap memory to the operating system.
