# Features and Updates

Oracle released a new version of Java as Java 10 on March 20, 2018, with several features and enhancements. These features are enhancements for garbage collection and compilation as well as local variable types.

Java 10 version is scheduled to be a short-term release and its updates and life-cycle will end in six months. Here, we discuss its features that are pointed below.

- Local-Variable Type Inference
- Consolidate the JDK Forest into a Single Repository
- Garbage-Collector Interface
- Parallel Full GC for G1
- Application Class-Data Sharing
- Thread-Local Handshakes
- Remove the Native-Header Generation Tool (javah)
- Additional Unicode Language-Tag Extensions
- Heap Allocation on Alternative Memory Devices
- Experimental Java-Based JIT Compiler
- Root Certificates
- Time-Based Release Versioning

## Local Variable Type Inference

Type inference is a concept that allows a compiler to infer the type of variable or data. Java already uses type inference in collections and anonymous inner class using <> diamond operator. In Java 10 version, this feature is enhanced to extend type inference to declarations of local variables with initializers.

It means now we can create local variables without specifying its type (int, float, etc) . We can declare local variables, variable in for each-loop, for-loop but can not be used for method parameters, method return types, fields, or any other kind of variable declaration.

Example: Local Variable in Java 10

```java
// Valid Declarations

var a = 10;
var str = "studytonight";
```

## Consolidate the JDK Forest into a Single Repository

Java 10 simplified the JDK Forest repository into a single one in order to simplify and streamline development.

In previous versions of Java, JDK has been broken into several repositories. Such as JDK 9 consists of eight repositories: root, nashorn, jaxp, jaxws, JDK, CORBA, hotspot, and langtools.

In Java 10, all the eight repositories have collected into a single repository.

See the below example, how the JDK Forest repository is combined into a single repository.

```sh
$ROOT/jdk/src/java.base
...
$ROOT/langtools/src/java.compiler
...
```

See the below example, how the JDK Forest repository is combined into a single repository.

```sh
$ROOT/src/java.base
...
$ROOT/src/java.compiler
...
```

## Garbage-Collector Interface
Java 10 includes a new cleaner Garbage-Collector to improve the source code isolation of different garbage collectors. Java introduced a clean garbage collector interface that helps to implement new collectors and makes code much cleaner, simpler.

In older versions of JDK, Garbage Collector (GC) components were scattered throughout various parts of the codebase. But in Java 10, it is a clean interface within the JVM source code to allow alternative collectors to be quickly and easily integrated.

## Parallel Full GC for G1
In Java 9, the G1 was the default garbage collector. Now, this default GC is a parallel collector and has a parallel full GC. Initially, the G1 garbage collector did not work as full collections, but later on, it was allowed to reclaim memory fast enough. The G1 uses a single-threaded mark-sweep-compact algorithm.

## Application Class-Data Sharing
Class-Data Sharing also known as CDS is designed to improve startup and footprint that extend the existing CDS feature to allow application classes to be placed in the shared archive. Its intention was to reduce footprint by sharing common class metadata across different Java processes.

It improves startup time and allows archived classes from the JDK's run-time image file and the application classpath to be loaded into the built-in platform.

The CDS concept was introduced in JDK 5 that allows a set of classes to be pre-processed into a shared archive file. That helps to reduce startup time and can also reduce dynamic memory footprint when multiple JVMs share the same archive file.

The latest CDS version only allows the bootstrap class loader to load archived classes and the application CDS extends CDS to allow the built-in system class loader.

## Thread-Local Handshakes
In Java 10, Java introduces a new way to execute a callback without performing a global VM safepoint on threads. A callback can be a handshake operation that executes for each JavaThread while the thread is in a safe state.

A callback can be executed either by the virtual machine thread or itself while the thread is in a blocked state.

We can understand safe pointing and handshaking as thread operation will be performed on all threads as soon as possible and they will continue to execute as soon as its own operation is completed. It can perform a handshake with the single JavaThread as well.

## Remove the Native-Header Generation Tool (javah)
Javah is a Java tool that is used to generate header files. In Java 10, javah has been removed from the JDK.

In JDK 8, superior functionality was added to javac that superseded to javah. This functionality provides the ability to write native header files at the time that Java source code is compiled. So no further need for javah tool.

## Additional Unicode Language-Tag Extensions
Java 10 improved and enhanced java.util.Locale and related APIs to implement additional Unicode extensions. It provides support for BCP 47 language tags that were initially added in Java SE 7 version, with support for the Unicode locale extension limited to calendars and numbers.

Till JDK 9, the supported BCP 47 U language-tag extensions are ca and nu but in Java 10, the following additional extensions are supported:

- cu (currency type)
- fw (first day of the week)
- rg (region override)
- tz (time zone)

## Experimental Java-Based JIT Compiler
In Java 10, we can use Java-based JIT compiler, Graal as an experimental JIT compiler on the Linux platform. To enable Grall as a JIT compiler, use the following command:

-XX:+UnlockExperimentalVMOptions -XX:+UseJVMCICompiler
It will enable Graal as an experimental JIT compiler in the Linux/x64 platform. Graal will use the JVM compiler interface introduced in JDK 9.

## Root Certificates
Oracle has released the Root Certificate of Java SE CA program to Open-source to make OpenJDK builds more attractive and available to the developers. It will help to reduce the differences between OpenJDK builds and Oracle JDK builds.

The Open-Source Root Certificate must be signed by the Oracle Contributor Agreement (OCA), or an equivalent agreement, to grant Oracle the right to open-source their certificates. If the Root Certificate does not sign an agreement then will not be included at this time.

## Time-Based Release Versioning
Java 10 will use a time-based release version model that defines feature releases, which can contain new features and update releases.

It is helpful to understand how old a release is so that developer can decide whether to upgrade it to a newer release with the latest security fixes and updates.

## Format of version numbers in the six-month release model Java 10:
Java uses the following three elements of version numbers under the six-month release model:

- $FEATURE: This element represents the added feature and is incremented every six months: For example, March 2018 release is JDK 10, the September 2018 release is JDK 11.
- $INTERIM: For the six-month release model, it is always zero, since the six-month model does not include interim releases. It is reserved here for future flexibility.
- $UPDATE: It is incremented one month after $FEATURE is incremented, and every three months thereafter: The April 2018 release is JDK 10.0.1, the July release is JDK 10.0.2, and so forth.
