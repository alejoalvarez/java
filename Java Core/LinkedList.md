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

