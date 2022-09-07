## ArrayList vs. LinkedList

- The **LinkedList** class is a collection which can contain many objects of the same type, just like the **ArrayList**.
- The difference of the ArrayList with the LinkedList class is the internal implementation of the algorithms.
- The LinkedList class uses a doubly linked list, and the ArrayList class uses an array that automatically resizes as data is inserted and extracted.
- The main advantage of using the ArrayList class is that access to a list element is immediate through the 'get' method, whereas the implementation of the 'get' method in the LinkedList class requires iterating through the list sequentially until reaching the position to search.
- If the list is not going to have large changes in inserts and extracts during the execution of the program, it is more common to use the ArrayList class instead of LinkedList.
- The **LinkedList** class has all of the same methods as the **ArrayList** class because they both implement the List interface. This means that you can add items, change items, remove items and clear the list in the same way.

However, while the **ArrayList** class and the **LinkedList** class can be used in the same way, they are built very differently.

## How the ArrayList works

The ArrayList class has a regular array inside it. When an element is added, it is placed into the array. If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.

## How the LinkedList works

The LinkedList stores its items in "containers." The list has a link to the first container and each container has a link to the next container in the list. To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.

## When To Use

It is best to use an `ArrayList` when:

- You want to access random items frequently
- You only need to add or remove elements at the end of the list

It is best to use a `LinkedList` when:

- You only use the list by looping through it instead of accessing random items
- You frequently need to add and remove items from the beginning, middle or end of the	list