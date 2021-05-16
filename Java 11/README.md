# Table of Contents
* [String New Methods](https://github.com/alejoalvarez/Java/blob/main/Java%2011/StringNewMethods.md)
* [Files New Methods](https://github.com/alejoalvarez/Java/blob/main/Java%2011/FilesNewMethods.md)
* [Var in lambda expression](https://github.com/alejoalvarez/Java/blob/main/Java%2011/Var-LambdaExpression.md)
* [Nest-Based Access Control](https://github.com/alejoalvarez/Java/blob/main/Java%2011/Nest-Based-Access-Control.md)
* [HTTP Client API](https://github.com/alejoalvarez/Java/blob/main/Java%2011/HTTP-Client-API.md)

* [JEP 309: Dynamic Class-File Constants](https://openjdk.java.net/jeps/309)
- Extends class-file format to support a new constant-pool form, CONSTANT_Dynamic, target language designers and compiler implementors

* [JEP 315: Improve Aarch64 Intrinsics](https://openjdk.java.net/jeps/315)
- Optimized the existing string and array intrinsics, and implements new intrinsics for Math.sin(), Math.cos() and Match.log() on Arm64 or Aarch64 processors. it means better performance.
- An intrinsic is used to leverage CPU architecture-specific assembly code to improve the performance.

* [JEP 318: Epsilon: A No-Op Garbage Collector (Experimental)](https://openjdk.java.net/jeps/318)
- A new No-Op (no operations) Garbage Collector, it allocates memory but will not collect any garbage (memory allocation), once the Java heap is exhausted, the JVM will shut down.
- A few use cases:

    - Performance testing
    - VM interface testing
    - Short-lived jobs

This GC is an experimental feature; we need to use the following options to enable the new Epsilon GC.

```java
-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC

```

* [JEP 320: Remove the Java EE and CORBA Modules](https://openjdk.java.net/jeps/320)
Java 9 deprecated the following Java EE and CORBA modules and now removed in Java 11. If you want to migrate to Java 11, make sure your project didn’t use any of the following packages or tools.

Removed packages:
- java.xml.ws (JAX-WS)
- java.xml.bind (JAXB)
- java.activation (JAF)
- java.xml.ws.annotation (Common Annotations)
- java.corba (CORBA)
- java.transaction (JTA)
- java.se.ee (Aggregator module for the six modules above)

Removed Tools:
- wsgen and wsimport (from jdk.xml.ws)
- schemagen and xjc (from jdk.xml.bind)
- idlj, orbd, servertool, and tnamesrv (from java.corba)

* [JEP 331: Low-Overhead Heap Profiling](https://openjdk.java.net/jeps/331)
Java Virtual Machine Tool Interface (JVMTI) was introduced in J2SE 5, JDK 5 (Tiger), it provides APIs for profiling or monitoring tools to access the JVM state. This JEP added new low overhead heap profiling API into the JVMIT.

* [JEP 332: Transport Layer Security (TLS) 1.3](https://openjdk.java.net/jeps/332)
```java
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

SSLSocketFactory factory =
        (SSLSocketFactory) SSLSocketFactory.getDefault();
socket =
        (SSLSocket) factory.createSocket("google.com", 443);

socket.setEnabledProtocols(new String[]{"TLSv1.3"});
socket.setEnabledCipherSuites(new String[]{"TLS_AES_128_GCM_SHA256"});
```

* [JEP 333: ZGC: A Scalable Low-Latency Garbage Collector (Experimental)](https://openjdk.java.net/jeps/333)

The Z Garbage Collector (ZGC) is an experimental garbage collector; it has low pause times not exceed 10ms. This ZCG support only on Linux/64.

In Java 14, this ZCG extends support on macOS JEP 364 and Windows JEP 365.
This ZGC garbage collector is a product feature in Java 15 JEP 377.
