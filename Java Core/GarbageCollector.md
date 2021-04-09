# Garbage Collector

Garbage Collection is one of the most important features in Java which makes it popular among all the programming languages. The process of garbage collection is implicitly done in Java. Therefore, it is also called Automatic Garbage Collection in Java. The programmer does not need to explicitly write the code to delete the objects.

Garbage collection is the technique used in Java to deallocate or remove unreachable objects and unused memory. From the name itself, we can understand that Garbage Collection deals with tracking and deleting the garbage from the memory area.

However, in reality, Garbage Collection tracks each and every object available in the JVM heap space and removes the unused ones.

We know that all the objects that we dynamically create are allocated in the heap memory of the application. Normally, it is the duty of the programmer to both create and delete the objects in the program, but the programmer usually ignores the deletion of the object. This creates a problem of OutOfMemoryErrors due to insufficient memory because of not deleting the unwanted objects.

In Java, the programmer does not have to worry about the problem of releasing the memory of these unused or unwanted objects, as the garbage collection system always runs in the background, and its main aim is to free the memory heap by deleting unreachable objects.

Essentially, Garbage Collection is the process of tracking down all the objects that are still in use and marking the rest of them as garbage. The Garbage Collection process in Java is considered an automatic memory management schema because programmers do not have to explicitly deallocate the objects. The garbage collection in Java runs on low-priority threads.

The implementation of the Garbage Collection is present in the JVM (Java Virtual Machine). Each JVM can implement garbage collection. But there is only one requirement; that it should meet the JVM specification. Oracle’s HotSpot is one of the most common JVMs that offers a robust and mature set of garbage collection options.

**Object Life Cycle in Java**
The object life cycle in Java can be divided into 3 stages:

1. Object Creation
To create an object, generally, we use a new keyword. For example:

```java
MyClass obj = new MyClass();
```

We created the object obj of class MyClass. When we create the object, a specific amount of memory is allocated for storing that object. The amount of memory allocated for objects can vary on the basis of architecture and JVM.

2. Object Usage
In this stage, the Object is in use by the other objects of the application in Java. During its usage, the object resides in memory and may refer to or contain references to other objects.

3. Object Destruction
The garbage collection system monitors objects and keeps a count on the number of references to each object. There is no need for such objects in our programs if there are no references to this object, so it makes perfect sense to deallocate this unused memory.

## Ways of requesting JVM to run Garbage Collector
Even if we make an object eligible for Garbage Collection in Java, it may or may not be eligible for Java Virtual Machine (JVM) to destroy. So there are some ways to request JVM to destroy this object and perform garbage collection.

There are two ways to request JVM for Garbage collection in Java which are:

- Using System.gc() method
- Using Runtime.getRuntime().gc() method

Example

```java
public class Main
{
  public static void main(String[] args) throws InterruptedException
  {
    Demo obj1 = new Demo();
    Demo obj2= new Demo();
    // requesting JVM for running Garbage Collector
    System.gc();
    // Nullifying the reference variable
    obj2 = null;
    // requesting JVM for running Garbage Collector
    Runtime.getRuntime().gc();
  }
  @Override
  // finalize method is called on object once before garbage collecting it
  protected void finalize() throws Throwable
  {
    System.out.println("Garbage Collector ");
    System.out.println("Garbage collected object: " + this);
  }
}
```

Before removing an object from memory, the garbage collection thread invokes the finalize() method of that object and gives an opportunity to perform any sort of cleanup required.

## Implementations or Types of Garbage Collection

JVM has four types of Garbage Collector implementations which are

- Serial Garbage Collector
- Parallel Garbage Collector
- CMS Garbage Collector
- G1 Garbage Collector

### Serial Garbage Collector

It is the simplest Garbage Collector implementation as it basically works with a single thread and all the garbage collection events are conducted serially in one thread. As this collector can work on a single thread, it freezes all application threads when it runs. Hence, it is not preferred to use it in multi-threaded applications like server environments.

We can use the following argument to enable Serial Garbage Collector:

```java
java -XX:+UseSerialGC -jar Application.java
```

### Parallel Garbage Collector
It is the default Garbage Collector of the JVM and sometimes called Throughput Collectors. Unlike the Serial Garbage Collector, the Parallel Garbage Collector uses multiple threads to manage heap space. But at the same time, it also suspends other application threads while performing garbage Collection. Using this Garbage Collector, we can specify the maximum garbage collection threads throughput and footprint (heap size) and, pause time.

We can use the following argument to enable Parallel Garbage Collector,

```java
java -XX:+UseParallelGC -jar Application.java
```

### CMS (Concurrent Mark Sweep) Garbage Collector
The CMS Garbage Collection implementation uses multiple threads for garbage collection. This Garbage Collector is designed for applications that can afford to share processor resources with the garbage collector while the application is running and that prefer shorter garbage collection pauses. Simply we can say that applications using CMS respond slower on average but do not stop responding to perform garbage collection.

We can use the following flag to enable the CMS Garbage Collector:

```java
java -XX:+UseParNewGC -jar Application.java
```

### G1(Garbage First) Garbage Collector
G1 (Garbage First) Garbage Collector is the newest garbage collector which is designed as a replacement for CMS. It performs more efficiently as compared to CMS Garbage Collector. It is similar to CMS and is designed for applications running on multiprocessor machines with large memory space.

To enable the G1 Garbage Collector, we can use the following argument:

```java
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