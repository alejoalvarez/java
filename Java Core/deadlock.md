# How to avoid Deadlock in Java

We know that Java supports one of the most significant programming concepts which is multithreading. **Multithreading** is a process of executing multiple threads at the same time.

But again, all things have some bad parts too, and multithreading can not run away from this fact; as due to certain shortcomings, sometimes many threads go into the waiting state forever and can not be executed, and are blocked forever, and cause a condition of deadlock in Java.

# What is a Deadlock in Java?

Deadlock in Java is a condition when two or more threads try to access the same resources at the same time. Then these threads can never access the resource and eventually go into the waiting state forever.

So, the deadlock condition arises when there are more than two threads and two or more than two resources. Basically, a deadlock occurs when multiple threads request for the same resource but they are received in a different order.

Eventually, they get stuck for an infinite period of time and cause a deadlock.



## Deadlock Example in Java

You should run this program on the command prompt and not on any IDE.

```java
public class DeadlockDemo {
  public static void main(String[] args){
    final String resource1 = "Alejo ";
    final String resource2 = "Java Tutorial";

    Thread t1 = new Thread() {
      public void run() {
        synchronized(resource1) {
          System.out.println("Thread 1: Locked resource1");
          try {
            Thread.sleep(100);
          }
          catch(Exception e) {}
          synchronized(resource2) {
            System.out.println("Thread 1: Locked resource2");
          }
        }
      }
    };
    Thread t2 = new Thread() {
      public void run() {
        synchronized(resource1) {
          System.out.println("Thread 2: Locked resource1");
          try {
            Thread.sleep(100);
          } catch(Exception e) {}
          synchronized(resource2) {
            System.out.println("Thread 2: Locked resource2");
          }

        }
      }
    };

    t1.start();
    t2.start();
  }
}
```

# How to Detect Deadlock in Java?

We can also detect deadlock in our system by running the above program and looking at the Java Thread Dump of the application.

We can run the program in command prompt and collect the thread dump and depending upon the Operating system, we can generate the thread dump using commands.

To get the PID of the process, we type jps command and then we get the PID of the running process. Now to get the thread dump we will write the jcmd PID Thread.dump command to detect the deadlock. We can also get this dump file in a text file.

Though it is not possible to completely get rid of the deadlock problem in java still we can take precautions to avoid such deadlock conditions. These preventive measures are as follows:

**By avoiding Nested Locks**

Using nested locks can be the main cause of the occurrence of deadlocks in Java, We can avoid the use of nested locks to prevent the deadlocks in Java.

Nested locks mean we try to provide access to resources to multiple threads. If we have already assigned one lock to a thread then we should avoid giving it to the another thread

**By avoiding unnecessary locks**

We should also avoid giving locks to members or threads which do not need it. We should only provide the lock to the important threads and avoid using unnecessary locks.

If we provide an unnecessary lock to a thread that does not really need it, then it may cause a condition of deadlock.

**By using Thread join**

The condition of deadlock usually occurs when one thread is waiting for another thread to complete its execution and occupy that resource.

In this situation, we can use the Thread.join() method and give it a maximum time which a thread approximately takes to finish the execution. This can help us from removing the risk of deadlock in Java.

# Important points about Deadlock

- If two or more than two threads are waiting for the same resource or lock, then such a condition is deadlock in Java.
- The condition of deadlock occurs only in a multithreaded environment where multiple threads are executed simultaneously.
- Deadlock can even destroy our business logic and break our code at runtime.
- We can detect the deadlock in any java application using some command depending upon the Operating System that we are using.
- We can also avoid the situation of deadlock by following some preventive measures.