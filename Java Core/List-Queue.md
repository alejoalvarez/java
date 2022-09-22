# List type Queue

A list behaves like a **queue** if the inserts are done at the end and the extracts are done at the front of the list. They are also called FIFO (First In First Out) lists.

Program that manages a queue like list (must be able to insert, extract and print the data from the stack)

```java
public class Queue {

    class Node {
        int info;
        Node next;
    }

    private Node root,bottom;

    Queue() {
        root=null;
        bottom=null;
    }

    boolean empty (){
        if (root == null)
            return true;
        else
            return false;
    }

    void insert (int info)
    {
        Node new;
        new = new Node ();
        new.info = info;
        new.next = null;
        if (empty ()) {
            root = new;
            bottom = new;
        } else {
            bottom.next = new;
            bottom = new;
        }
    }

    int pull ()
    {
        if (!empty ())
        {
            int information = root.info;
            if (root == bottom){
                root = null;
                bottom = null;
            } else {
                root = root.next;
            }
            return information;
        } else
            return Integer.MAX_VALUE;
    }

    public void print() {
        Node pointer = root;
        System.out.println("List of all items in the queue.");
        while (pointer != null) {
            System.out.print(pointer.info + "-");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public static void main(String[] ar) {
        Queue queue1 = new Queue();
        queue1.insert(5);
        queue1.insert(10);
        queue1.insert(50);
        queue1.print();
        System.out.println("extract one from the queue: " + cola1.pull());
        queue1.print();
    }
}
```

**Problem statement:**

The objective of this practice is to show the importance of queues in Computer Science and more precisely in simulations. Simulations allow the analysis of real situations without the need to actually execute them. It has the benefit that its cost is much lower than testing in reality.

Develop a program for simulating an ATM. The following information is available:- Customers arrive at the door of the ATM every 2 or 3 minutes.- Each customer takes between 2 and 4 minutes to be served.

Obtain the following information:1 - Number of customers served in 10 hours.2 - Number of customers in queue after 10 hours.3 - Arrival time of the first customer not served after 10 hours (i.e. the person who is first in the queue when 10 hours are up)

```java
public class Queue {
    
    class Node {
        int info;
        Node next;
    }
    
    Node root, bottom;
    
    Queue() {
        root = null;
        bottom = null;
    }
    
    boolean empty (){
        if (root == null)
            return true;
        else
            return false;
    }

    void push (int info)
    {
        Node new;
        new = new Node ();
        new.info = info;
        new.next = null;
        if (empty ()) {
            root = new;
            bottom = new;
        } else {
            bottom.next = new;
            bottom = new;
        }
    }

    int pull ()
    {
        if (!empty())
        {
            int information = root.info;
            if (root == bottom){
                root = null;
                bottom = null;
            } else {
                root = root.next;
            }
            return information;
        } else
            return Integer.MAX_VALUE;
    }

    public void print() {
        Node pointer = root;
        System.out.println("List of all items in the queue.");
        while (pointer != null) {
            System.out.print(pointer.info + "-");
            pointer = pointer.next;
        }
        System.out.println();
    }
    
    public int quantity() {
        int quantity = 0;
        Node pointer = root;
        while (pointer != null) {
            quantity++;
            pointer = pointer.next;
        }
        return quantity;
    }   
}

import javax.swing.*;
import java.awt.event.*;
public class ATM extends JFrame implements ActionListener{
    private JLabel l1,l2,l3;
    private JButton button1;
    public ATM() {
        setLayout(null);
        button1 = new JButton("Enable simulation");
        button1.setBounds(10,10,180,30);
        add(button1);
        button1.addActionListener(this);
        l1 = new JLabel("Attended:");
        l1.setBounds(10,50,300,30);
        add(l1);
        l2 = new JLabel("In line:");
        l2.setBounds(10,90,300,30);
        add(l2);
        l3 = new JLabel("Arrival minute:");
        l3.setBounds(10,130,400,30);
        add(l3);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            simulation();
        }
    }

    public void simulation () {
        int status = 0;
        int arrival = 2 + (int) (Math.random () * 2);
        int exit = -1;
        int quantityAttended = 0;
        Queue queue = new Queue ();
        for (int minute = 0 ; minute < 600 ; minute++) {
            if (arrival == exit){
                if (status == 0) {
                    status = 1;
                    exit = minute + 2 + (int) (Math.random() * 3);
                } else {
                    queue.push(minute);
                }
                arrival = minute + 2 + (int)(Math.random() * 2);
            }
            if (exit == minute){
                status = 0;
                quantityAttended++;
                if (!queue.empty()) {
                    queue.push();
                    status = 1;
                    exit = minute + 2 + (int)(Math.random() * 3);
                }
            }
        }
        l1.setText("Attended: " + String.valueOf(quantityAttended));
        l2.setText("In line: " + String.valueOf(queue.quantity()));
        l3.setText("Arrival minute: " + String.valueOf(queue.pull()));
    }
    
    public static void main(String[] ar) {
        ATM atm1 = new ATM();
        atm11.setBounds(0,0,340,250);
        atm1.setVisible(true);
        atm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
```

# Proposed problem

1. A supermarket has three checkouts for customer service. The cashiers take between 7 and 11 minutes to serve each customer. Customers arrive at the checkout area every 2 or 3 minutes. (When the customer arrives, if all the checkouts have 6 people, the customer leaves the supermarket) When the customer arrives at the checkout area, he chooses the checkout with a shorter queue.
    
Carry out a simulation for 8 hours and obtain the following information:a - Number of customers served by each checkout.b - Number of customers who left without making purchases.c - Average time in queue.

```java
public class Queue {

    class Node {
        int info;
        Node next;
    }

    Node root,bottom;

    Queue() {
        root = null;
        bottom = null;
    }

    boolean empty (){
        if (root == null)
            return true;
        else
            return false;
    }

    void push (int info)
    {
        Node new;
        new = new Node ();
        new.info = info;
        new.next = null;
        if (empty()) {
            root = new;
            bottom = new;
        } else {
            bottom.next = new;
            bottom = new;
        }
    }

    int pull ()
    {
        if (!empty()){
            int information = root.info;
            if (root == bottom){
                root = null;
                bottom = null;
            } else {
                root = root.next;
            }
            return information;
        } else
            return Integer.MAX_VALUE;
    }

    public void print() {
        Node pointer = root;
        System.out.println("List of all items in the queue.");
        while (pointer != null) {
            System.out.print(pointer.info + "-");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public int quantity() {
        int quantity = 0;
        Node pointer = root;
        while (pointer != null) {
            quantity++;
            pointer = pointer.next;
        }
        return quantity;
    }
}

import javax.swing.*;
import java.awt.event.*;

public class Supermarket extends JFrame implements ActionListener {
    private JButton button1;
    private JLabel l1,l2,l3;
    public Supermarket() {
        setLayout(null);
        button1 = new JButton("Enable Simulation");
        button1.setBounds(10,10,180,30);
        add(button1);
        button1.addActionListener(this);
        l1 = new JLabel("Customers served by checkout:");
        l1.setBounds(10,50,400,30);
        add(l1);
        l2 = new JLabel("They leave without shopping:");
        l2.setBounds(10,90,400,30);
        add(l2);
        l3 = new JLabel("Average time in queue:");
        l3.setBounds(10,130,400,30);
        add(l3);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== button1) {
            simulation();
        }
    }

    public void simulation () {
        int status1 = 0, status = 0, status3 = 0;
        int leave = 0;
        int arrival = 2 + (int) (Math.random () * 2);
        int exit1 = -1, exit2 = -1, exit3 = -1;
        int quantityAttended1 = 0, quantityAttended2 = 0, quantityAttended3 = 0;
        int timeInQueue = 0;
        int quantityInQueue = 0;
        Queue queue1 = new Queue();
        Queue queue2 = new Queue();
        Queue queue3 = new Queue();
        for (int minute = 0 ; minute < 600 ; minute++) {
            if (arrival == minute) {
                if (status1==0) {
                    status1=1;
                    exit1 = minute + 7 + (int) (Math.random() * 5);
                } else {
                    if (status2 == 0) {
                        status2 = 1;
                        exit2 = minute + 7 + (int) (Math.random() * 5);
                    } else {
                        if (status3 == 0) {
                            status3 = 1;
                            exit3 = minute + 7 + (int) (Math.random() * 5);
                        } else {
                            if (queue1.quantity() == 6 && queue2.quantity() == 6 && queue3.quantity() == 6) {
                                leave++;
                            } else {
                                if (queue1.quantity() <= queue2.quantity() && queue1.quantity() <= quantity3.quantity()) {
                                    queue1.push(minute);
                                } else {
                                    if (queue2.quantity() <= queue3.quantity()) {
                                        queue2.push(minute);
                                    } else {
                                        queue3.push(minute);
                                    }
                                }
                            }
                        }
                    }

                }
                arrival = minute + 2+ (int) (Math.random () * 2);
            }
            if (exit1 == minute) {
                quantityAttended1++;
                status1 = 0;
                if(!queue1.empty()) {
                    status1 = 1;
                    int m = queue1.pull();
                    exit1 = minute + 7 + (int) (Math.random() * 5);
                    TimeInQueue = TimeInQueue + (minute - m);
                    quantityInQueue++;
                }
            }
            if (exit2 == minute) {
                quantityAttended2++;
                status2=0;
                if(!queue2.empty()) {
                    status2 = 1;
                    int m = queue2.pull();
                    exit2 = minute + 7 + (int) (Math.random() * 5);
                    timeInQueue = timeInQueue + ( minute- m);
                    quantityInQueue++;
                }
            }
            if (exit3 == minute) {
                quantityAttended++;
                status3 = 0;
                if(!queue3.empty()) {
                    status3 = 1;
                    int m = queue3.pull();
                    exit3 = minute + 7 + (int) (Math.random() * 5);
                    timeInQueue = timeInQueue + (minute - m);
                    quantityInQueue++;
                }
            }
        }
        l1.setText("Customers served by checkout: checkout1= " + quantityAttended1 + "  checkout2= " + quantityAttended2 + " checkout3= " + quantityAttended3);
        l2.setText("They leave without shopping: " + leave);
        if (quantityInQueue > 0) {
            int averageTime = timeInQueue/quantityInQueue;
            l3.setText("Average time in queue:" + averageTime);
        }
    }

    public static void main(String[] ar) {
        Supermarket super1 = new Supermarket();
        super1.setBounds(0,0,390,250);
        super1.setVisible(true);
        super1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
```