# Garbage Collector

- It is a background thread (Java runs it automatically).
- The garbage collector locks the threads of all processes in order to clean the memory.
- Garbage Collection is one of the most important features in Java.
- Garbage collection is the technique used in Java to deallocate or remove unreachable objects and unused memory.
- Garbage Collection tracks each object available in the JVM heap space and removes the unused ones.
- The implementation of the Garbage Collection is present in the JVM (Java Virtual Machine).

## Types of garbage collection

- (SGC) - Serial Garbage Collector
- (PGC) - Parallel Garbage Collector
- (CMS GC) - Concurrent Mark Sweep Garbage Collector
- (G1 GC) - Garbage First Garbage Collector

### Serial garbage collector

- It is the simplest Garbage Collector implementation as it basically works with a single thread and all the garbage collection events are conducted serially in one thread.
- As this collector can work on a single thread, it freezes all application threads when it runs.
- Designed for single process applications

Enable Serial Garbage Collector:
```
java -XX:+UseSerialGC -jar Application.java
```

### Parallel Garbage Collector

- It is the default Garbage Collector of the JVM and sometimes called Throughput Collectors.
- Unlike the Serial Garbage Collector, the Parallel Garbage Collector uses multiple threads to manage heap space. But at the same time, it also suspends other application threads while performing garbage Collection.
- Using this Garbage Collector, we can specify the maximum garbage collection threads throughput and footprint (heap size) and, pause time.

Enable Parallel Garbage Collector:
```
java -XX:+UseParallelGC -jar Application.java
```

### CMS Garbage Collector

- The CMS Garbage Collection implementation uses multiple threads for garbage collection.
- This Garbage Collector is designed for applications that can afford to share processor resources with the garbage collector while the application is running and that prefer shorter garbage collection pauses. Simply we can say that applications using CMS respond slower on average but do not stop responding to perform garbage collection.
- Uses more CPU
- Only block the process when it is necessary

Enable the CMS Garbage Collector:

```
java -XX:+UseParNewGC -jar Application.java
```

### G1 Garbage Collector

G1 (Garbage First) Garbage Collector is the newest garbage collector which is designed as a replacement for CMS. It performs more efficiently as compared to CMS Garbage Collector. It is similar to CMS and is designed for applications running on multiprocessor machines with large memory space.

Enable the G1 Garbage Collector
```
java -XX:+UseG1GC -jar Application.java
```

## Advantages of Garbage Collection:
- There is no need to manually handle the memory allocation/deallocation because the JVM automatically performs the Garbage Collection for unused space in Java.
- There is no overhead of handling the Dangling Pointer.
- Garbage Collection takes care of a good portion of Automatic Memory Leak management.

## Disadvantages of Garbage Collection:
- There is a more requirement of CPU power besides the original application, as JVM has to keep track of object reference creation/deletion. This may affect the performance of requests which require a huge memory.
- Programmers do not have any control over the scheduling of CPU time dedicated to freeing the unreachable objects.
- Using some Garbage Collection implementations an application may stop unpredictably.
- Automatic memory management is not much efficient proper manual memory allocation/deallocation.