# Java 19

## JEP 405: Record Patterns (Preview)

This JEP improves the way of deconstructing or extracting the record values.

### Normal Record Patterns Example

A typical record class JEP 395, and we need to deconstruct, get, or extract the record values manually.

```java
public class JEP405 {

  record Point(int x, int y) {
  }

  static void printSum(Object o) {
      if (o instanceof Point p) {
          int x = p.x();  // get x()
          int y = p.y();  // get y()
          System.out.println(x + y);
      }
  }

  public static void main(String[] args) {
      printSum(new Point(10, 20)); // output 30
  }
}
```

We now use the new record pattern to deconstruct (get or extract) the record values automatically. The record pattern is the Point(int x,int y).

```java
public class JEP405 {

  record Point(int x, int y) {
  }

  static void printSumNew(Object o) {
      if (o instanceof Point(int x,int y)) {  // record pattern
          System.out.println(x + y);
      }
  }

  public static void main(String[] args) {
      printSumNew(new Point(10, 20)); // output 30
  }
}
```

### Record Nested Patterns Example

```java
public class JEP405_1 {

  record Point(int x, int y) {
  }

  record Total(Point p1, Point p2) {
  }

  static void printSum(Object o) {
      // record nested pattern
      if (o instanceof Total(Point(int x,int y),Point(int x2,int y2))) {
          System.out.println(x + y + x2 + y2);
      }
  }

  public static void main(String[] args) {

      printSum(new Total(new Point(10, 5), new Point(2, 3)));

  }
}
```

## Linux/RISC-V Port

makes Java support RISC-V hardware, and the port of the JDK will integrate into the JDK mainline repository.

## JEP 424: Foreign Function & Memory API (Preview)

This JEP promotes the Foreign Function & Memory API (FFM API) from the incubator stage to the preview stage. The Foreign Function & Memory API (FFM API) resides in the java.lang.foreign package of the java.base module.

3.1 Below example shows how to use the Foreign Function & Memory API (FFM API) to call the standard C library radixsort to sort an array of strings.


```java
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.*;

public class JEP424_SORT {

  public static void main(String[] args) throws Throwable {

      // 1. Find foreign function on the C library path
      Linker linker = Linker.nativeLinker();
      SymbolLookup stdlib = linker.defaultLookup();

      // 2. Allocate on-heap memory to store strings
      String[] javaStrings = {"d", "z", "b", "c", "a"};

      // 3. Allocate off-heap memory to store pointers
      SegmentAllocator allocator = SegmentAllocator.implicitAllocator();
      MemorySegment offHeap = allocator.allocateArray(ValueLayout.ADDRESS, javaStrings.length);

      // 4. Copy the strings from on-heap to off-heap
      for (int i = 0; i < javaStrings.length; i++) {

          // Allocate a string off-heap, then store a pointer to it
          MemorySegment cString = allocator.allocateUtf8String(javaStrings[i]);
          offHeap.setAtIndex(ValueLayout.ADDRESS, i, cString);
      }

      MethodHandle radixSort = linker.downcallHandle(
              stdlib.lookup("radixsort").orElseThrow(),
              FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT, ADDRESS, JAVA_CHAR));

      // 5. Sort the off-heap data by calling the foreign function
      radixSort.invoke(offHeap, javaStrings.length, MemoryAddress.NULL, '\0');

      // 6. Copy the (reordered) strings from off-heap to on-heap
      for (int i = 0; i < javaStrings.length; i++) {
          MemoryAddress cStringPtr = offHeap.getAtIndex(ValueLayout.ADDRESS, i);
          javaStrings[i] = cStringPtr.getUtf8String(0);
      }

      //print sort result
      for (String javaString : javaStrings) {
          System.out.println(javaString);
      }

  }

}
```

```
Output:

WARNING: A restricted method in java.lang.foreign.Linker has been called
WARNING: java.lang.foreign.Linker::nativeLinker has been called by the unnamed module
WARNING: Use --enable-native-access=ALL-UNNAMED to avoid a warning for this module

a
b
c
d
z
```

## Virtual Threads (Preview)

introduces virtual threads, a lightweight implementation of threads provided by the JDK instead of the OS. The number of virtual threads can be much larger than the number of OS threads. These virtual threads help increase the throughput of the concurrent applications.

Let’s review a case study:

An application with an average latency of 100ms runs on a CPU containing 10 cores, 20 OS threads, and processing 20 requests concurrently, which will fully utilize the 20 OS threads.

Let’s say we scale the throughput to 400 requests per second.

We either need to process 40 requests concurrently (upgrade CPU processor to support 40 OS threads) or reduce the average latency of the application to 50ms; The limit is always the OS threads factor or CPU processor, which makes the application’s throughput hardly scale up.

Platform Threads, OS Threads, and Virtual Threads
In Java, every instance of java.lang.Thread is a platform thread that runs Java code on an underlying OS thread. The number of platform threads is limited to the number of OS threads, like in the above case study.

A Virtual Thread is also an instance of java.lang.Thread, but it runs Java code on the same OS thread and shares it effectively, which makes the number of virtual threads can be much larger than the number of OS threads.

Because the number of OS threads does not limit virtual threads, we can quickly increase the concurrent requests to achieve higher throughput.

For example, the same existing CPU contains 10 cores and 20 OS threads, and we can convert the platform threads to virtual threads and increase concurrent requests to 40 to achieve a throughput of 400 requests per second.

## JEP 426: Vector API (Fourth Incubator)

 improves the Vector API performance and other enhancements in response to feedback.

History

- Java 16, JEP 338 introduced new Vector API as an incubating API.
- Java 17, JEP 414 enhanced the Vector APIs, second incubator.
- Java 18, JEP 417 enhanced the Vector APIs, third incubator.

## JEP 427: Pattern Matching for switch (Third Preview)

This JEP is the third preview of pattern matching for the switch, with the following enhancements since the second preview:

Guarded patterns are replaced with when clauses in switch blocks.
Below is a Java pattern matching for switch using the new when as the guarded pattern.

P.S The old && was replaced with when in the guarded pattern.

```java
public class JEP427 {

  public static void main(String[] args) {

      testJava19("alejo");
      testJava19("alejoalejo");
  }

  /* Old guarded pattern using &&
  static void test(Object o) {
      switch (o) {
          case String s && s.length() > 6 ->
              System.out.println("String's length longer than 10!");
          case String s ->
              System.out.println("String's length is " + s.length());
          default -> {
          }
      }
  }*/

  // new guarded pattern with when
  static void testJava19(Object o) {
      switch (o) {
          case String s
                  when s.length() > 10 ->
                    System.out.println("String's length longer than 10!");
          case String s ->
                    System.out.println("String's length is " + s.length());
          default -> {}
      }
  }

}
```

## JEP 428: Structured Concurrency (Incubator)

introduces Structured Concurrency APIs to simplify multithreaded programming.


```java
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JEP428 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
      JEP428 obj = new JEP428();
      obj.handleUnStructureAPI();
  }

  Response handleUnStructureAPI() throws ExecutionException, InterruptedException {
      try (var executor = Executors.newFixedThreadPool(10)) {
          Future<String> user = executor.submit(this::findUser);
          Future<Integer> order = executor.submit(this::fetchOrder);
          String theUser = user.get();   // Join findUser
          int theOrder = order.get();  // Join fetchOrder
          return new Response(theUser, theOrder);
      }
  }

  private String findUser() throws InterruptedException {
      Thread.sleep(Duration.ofSeconds(1));
      return "mkyong";
  }

  private Integer fetchOrder() throws InterruptedException {
      Thread.sleep(Duration.ofSeconds(1));
      return 1;
  }

  record Response(String x, int y) {
  }
}
```