## Executors (pool threads)


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