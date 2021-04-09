## LinkedList

The **LinkedList** class is almost identical to the ArrayList:

The Linked Lists in Java is another important type of data structure. A Linked List is a collection of similar types of data elements, called nodes, which point to the next following nodes by means of pointers.

Types of linked list:
- Singly-linked list
- Doubly linked list
- Circular linked list

### Singly linked list

A singly-linked list is a linked list that stores data and the reference to the next node or a null value. Singly-linked lists are also known as one-way lists as they contain a node with a single pointer pointing to the next node in the sequence.

There is a START pointer that stores the very first address of the linked list. The next pointer of the last or end node stores NULL value, which points to the last node of the list which does not point to any other node.


### Doubly linked list

It is the same as a singly-linked list with the difference that it has two pointers, one pointing to the previous node and one pointing to the next node in the sequence. Therefore, a doubly-linked list allows us to traverse in both the directions of the list.

### Circular linked list

In the Circular Linked List, all the nodes align to form a circle. In this linked list, there is no NULL node at the end. We can define any node as the first node. Circular linked lists are useful in implementing a circular queue.



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

## ArrayList vs. LinkedList

- The **LinkedList** class is a collection which can contain many objects of the same type, just like the **ArrayList**.
- The **LinkedList** class has all of the same methods as the **ArrayList** class because they both implement the List interface. This means that you can add items, change items, remove items and clear the list in the same way.

However, while the **ArrayList** class and the **LinkedList** class can be used in the same way, they are built very differently.

## How the ArrayList works
The ArrayList class has a regular array inside it. When an element is added, it is placed into the array. If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.

## How the LinkedList works
The LinkedList stores its items in "containers." The list has a link to the first container and each container has a link to the next container in the list. To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.

## When To Use
It is best to use an ```ArrayList``` when:
	• You want to access random items frequently
	• You only need to add or remove elements at the end of the list
It is best to use a ```LinkedList``` when:
	• You only use the list by looping through it instead of accessing random items
	• You frequently need to add and remove items from the beginning, middle or end of the
	list

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

