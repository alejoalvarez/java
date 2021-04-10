# Synchronized

Problem:

While working in a multi-threaded environment, there are some situations when multiple threads in a single program try to access the same resource at the same time. This situation of concurrency issues may result in unexpected and erroneous results.

For example, there is a file, and two or more threads are trying to write the data in the same file at the same time. This concurrent situation may lead to a condition where one thread is trying to open the file while another thread is trying to close it. In this case, neither thread can operate on the file. And, if the thread has access to the file, it can override the data that is already written by another thread, this may eventually corrupt the data.

To overcome this situation, we need to make sure that at a time only a single thread can access the resource at a given point of time. For this, Java provides a mechanism of synchronization that helps to avoid such race conditions by providing synchronized thread access to the shared resource or data. In this article, we will study the synchronized keyword in Java that helps us to implement the synchronization in Java. We will also learn how to use the synchronized keyword in Java with examples and many more things about this keyword.

## Synchronized keyword
As Java is a multi-threaded language, it supports a very important concept of Synchronization. The process of allowing only a single thread to access the shared data or resource at a particular point of time is known as Synchronization. This helps us to protect the data from the access by multiple threads. Java provides the mechanism of synchronization using the synchronized blocks.

We declare all synchronized blocks in Java are using a synchronized keyword. A block that is declared with a synchronized keyword ensures that only a single thread executes at a particular time. No other thread can enter into that synchronized block until the thread inside that block completes its execution and exits the block.

## Methods of Synchronized

- Synchronized instance methods
- Synchronized  static methods
- The Synchronized block inside Instance Methods
- The Synchronized block inside static methods

## Types of Synchronization

There are two types of synchronization in Java. They are:

- Process Synchronization
- Thread Synchronization

**Process Synchronization**

Process Synchronization is the term used to define Sharing the resources between two or more processes and meanwhile ensuring the inconsistency of data. In a programming language, the piece of code that is being shared by different processes is called the Critical Section. There are many solutions to avoid critical section problem like Peterson’s Solution, the most popular way to deal with this is Semaphores.

**Thread Synchronization**
The concurrent execution of the critical resource by two or more Threads is termed as Thread Synchronization. Thread is the subroutine that can execute independently within a single process. A single process can contain multiple threads and the process can schedule all the threads for a critical resource. In fact, a single thread also contains multiple threads.

```Synchronized Instance methods```

When we use a synchronized block with the instance methods, then each object has its synchronized method. There can be only one thread for each object, that can execute inside a method. If there is more than one object, then only a single thread can execute inside the block for each object.

```java
public class Main {
  private int count = 0;
  public synchronized void increment(int value) {
    this.count += value;
  }
  public synchronized void decrement(int value) {
    this.count -= value;
  }
}
```

```Synchronized Static Methods```

We can mark the Static methods as synchronized just like we mark the instance methods using the synchronized keyword. Below is an example of a Java synchronized static method:

```java
public static Main {
  private static int count = 0;
  public static synchronized void increment(int value) {
    count += value;
  }
}
```

```Synchronized block inside Instance Methods```

If you do not want to synchronize the whole method, you can just make a particular block inside the method as synchronized. Below is the example of a synchronized block of Java code inside an unsynchronized Java method:

```java
public void increment(int value) {
  synchronized(this) {
    this.count += value;
  }
}
```

```The synchronized block inside Static Methods```
We can also use the Synchronized blocks inside the static methods. Below is the example of using a synchronized block inside the static method:

```java
public class Main {
  public static void print(String message) {
    synchronized(MyClass.class) {
      log.writeln(message);
    }
  }
}
```


Example of Java synchronized in Multithreading

```java
// A Class used to send a message 
class Sender 
{ 
  public void sendMessage(String message)
  { 
    System.out.println("\nSending "  + message);
    try
    { 
      Thread.sleep(1000); 
    } 
    catch (Exception e) 
    { 
      System.out.println("Thread interrupted."); 
    } 
    System.out.println("\n" +message+ "Sent");
  }
} 
// Class for sending a message using Threads 
class SendUsingThreads extends Thread 
{ 
  private String message; 
  Sender sender; 
  // Receives a message object and a string message to be sent 
  SendUsingThreads(String msg, Sender object)
  { 
    message = msg;
    sender = object; 
  } 
  public void run() 
  { 
    // This will ensure that only one thread sends a message at a time. 
    synchronized(sender) 
    { 
      // synchronizing the send object 
      sender.sendMessage(message);
    } 
  } 
} 
// Driver class 
public class Demo
{ 
  public static void main(String args[]) 
  { 
    Sender sender = new Sender(); 
    SendUsingThreads sender1 = new SendUsingThreads( "Hello " , sender);
SendUsingThreads sender2 =  new SendUsingThreads( "Welcome to Java Tutorials ", sender);
    // Start two threads of SendUsingThreads type 
    sender1.start(); 
    sender2.start(); 
    // wait for threads to end 
    try
    { 
      sender1.join(); 
      sender2.join(); 
    } 
    catch(Exception e) 
    { 
      System.out.println("Interrupted"); 
    } 
  } 
} 

// RESULT
Sending Hello
Hello Sent
Sending Welcome to TechVidvan Tutorials
Welcome to TechVidvan Tutorials Sent
```

## Important points of synchronized keyword
- Synchronized keyword in Java ensures that only a single thread can access shared data at a time.
- Using Java synchronized keyword, we can only make a block or a method as synchronized.
- A thread acquires a lock when it gets inside a synchronized block. And, after leaving that method, the thread releases that lock.
- If we try to use a null object in the synchronized block then we may get a NullPointerException.
- Using the Java synchronized keyword, we cannot use more than one JVM to provide access control to a shared resource.
- The performance of the system can degrade due to the slow working of the synchronized keyword.
- We should prefer to use the Java synchronized block rather than the Java synchronized method.
- If we do not implement the synchronization properly in our code, then this might result in deadlock or starvation.
- It is illegal to use a synchronized keyword with the constructor in Java. Also, you can not use the synchronized keyword with the variables in Java.
- There are some important methods defined in the Object class that we can use while implementing synchronization in Java that are wait(), notify(), and notifyAll().

