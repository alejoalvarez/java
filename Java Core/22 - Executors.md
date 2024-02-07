# Executors (pool threads)

It is easier for us to create and execute one or two threads simultaneously. But when the number of threads increases to a significant number, it becomes difficult. Many multi-threaded applications have hundreds of threads running simultaneously. Therefore, there is a need to separate the creation of the thread from the management of thread in an application.

The Java ExecutorService interface is in the java.util.concurrent package. This interface represents an asynchronous execution mechanism to execute several tasks concurrently in the background.

## Tasks performed by ExecutorService
The executor service framework helps in creating and managing threads in an application. The executor framework performs the following tasks.

- Thread Creation: Executor service provides many methods for the creation of threads. This helps in running applications concurrently.
- Thread Management: Executor service also helps in managing the thread life cycle. We need not worry if the thread is in the active, busy, or dead state before submitting the task for execution.
- Task Submission And Execution: Executor framework also provides methods to submit tasks in the thread pool. It also provides the power to decide whether the thread will execute or not.


### Task Delegation

<p align="center">
<img src="https://user-images.githubusercontent.com/13514156/120513972-66118d80-c392-11eb-95ad-5dc1f711dd7e.png">
</p>

### Creating an ExecutorService


ExecutorService is an interface in Java. The implementations of this interface can execute a Runnable or Callable class in an asynchronous way. We have to note that invoking the run() method of a Runnable interface in a synchronous way is calling a method.

We can create an instance of ExecutorService interface in the following ways:

**Executors class**
Executors class is a utility class that provides factory methods to create the implementations of the Executor service interface.

```java
//Executes only one thread
ExecutorService es = Executors.newSingleThreadExecutor();
//Internal management of thread pool of 2 threads
ExecutorService es = Executors.newFixedThreadPool(2);
//Internally managed thread pool of 10 threads to run scheduled tasks
ExecutorService es = Executors.newScheduledThreadPool(10);
```

**Constructors**
The below statement creates a thread pool executor. We create it using the constructors with minimum thread count 10. The maximum thread count is 100. The keepalive time is five milliseconds. And, there is a blocking queue to watch for tasks in the future.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;

ExecutorService exService = new ThreadPoolExecutor(10, 100, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue < Runnable > ());
```

**ExecutorService Implementations**

ExecutorService is very similar to the thread pool. The implementation of the ExecutorService in the java.util.concurrent package is a thread pool implementation. There are following implementations of ExecutorService in the java.util.concurrent package:

## ThreadPoolExecutor
The ThreadPoolExecutor executes the specified tasks using one of its internally pooled threads.

<p align="center">
<img src="https://user-images.githubusercontent.com/13514156/120514020-74f84000-c392-11eb-8091-08875e6aa570.png">
</p>

**Creating a threadPoolExecutor**

```java
int coreThreadPoolSize = 10;
int maxPoolSize = 15;
long keepAliveTime = 6000;

ExecutorService es = new threadPoolExecutor(coreThreadPoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue < Runnable > ());
```

## ScheduledThreadPoolExecutor

The ScheduledThreadPoolExecutor is an ExecutorService that can schedule tasks to run after a delay or to execute repeatedly with a fixed interval of time in between each execution.

**Creating a ScheduledThreadPoolExecutor**

```java
ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable() {
  public Object call() throws Exception {
    System.out.println("executed");
    return "called";
  }
}, 5, TimeUnit.SECONDS);
```

## ExecutorService Usage in Java

The following are the different ways to delegate tasks for execution to an ExecutorService:

- execute(Runnable)
- submit(Runnable)
- submit(Callable)
- invokeAny(…)
- invokeAll(…)

**Execute Runnable**

The ExecutorService **execute(Runnable)** method of Java takes an object of Runnable and executes it asynchronously.

```java
ExecutorService executorService = Executors.newSingleThreadExecutor();
executorService.execute(new Runnable() {
  public void run() {
    System.out.println("asynchronous task");
  }
});
executorService.shutdown();
```

**Submit Runnable**

The **submit(Runnable)** method takes a Runnable implementation and returns a Future object. We can use this Future object to check if the Runnable has finished executing.

```java
Future future = executorService.submit(new Runnable() {
  public void run() {
    System.out.println(" asynchronous task ");
}
});
future.get();
```

**Submit Callable**

The Java **submit(Callable)** method is similar to the submit(Runnable) method except it takes a Callable object instead of a Runnable. We can obtain the Callable’s result using the Java Future object returned by the submit(Callable) method.

```java
Future future = executorService.submit(new Callable() {
  public Object call() throws Exception {
    System.out.println("Asynchronous callable");
    return "Callable Result";
  }
});
System.out.println("future.get() = "
future.get());
```

**invokeAny()**

The **invokeAny()** method takes a collection or subinterfaces of Callable objects. This method returns the result of one of the Callable objects. There is no guarantee about which of the Callable results we will get.

```java
public class Main {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    
    ExecutorService es = Executors.newSingleThreadExecutor();

    Set < Callable < String >> callable = new HashSet < Callable < String >> ();
    callable.add(new Callable < String > () {
      public String call() throws Exception {
        return "Task 1";
      }
    });

    callable.add(new Callable < String > () {
      public String call() throws Exception {
        return "Task 2";
      }
    });

    callable.add(new Callable < String > () {
      public String call() throws Exception {
        return "Task 3";
      }
    });

    String result = es.invokeAny(callable);
    System.out.println("result = " + result);
    executorService.shutdown();
  }
}
```

**invokeAll()**

The **invokeAll()** method invokes all of the objects of Callable that we pass to it in the collection as parameters. This method returns a list of Future objects through which we can obtain the results of the executions of each Callable.

```java
public class Main {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Set < Callable < String >> callable = new HashSet < Callable < String >> ();
    
    callable.add(new Callable < String > () {
      public String call() throws Exception {
        return "Task 1";
      }
    });

    callable.add(new Callable < String > () {
      public String call() throws Exception {
        return "Task 2";
      }
    });

    callable.add(new Callable < String > () {
      public String call() throws Exception {
        return "Task 3";
      }
    });
    
    java.util.List < Future < String >> futures = executorService.invokeAll(callable);
    for (Future < String > future: futures) {
      System.out.println("future.get = " + future.get());
    }
    executorService.shutdown();
  }
}
```

## ExecutorService Shutdown in Java

When we compete using the Java ExecutorService we should shut it down, so the threads do not keep running. There are some situations when start an application via a main() method and the main thread exits our application. In such cases, the application will keep running if there is an active ExecutorService in the application. These active threads present inside the ExecutorService prevents the JVM from shutting down.

Let’s discuss the methods to shut down an Executor service:

1. shutdown() in Java
We call the shutdown() method to terminate the threads inside the ExecutorService. This does not shut down the ExecutorService immediately, but it will no longer accept new tasks. Once all the threads finish their current tasks, the ExecutorService shuts down. Before we call the shutdown() all tasks submitted to the ExecutorService are executed.

```java
executorService.shutdown();
````

2. shutdownNow() in Java
If we need to shut down the ExecutorService immediately, we can call the shutdownNow() method. This method will attempt to stop all executing tasks right away, and skip all the submitted but non-processed tasks. But, there will be no guarantee about the executing tasks. They may either stop or may execute until the end.

```java
executorService.shutdownNow();
```

3. awaitTermination() in Java
The ExecutorService awaitTermination() method blocks the thread calling it until either the ExecutorService has shutdown completely, or until a given time out occurs. The awaitTermination() method is typically called after calling shutdown() or shutdownNow().


```java
executorService.awaitTermination();
```

## Runnable vs. Callable Interface in Java

The Runnable interface is almost similar to the Callable interface. Both Runnable and Callable interfaces represent a task that a thread or an ExecutorService can execute concurrently. There is a single method in both interfaces. There is one small difference between the Runnable and Callable interface. The difference between both the interfaces is clearly visible when we see the interface declarations.

Here is declaration of the Runnable interface:

```java
public interface Runnable {
  public void run();
}
```

Here is declaration of the Callable interface:

```java
public interface Callable {
  public Object call() throws Exception;
}
```

The main difference between the run() method of Runnable and the call() method of Callable is that call() can throw an exception, whereas run() cannot throw an exception, except the unchecked exceptions – subclasses of RuntimeException. Another difference between call() and run() is that the call() method can return an Object from the method call.

Cancelling Task in Java
We can also cancel a Runnable or Callable task submitted to the ExecutorService of Java. We can cancel the task by calling the cancel() method on the Future. It is possible to cancel the task only if the task has not yet started executing.

For example:
```java
Future.cancel();
```


Example:

As an example of the previous entry, a product collection process was simulated in a supermarket in which two customers go with a cart full of products and a cashier (one thread) or two cashiers (two threads) pass the products through the scanner to charge them for the purchase. The products that customers carry were represented by an array of integers (int) in which each integer represented the seconds it took the cashier to process the product. The proposed example had a small drawback and that is that we put as many cashiers (or threads) as there were clients and therefore we put two cashiers to process the products of two clients, but what would happen if instead of two clients (2 processes) we had 100 clients? Would we have to put 100 cashiers (create 100 threads)? Another thing that was explained is that the threads are executions in parallel and these are closely linked to the number of cores (or process units) of our hardware (or computer) and therefore we must take into account the hardware resources when it comes to make our implementations with threads.

In summary, what we want to show in this post is how to manage the execution of threads. Suppose again the example of the supermarket, but in this case instead of having 2 customers, we will have 8 customers (8 processes) and two cashiers (2 threads). Obviously the clients have to be processed one by one, and therefore they must be queued and processed one by one. For this we could implement a system of "queues or stacks" for managing threads, but Java already provides us with the "ExecutorService" interface and the "Executors" class (which implements the ExecutorService interface) for managing threads. The "Executors" class is in charge of managing the execution of the threads based on the number of threads we use. To make a similarity with the example that we are going to put, the "Executors" class will be in charge of organizing the Clients' queue and sending the Clients to the corresponding Cashier when it has finished processing the previous Client's purchase. To do this, let's see the following example:

We define the Customer class with a "name" attribute and an array of integers, in which each integer represents a product in the cart and its value is the time it takes the cashier to scan the product; that is, if we have an array with [1,3,5] it will mean that the customer has bought 3 products and that the cashier will take to process product 1 '1 second', product 2 '3 seconds' and product 3 in '5 seconds', with which it will take to charge the customer for their entire purchase '9 seconds':

Client.java
```java
public class Client {
	private String name;
	private int[] shoppingCar;

	// Constructor, getter y setter
}
```

To use the Executors class, we must implement the "Runnable" class and not override (or inherit) from the "Thread" class, since the Executors class only manages classes with Runnable interface; therefore, we implement the Pocket class as follows:

CashierRunnable.java
```java
public class CashierRunnable implements Runnable {

	private Cliente client;
	private long initialTime;

	public CashierRunnable(Client client, long initialTime) {
		this.client = client;
		this.initialTime = initialTime;
	}

	@Override
	public void run() {
		System.out.println("The cashier " + Thread.currentThread().getName() 
				+ " start the process for client " + this.client.getName() 
				+ " in the time: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "sec");

		for (int i = 0; i < this.client.getShoppingCar().length; i++) { 			                     
                    this.waitXseconds(client.getShoppingCar()[i]);
               	    System.out.println("Processing the product " + (i + 1) + " for " + this.client.getName()+ 
                    "-> Time: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "sec");
		}

		System.out.println("The cashier " + Thread.currentThread().getName() + " Finish to process " 
				+ this.client.getName() + " at the time: "
				+ (System.currentTimeMillis() - this.initialTime) / 1000 + "sec");
	}

	private void waitXseconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

       // getter y setter
```

The Main class

```java
public class MainExecutor {
    
    private static final int numCashiers = 2;

    public static void main(String[] args) {

        ArrayList<Client>clients = new ArrayList<Client>();
        clients.add(new Client("Client 1", new int[] { 2, 2, 1, 5, 2 })); // 12 Sec
        clients.add(new Client("Client 2", new int[] { 1, 1, 5, 1, 1 })); //  9 Sec
        clients.add(new Client("Client 3", new int[] { 5, 3, 1, 5, 2 })); // 16 Sec
        clients.add(new Client("Client 4", new int[] { 2, 4, 3, 2, 5 })); // 16 Sec
        clients.add(new Client("Client 5", new int[] { 1, 3, 2, 2, 3 })); // 11 Sec
        clients.add(new Client("Client 6", new int[] { 4, 2, 1, 3, 1 })); // 11 Sec
        clients.add(new Client("Client 7", new int[] { 3, 3, 2, 4, 7 })); // 19 Sec
        clients.add(new Client("Client 8", new int[] { 6, 1, 3, 1, 3 })); // 14 Sec
        //  108 segundos
        
        long init = System.currentTimeMillis();
        
        ExecutorService executor = Executors.newFixedThreadPool(numCashiers);
        for (Client client: clients) {
            Runnable cashier = new CashierRunnable(client, init);
            executor.execute(cashier);
        }
        executor.shutdown();	// close the Executor
        while (!executor.isTerminated()) {
        	// Wait until the processe are finish    
        }
        
        long end = System.currentTimeMillis();	
        System.out.println(" Total processing time: " + (end-init)/1000 + " Seconds");
    }
}
```
