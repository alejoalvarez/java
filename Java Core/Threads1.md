## Threads Example

Multitasking and Threads (Thread and Runnable) allows us to execute several processes at the same time; in other words, concurrently and that is why it allows us to make programs that run in less time and are more efficient. Obviously we cannot execute infinite processes concurrently since the hardware has its limitations, but it is rare today that computers that do not have more than one core, therefore in a processor with two cores, two processes could be run at the same time and thus our program would use the hardware resources to the maximum. To see it, let's put the example of the 4 sequential processes

<p align="center">
<img height="270" src="https://user-images.githubusercontent.com/13514156/120513472-f00d2680-c391-11eb-8853-a1b306c45971.jpeg">
</p>

If instead of doing it sequentially, it is done with 4 threads, the program would run in 20 seconds (longer process execution time)

<p align="center">
<img height="270" src="https://user-images.githubusercontent.com/13514156/120513544-00250600-c392-11eb-976d-9448f6f573a0.jpeg">
</p>

Example:

In this example we are going to simulate the payment process of a supermarket; that is, some customers go with a cart full of products and a cashier charges them for the products, passing them one by one through the scanner of the cash register. In this case, the cashier must process the customer-to-customer purchase, that is, it first charges customer 1, then customer 2, and so on. For this we are going to define a class "Cashier" and a class "Customer" which will have an "array of integers" that will represent the products that have been bought and the time that the cashier will take to pass the product through the scanner; that is, if we have an array with [1,3,5] it will mean that the customer has bought 3 products and that the cashier will take to process product 1 '1 second', product 2 '3 seconds' and product 3 in '5 seconds', which will take to charge the customer for their entire purchase '9 seconds'.

Cashier.java
```java
public class Cashier{
    private String name;

    // constructor, getter and setter

    public void processPurchase(Client client, long timeStamp){
        System.out.println("The cashier " + this.name + "Start to process the purcharse for client " + client.getName()  +
        " in the time " + (System.currentTimeMillis() - timeStamp) / 1000 + " sec");

        for(int i = 0; i < client.getShoppingCar().length; i++){
            this.waitXtime(client.getShoppingCar()[i]);
            System.out.println("Processing the product " + (i + 1)) + " -> Time " + (System.currenTimeMillis() - timeStamp) / 1000 + " sec"
        }

        System.out.println("The cashier " + this.name + "Finish to process the purcharse for client " + client.getName()  +
        " in the time " + (System.currentTimeMillis() - timeStamp) / 1000 + " sec");
    }

    private void waitXtime(int seconds){
        try{
            Thread.sleep(seconds * 1000);        
        }catch(InterruptedException ex){
            Thead.currentThread().interrupt();
        }
    }
}
```

Client.java
```java
public class Client{
    private String name;
    private int[] shoppingCar;


    //Constructor, getter and setter

}
```

If we execute the proposed program with two clients and with a single process, the purchase of client 1 would be processed first and then the purchase of client 2, taking a time of (client 1 + client 2)

Main method, although two objects of the class Cashier have been created, it does not mean that we have two independent cashiers, what we are saying is that the methods of cashier 1 and then cashier 2 are executed within the same thread

therefore at the processing level it is as if there were only a cashier attending

Main.java
```java
public class Main{
    public static void main (String [] args){
        Client client1 = new Client("Client 1", new int[]{2,2,1,5,2,3});
        Client client2 = new Client("Client 2", new int[]{1,3,5,1,1});
        
        Cashier cashier1 = new Cashier("Cajera 1");
        Cashier cashier2 = new Cashier("Cajera 2");

        //Inicial time for reference
        long initialTime = System.currentTimeMillis();

        cashier1.processPurchase(client1, inicialTime);
        cashier2.processPurchase(client2, inicialTime);
    }
}
```

As we can see, the purchase of customer 1 is processed first and then the purchase of customer 2, taking a processing time of 26 seconds

<p align="center">
<img height="270" src="https://user-images.githubusercontent.com/13514156/120513605-0e732200-c392-11eb-88cc-ba69a0d82a3f.jpeg">
</p>

What if instead of processing one client first and then another, we processed both at the same time? How long would it take for the program to run? Well, if instead of having only one Cashier (that is, a single thread), there were two Cashiers (that is, two threads or threads) we could process the two clients at the same time and take less time to execute the program. For this we must modify the class "Cashier.java" and make this class inherit from the Thread class to inherit and override some of its methods. First we are going to see how we code this new class "CashierThread.java" and then we will explain its characteristics.

CashierThread.java
```java
public class CashierThread extends Thread{
    private String name;
    private Client client;
    private long initialTime;

    // constructor, getter and setter

    @Override
    public void run(){
        System.out.println("The cashier " + this.name + "Start to process the purcharse for client " + client.getName()  +
        " in the time " + (System.currentTimeMillis() - timeStamp) / 1000 + " sec");

        for(int i = 0; i < client.getShoppingCar().length; i++){
            this.waitXtime(client.getShoppingCar()[i]);
            System.out.println("Processing the product " + (i + 1)) + " -> Time " + (System.currenTimeMillis() - timeStamp) / 1000 + " sec"
        }

        System.out.println("The cashier " + this.name + "Finish to process the purcharse for client " + client.getName()  +
        " in the time " + (System.currentTimeMillis() - timeStamp) / 1000 + " sec");


    }

    private void waitXtime(int seconds){
        try{
            Thread.sleep(seconds * 1000);        
        }catch(InterruptedException ex){
            Thead.currentThread().interrupt();
        }
    }
}
```

Another important thing we see is that we have overwritten the "run ()" method (hence the @Override tag). This method must be overwritten (since it is a method that is in the Runnable class and the Thread class implements that Interface) because it is going to encode the functionality to be executed in a thread; that is, what is programmed in the "run ()" method will be executed sequentially in a thread. In this "Thread Pocket" class, more methods can be overwritten to perform actions on the thread or thread, such as stopping the thread, putting it to rest, etc. Next we are going to see how we program the Main method to process the clients in parallel and see how it takes less time to process everything. The Main method is in the class "MainThread.java" which has the following content:

MainThread.java
```java
public class MainThread{
    public static void main (String [] args){
        
        Client client1 = new Client("Client 1", new int[]{2,2,1,5,2,3});
        Client client2 = new Client("Client 2", new int[]{1,3,5,1,1});
        
        CashierThread cashier1 = new CashierThread("Cajera 1");
        CashierThread cashier2 = new CashierThread("Cajera 2");

        //Inicial time for reference
        long initialTime = System.currentTimeMillis();

        cashier1.start();
        cashier2.start();
    }
}
```
This program is execute in 15 seconds

In this example we see how the effect is as if two cashiers processed the customer's purchase in parallel without the result of the application suffering any variation in its final result, which is to process all customer purchases independently. . Graphically we see that the program has done the following in two different threads:

<p align="center">
<img height="270" src="https://user-images.githubusercontent.com/13514156/120513660-1d59d480-c392-11eb-84ba-7cc758dd16d1.jpeg">
</p>

Another way to do the same but without inheriting from the "Thread" class is to implement the "Runnable" Interface. In this case we will not have nor will we be able to overwrite the methods of the Thread class since we will not use it and we will only have to overwrite the "run ()" method. In this case, it will only be necessary to implement the "run ()" method so that the processes implemented in that method are executed in a different thread. We are going to see an example of how using objects of the classes "Customer.java" and "Cashier.java" we can implement multitasking in the same class where the Main method of the application is called. Here is the encoding in the "MainRunnable.java" class:

MainRunnable.java
```java
public class MainRunnable implements Runnable{
    
        private Client client;
        private Cashier cashier;
        private long initialTime;

        public MainRunnable(Client client, Cashier cashier, long initialTime){
            this.cashier = cashier;
            this.client = client;
            this.initialTime = initialTime;
        }

        public static void main (String [] args){

            Client client1 = new Client("Client 1", new int[]{2,2,1,5,2,3});
            Client client2 = new Client("Client 2", new int[]{1,3,5,1,1});        
            
            CashierThread cashier1 = new CashierThread("Cajera 1");
            CashierThread cashier2 = new CashierThread("Cajera 2");

            //Inicial time for reference
            long initialTime = System.currentTimeMillis();

            Runnable process1 = new MainRunnable(client1, cashier1, initialTime);
            Runnable process2 = new MainRunnable(client2, cashier2, initialTime);

            new Thread(process1).start();
            new Thread(process2).start();
        }

        @Override
        public void run(){
            this.cashier.processPurchase(this.client, this.initialTime);
        }
}

