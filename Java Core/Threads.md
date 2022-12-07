# Threads

Threads allows a program to operate more efficiently by doing multiple things at the same time.

Threads can be used to perform complicated tasks in the background without interrupting the main program.

## What is a Java Thread?

A thread is just a single lightweight and smallest part of a process. It is the smallest unit of a process that can run concurrently with the other parts (other threads) of the same process.

There can be multiple processes in an Application. Each process can have a single thread or multiple threads. Multithreading is the process of concurrent execution of multiple threads.

There is a common memory area for all threads of a process but each of them is independent of each other because they all have separate paths of execution. Therefore, if an exception occurs in one thread, it does not affect the execution of other threads.

- Threads allows a program to operate more efficiently by doing multiple things at the same time.
- Threads can be used to perform complicated tasks in the background without interrupting the main program.

<p align="center">
<img width="471" src="https://user-images.githubusercontent.com/13514156/206207361-f941fe91-83b7-45c1-af89-388469c7bfdd.png">
</p>

The above figure shows that a thread executes inside the process. There is context-switching between the threads. There can be multiple processes inside the Operating System, and there can be multiple threads in one process.

***Note:** At a time only a single thread can be executed.*

Multithreading is another important feature of Object-Oriented Programming. Multithreading in Java helps more than two programs simultaneously execute and we can utilize the capacity of CPU.

## Multitasking vs Multithreading vs Multiprocessing vs Multiprogramming

**Multitasking:** Multitasking is the capability of an Operating System to execute more the one task or job simultaneously on a shared resource.

<p align="center">
<img width="471" src="https://user-images.githubusercontent.com/13514156/206207691-327fdc27-4f84-4823-907f-f78b133cd95e.png">
</p>

**Multithreading:** Multithreading is the ability of an Operating System to execute more than one thread at the same time. Here, a single process is divided into multiple threads.

<p align="center">
<img width="471" src="https://user-images.githubusercontent.com/13514156/206207859-243b59fc-cdf3-4d51-99d0-dfefaa90bf19.png">
</p>

**Multiprocessing:** It is similar to multitasking but here there is more than one processor or CPU. Therefore, multiple processes can execute with the multiple processors at the same time.

<p align="center">
<img width="471" src="https://user-images.githubusercontent.com/13514156/206207999-4b9f00fa-33b8-448c-9744-3e8b65b36746.png">
</p>

**Multiprogramming:** Multiprogramming is the ability to run more than one program at the same time within a single machine. For example, running Excel and Firefox simultaneously.

<p align="center">
<img width="471" src="https://user-images.githubusercontent.com/13514156/206208196-e317de0a-c72b-482c-90fa-067075e68793.png">
</p>

# Thread Priorities in Java

With the creation of Java thread, the JVM assigns it some priority that helps the operating system determine the order of scheduling the threads. We can also set the priority of the thread in an explicit manner.

The valid range of a priority of a thread is from 1 to 10. Threads that have higher priorities should be allocated before the threads with the lower priorities.

## Constants of defining Thread Priorities

There are 3 types of static variables or values for defining Thread priorities. The table shows these variables:

| Variable | 	Description |
|---|---|
| public static int MIN_PRIORITY | The minimum priority of a thread with value = 1 |
| public static int NORM_PRIORITY | The default priority of a thread with value = 5 |
| public static int MAX_PRIORITY | The maximum priority of a thread with value = 10 |

## Java Thread Life-Cycle

<p align="center">
<img width="471" src="https://user-images.githubusercontent.com/13514156/206208475-a96e7aee-e6a1-4308-8a9a-99aa78f2cf4f.png">
</p>

Threads exist in several states. The above figure shows the various stages of the thread which are:

- New state
- Runnable state
- Running state
- Waiting state
- Dead state

**New**
The thread is the new state when we create it using the “Thread class”. It remains in this state until the program starts the thread by calling the start() method. It is also called a born thread.

**Runnable**
In this phase, the start() method invokes the instance of the thread. The scheduler takes the thread control to finish the execution. It depends on the scheduler whether to run the thread or not.

**Running**
The thread goes to the running state when its execution starts. The scheduler selects one thread from the thread pool and the thread starts executing in the application.

**Waiting**
There is a need for synchronization between threads as multiple threads are running in the application. Hence, one thread has to wait, till the other thread finishes its execution. Therefore, we say that the thread is in the waiting state.

**Dead**
When the thread is terminated, the thread goes into the dead state.


# Advantages of the single thread

The benefits of using threads are:

- A thread reduces the overhead in the application as a single thread runs in the system
- A single thread reduces the maintenance cost of the application.
- Threads have a shared memory area so they help to save memory.
- Context-switching between the threads takes less time than the process.


## Methods of Thread Class in Java

The following list shows some important methods available in the Thread class.

| Method | 	Description |
|---|---|
|public void start() |	This method begins the thread execution in a separate path and then calls the run() method on the current Thread object.|
|public void run()	| Runnable object invokes this method if we instantiate this Thread object using a separate Runnable target.|
|public final void setName(String name)	| This method changes the name of the Thread object. |
|public final void setPriority(int priority)	| We use this method to set the priority of this Thread object. We can use possible values between 1 and 10.|
|public final void join(long millisec)	| The current thread calls this method on a second thread and causes the current thread to block until the second thread terminates for the specified number of milliseconds passes.|
|public void interrupt()	| This method interrupts the current thread and causes it to continue execution if it had been blocked for any reason.|
|public final boolean isAlive()	| It returns true if the thread is alive or is still running, else it returns false.|
|public static void yield()	| It causes the currently running thread to yield to any other threads of the same priority that are waiting for being scheduled.|
|public static void sleep(long millisec) |	It halts the currently running thread for at least the specified number of milliseconds.|
|public static Thread currentThread()	| It returns a reference to the currently running thread, i.e the thread that invokes this method |

# How to Achieve Multithreading in Java?

We can achieve multithreading in Java in two ways:

- By Implementing the **Runnable** Interface
- By extending **Thread** class

## Implementing the Runnable Interface in Java

Creating a class by **Implementing the Runnable interface** is the simplest way to create a thread. To do this we need a class that implements a single method called **run( ).** To create a thread using a Runnable interface, you will need to follow three basic steps:

**Step 1**

In the first step, you need to implement the run() method of the Runnable interface. This method acts as an entry point for the thread and your complete business logic will be present inside this method. The syntax of the run() method is as follows:

```java
public void run( )
```
**Step 2**

In the second step, you will instantiate a Thread object using the following constructor:

```java
Thread(Runnable threadObject, String threadName);
```

Where threadObject is an instance of a class that implements the Runnable interface and threadName is the name of the new thread.

**Step 3**

Once you create a Thread object, you can start it by calling the start() method, which makes a call to the run( ) method. Following is a simple syntax of the start() method:

```java
void start();
```

```java
class MultithreadingDemo implements Runnable{
  public void run(){
    try{
      System.out.println ("Thread " +Thread.currentThread().getId() +" is running");
    } catch (Exception e){
      System.out.println("Exception caught");
    }
  }
}

public class ImplementingRunnableInterface{
  public static void main(String args[]){
    for (int count=0; count<5; count++){
      Thread object = new Thread(new MultithreadingDemo());
      object.start();
    }
  }
}
```

## Extending the Thread class

We can also create a thread by creating a new class that extends the Thread class. Then, this class overrides the run() method and then we create an instance of this class. When you call the start() method, the run() method executes.

Creating thread using Thread class is more flexible than creating it through the Runnable interface Because it is easy to handle multiple created threads using available methods in Thread class.

Here is a simple step-by-step process of creating a Java Thread subclass:

**Step 1**

As the first step, you need to override the run( ) method of the Thread class. This method is an entry point for the thread and all the business logic is present inside this method.

The syntax of the run() method is as follows:


```java
public void run( );
```

**Step 2**

Once you create an object of the Thread subclass, you can start it by calling the start() method, which makes a call to the run( ) method. Following is a simple syntax of the start() method:

```java
void start( );
```

```java
class MultithreadingDemo extends Thread{
  public void run(){
    try{
      System.out.println("Thread " +Thread.currentThread().getId() +" is running");
    }catch (Exception e){
      System.out.println("Exception caught");
    }
  }
}

public class ExtendingThreadClass{
  public static void main(String[] args){
    for (int count=0; count<5; count++){
      MultithreadingDemo object = new MultithreadingDemo();
      object.start();
    }
  }
}
```


## Creating a Thread
There are two ways to create a thread.

It can be created by extending the Thread class and overriding its **run()** method:

Syntax:
```java
public class Main extends Thread {
  public void run() {
    System.out.println("This code is running in a thread");
  }
}
```

Another way to create a thread is to implement the ```Runnable``` interface:

Syntax:
```java
public class Main implements Runnable {
  public void run() {
    System.out.println("This code is running in a thread");
  }
}
```

## Running Threads
If the class extends the Thread class, the thread can be run by creating an instance of the class and call its **start()** method:

Example
```java
public class Main extends Thread {
  public static void main(String[] args) {
    Main thread = new Main();
    thread.start();
    System.out.println("This code is outside of the thread");
  }
  public void run() {
    System.out.println("This code is running in a thread");
  }
}
```

If the class implements the Runnable interface, the thread can be run by passing an instance of the class to a Thread object's constructor and then calling the thread's start() method:

Example
```java
public class Main implements Runnable {
  public static void main(String[] args) {
    Main obj = new Main();
    Thread thread = new Thread(obj);
    thread.start();
    System.out.println("This code is outside of the thread");
  }
  public void run() {
    System.out.println("This code is running in a thread");
  }
}
```

## Differences between "extending" and "implementing" Threads

The major difference is that when a class extends the Thread class, you cannot extend any other class, but by implementing the Runnable interface, it is possible to extend from another class as well, like: class MyClass extends OtherClass implements Runnable.
	
## Concurrency Problems
Because threads run at the same time as other parts of the program, there is no way to know in which order the code will run. When the threads and main program are reading and writing the same variables, the values are unpredictable. The problems that result from this are called concurrency problems.

Example
A code example where the value of the variable amount is unpredictable:

```java	
public class Main extends Thread {
  public static int amount = 0;
	public static void main(String[] args) {
    Main thread = new Main();
    thread.start();
    System.out.println(amount);
    amount++;
    System.out.println(amount);
  }
	public void run() {
    amount++;
  }
}
```

To avoid concurrency problems, it is best to share as few attributes between threads as possible. If attributes need to be shared, one possible solution is to use the isAlive() method of the thread to check whether the thread has finished running before using any attributes that the thread can change.

Example

Use **isAlive()** to prevent concurrency problems:

```java
public class Main extends Thread {
    public static int amount = 0;
    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();
        // Wait for the thread to finish
        while(thread.isAlive()) {
        System.out.println("Waiting...");
    }
    // Update amount and print its value
    System.out.println("Main: " + amount);
    amount++;
    System.out.println("Main: " + amount);
    }
    public void run() {
        amount++;
}
}
```
