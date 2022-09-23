# LinkedList

- The **LinkedList** class is almost identical to the ArrayList
- The **LinkedList** in Java is another important type of data structure.
- The LinkedList class implements the logic to work with generic lists, that is, we can insert and extract elements from any part of the list.
- A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations.
- Costly positional access.
- Costly insertion and removal (Except in the first and last position, which is immediate).
- Limited size

A Linked List is a collection of similar types of data elements, called nodes, which point to the next following nodes by means of pointers.

# Types of linked list:
- Singly-linked list
- Doubly linked list
- Circular linked list

## Singly linked list

A singly-linked list is a linked list that stores data and the reference to the next node or a null value. Singly-linked lists are also known as one-way lists as they contain a node with a single pointer pointing to the next node in the sequence.

There is a START pointer that stores the very first address of the linked list. The next pointer of the last or end node stores NULL value, which points to the last node of the list which does not point to any other node.

<p align="center">
<img src="https://user-images.githubusercontent.com/13514156/189209554-75a30c5e-c97c-4322-8d83-bcdf7a06961e.png">
</p>


## Doubly linked list

It is the same as a singly-linked list with the difference that it has two pointers, one pointing to the previous node and one pointing to the next node in the sequence. Therefore, a doubly-linked list allows us to traverse in both the directions of the list.

<p align="center">
<img src="https://user-images.githubusercontent.com/13514156/189210215-b7c273ed-0639-4989-9a9e-db0e504e18a3.png">
</p>

Note that a doubly linked list has two pointers for each node, one points to the next node and one to the previous node. We still have a pointer (root) that has the address of the first node. The next pointer of the last node is the same as lists simply chained points to null, and the first node's ant pointer points to null.

Stack, queue and generic lists with double link can be considered. Keep in mind that the memory requirement is greater in doubly linked lists since we have two pointers per node.

The structure of the node is:
```java
class Node{
  int info;
  Node next, before;
}
```

Example Code:

```java
public class GenericList {

    class Node {
        int info;
        Nodo before,next;
    }

    private Node root;

    public GenericList() {
        root = null;
    }

    void push(int pos, int x){
        if (pos <= quantity() + 1){
            Node new1 = new Node();
            new1.info = x;
            if (pos == 1){
                new1.next = root;
                if (root != null)
                    root.before = new1;
                root = new1;
            } else
                if (pos == quantity() + 1)    {
                    Node pointer = root;
                    while (pointer.next != null) {
                        pointer = pointer.next;
                    }
                    pointer.next = new1;
                    new1.next = pointer;
                    new1.next = null;
                } else {
                    Node pointer = root;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        pointer = pointer.next;
                    Node next = pointer.next;
                    pointer.next = new1;
                    new1.before = pointer;
                    new1.next = next;
                    next.becfore = new1;
                }
        }
    }

    public int pull(int pos){
        if (pos <= quantity()){
            int information;
            if (pos == 1) {
                information = root.info;
                root = root.next;
                if (root != null)
                    root.before = null;
            } else {
                Node pointer;
                pointer = root;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    pointer = pointer.next;
                Node prox = pointer.next;
                pointer.next = prox.sig;
                Node next = prox.next;
                if (next != null)
                    next.before = pointer;
                information = prox.info;
            }
            return informtcion;
        }
        else
            return Integer.MAX_VALUE;
    }

    public void remove(int pos){
        if (pos <= quantity()){
            if (pos == 1) {
                root = root.next;
                if (root != null)
                    root.before = null;
            } else {
                Node pointer;
                pointer = root;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    pointer = pointer.next;
                Node prox = pointer.next;
                prox = prox.next;
                pointer.next = prox;
                if (prox != null)
                    prox.before = pointer;
            }
        }
    }

    public void exchange(int pos1, int pos2) {
        if (pos1 <= quantity() && pos2 <= quantity()){
            Node pointer1 = root;
            for (int f = 1 ; f < pos1 ; f++)
                pointer1 = pointer1.next;
            Node pointer2 = root;
            for (int f = 1 ; f < pos2 ; f++)
                pointer2 = pointer2.next;
            int aux = pointer1.info;
            pointer1.info = pointer2.info;
            pointer2.info = aux;
        }
    }

    public int higher() {
        if (!empty()) {
            int may = root.info;
            Node pointer = root.next;
            while (pointer != null) {
                if (pointer.info > may)
                    may = pointer.info;
                pointer = pointer.next;
            }
            return may;
        }
        else
            return Integer.MAX_VALUE;
    }

    public int higherPosition() {
        if (!empty())    {
            int may = root.info;
            int x = 1;
            int pos = x;
            Node pointer = root.next;
            while (pointer != null){
                if (pointer.info > may) {
                    may = pointer.info;
                    pos = x;
                }
                pointer = pointer.next;
                x++;
            }
            return pos;
        }
        else
            return Integer.MAX_VALUE;
    }

    public int quantity()
    {
        int cant = 0;
        Node pointer = root;
        while (pointer != null) {
            pointer = pointer.next;
            cant++;
        }
        return cant;
    }

    public boolean sorted() {
        if (quantity()>1) {
            Node pointer1 = root
            Node pointer2 = root.next;
            while (pointer2 != null) {
                if (pointer2.info < pointer1.info) {
                    return false;
                }
                pointer2 = pointer2.next;
                pointer1 = pointer1.next;
            }
        }
        return true;
    }

    public boolean exist(int x) {
        Node pointer = root;
        while (pointer != null) {
            if (pointer.info == x)
                return true;
            pointer = pointer.next;
        }
        return false;
    }

    public boolean empty(){
        if (root == null)
            return true;
        else
            return false;
    }

    public void print()
    {
        Node pointer = root;
        while (pointer != null) {
            System.out.print (pointer.info + "-");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public static void main(String[] ar) {
        GenericList lg = new GenericList();
        lg.push(1, 10);
        lg.push(2, 20);
        lg.push(3, 30);
        lg.push(2, 15);
        lg.push(1, 115);
        lg.print();
        System.out.println ("After deleting the first");
        lg.remove(1);
        lg.print();
        System.out.println ("After extracting the second");
        lg.pull(2);
        lg.print();
        System.out.println ("After exchanging the first with the third");
        lg.exchange(1, 3);
        lg.print();
        if (lg.exist(10))
            System.out.println("20 is found on the list");
        else
            System.out.println("20 not found in the list");
        System.out.println("The position of the elder is: " + lg.higherPosition());
        if (lg.sorted())
            System.out.println("The list is sorted from smallest to largest");
        else
            System.out.println("The list is not sorted from smallest to largest");
    }
}
```

# Proposed Problems

1. Create a class to manage a generic doubly chained list by implementing the following methods:
a) Insert a node at the beginning of the list.
b) Insert a node at the end of the list.
c) Insert a node in the second position. If the list is empty, the node is not inserted.
d) Insert a node in the ante last position.
e) Delete the first node.
f) Delete the second node.
g) Delete the last node.
h) Delete the node with more information

```java
public class GenericList {

    class Node {
        int info;
        Node before,next;
    }

    private Node root;

    public GenericList () {
        root = null;
    }

    void insertFirst(int x){
        Node new1 = new Node();
        new1.info = x;
        new1.next = root;
        if (root != null)
            root.before = new1;
        root=new1;
    }

    public void insertLast(int x) {
        Node new1 = new Node();
        new1.info = x;
        if (root == null)
            root = new1;
        else {
            Node pointer = root;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new1;
            new1.before = pointer;
        }
    }

    public void insertSecond(int x){
        if (root != null) {
            Node new1 = new Node();
            new1.info = x;
            if (root.next == null) {
                // Hay un solo Node.
                root.next = new1;
                new1.before = root;
            } else {
                Node third = root.next;
                new1.next = third;
                third.before = new1;
                root.next = new1;
                new1.before = root;
            }
        }
    }

    public void insertBeforeLast(int x) {
        if (root != null) {
            Node new1 = new Node();
            new1.info = x;
            if (root.next == null) {
                // Hay un solo Node.
                new1.next = root;
                root = new1;
            } else {
                Node pointer = root;
                while (pointer.next != null) {
                    pointer = pointer.next;
                }
                Node beforer = pointer.before;
                new1.next = pointer;
                new1.before = beforer;
                beforer.next = new1;
                pointer.before = new1;
            }
        }
    }

    public void removeFirst() {
        if (root! = null) {
            root = root.next;
            if (root != null) {
                root.before = null;
            }
        }
    }

    public void removeSecond() {
        if (root != null) {
            if (root.next != null) {
                Node third = root.next;
                third = third.next;
                root.next = third;
                if (third != null)
                    third.before = root;
            }
        }
    }

    public void removeLast() {
        if (root != null) {
            if (root.next == null) {
                root = null;
            } else {
                Node pointer = root;
                while(pointer.next != null) {
                    pointer = pointer.next;
                }
                pointer = pointer.before;
                pointer.next = null;
            }
        }

    }
    public void print() {
        Node pointer = root;
        while (pointer != null) {
            System.out.print (pointer.info + "-");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public void removeHigher() {
        if (root != null) {
            Node pointer = root;
            int may = root.info;
            while (pointer != null) {
                if (pointer.info > may) {
                    may = pointer.info;
                }
                pointer = pointer.next;
            }
            pointer = root;
            while (pointer != null) {
                if (pointer.info == may) {
                    if (pointer == root) {
                        root = root.next;
                        if (root != null)
                            root.before = null;
                        pointer = root;
                    } else {
                        Node before = pointer.before;
                        before.next = pointer.next;
                        pointer = pointer.next;
                        if (pointer != null)
                            pointer.before = before;
                    }
                } else {
                    pointer = pointer.next;
                }
            }
        }
    }


    public static void main(String[] ar) {
        GenericList lg = new GenericList();
        lg.insertFirst(10);
        lg.insertFirst(45);
        lg.insertFirst(23);
        lg.insertFirst(89);
        lg.print();
        System.out.println("insert a Node at the end: ");
        lg.insertLast(160);
        lg.print();
        System.out.println("insert a Node in the second position:");
        lg.insertSecond(13);
        lg.print();
        System.out.println("insert a node in the before last position:");
        lg.insertBeforeLast(600);
        lg.print();
        System.out.println("remove the first node in the list:");
        lg.removeFirst();
        lg.print();
        System.out.println("Remove second node in the list:");
        lg.removeSecond();
        lg.print();
        System.out.println("Remove last node in the list:");
        lg.removeLast();
        lg.print();
        System.out.println("Remove the higger in the list:");
        lg.removeHigher();
        lg.print();
    }
}
```


## Circular linked list

In the Circular Linked List, all the nodes align to form a circle. In this linked list, there is no NULL node at the end. We can define any node as the first node. Circular linked lists are useful in implementing a circular queue.

<p align="center">
<img src="https://user-images.githubusercontent.com/13514156/189210567-dd5112f6-285c-4226-94fa-3cb760f0bdff.png">
</p>

### Time complexities for linked-list operations:

- Traversing elements: **O(n)**
- Searching an element: **O(n)**
- Insertion: **O(1)**
- Deletion: **O(1)**

We can also perform more operations like:

- Concatenating two lists
- Splitting list
- Reversal of list

Example

```java
import java.util.LinkedList;
public class Main {
  public static void main(String[] args) {
    LinkedList<String> cars = new LinkedList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
  }
}
```

## How the LinkedList works
The LinkedList stores its items in "containers." The list has a link to the first container and each container has a link to the next container in the list. To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.

It is best to use a ```LinkedList``` when:
- You only use the list by looping through it instead of accessing random items
- You frequently need to add and remove items from the beginning, middle or end of the	list

## Methods
For many cases, the ArrayList is more efficient as it is common to need access to random items in the list, but the LinkedList provides several methods to do certain operations more efficiently:

| Method| Description|
|---|---|
|addFirst()	| Adds an item to the beginning of the list|
|addLast()	| Add an item to the end of the list|
|removeFirst() | Remove an item from the beginning of the list|
|removeLast() |	Remove an item from the end of the list|
|getFirst() | Get the item at the beginning of the list|
|getLast() | Get the item at the end of the list|

**Example with main methods of linkedlist**

```java
import java.util.LinkedList; // To work with generic lists we must import the LinkedList class:

public class DemoLinkedList {

    public static void printList(LinkedList<String> list) {
        for (String item : list)
            System.out.print(item + "-");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<String>(); // We create an object of the LinkedList class:
        // The list manages objects of the String class, then through the 'add' method we add nodes at the end:
	list1.add("Alejo");
        list1.add("Juan");
        list1.add("Maria");
        printList(list1); // print elements of the list
        
	list1.add(1, "Ana");
	printList(list1);
        
	list1.remove(0);
        printList(list1);
        list1.remove("Juan");
        printList(list1);
        System.out.println("Total elements in list: " + list1.size());
	
        if (list1.contains("Ana")){
            System.out.println("The name 'Ana' is store in list");
	} else{
            System.out.println("The name 'Ana' isn't store in list");
        }
	
	// To retrieve the data from a node without deleting it, we can use the 'get' method:
	System.out.println("The second element in list is: " + list1.get(1));
        
	list1.clear(); // We remove all nodes from the list using the 'clear' method:
	
        if (list1.isEmpty()){
            System.out.println("The list is empty");
	}	
    }
}
```

