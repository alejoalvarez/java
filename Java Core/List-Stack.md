# List type Stack

A list behaves like a stack if the insertions and extractions are done on the same side of the list. Also called LIFO (Last In First Out) lists.

**Important**: 

A stack, being a list, can store any type of value in the information field (int, char, float, character vector, an object, etc.)

Initially the **stack** is empty and we say that the root pointer points to null (if it points to null we say that it does not have a memory address):

<p align="center">
<img width="150" src="https://user-images.githubusercontent.com/13514156/191837527-0506b0de-c2e3-417f-9ea4-4b2203b34932.png">
</p>

We push an integer value on the stack: insert(10)

<p align="center">
<img width="180" src="https://user-images.githubusercontent.com/13514156/191837827-49d47c6d-3ebb-4930-890d-956fc45eb397.png">
</p>

After performing the insertion, the stack type list looks like this: a node with the value 10 and root points to that node. The node pointer points to null since there is no other node after it.

We then insert the value 4: insert(4)

<p align="center">
<img width="400" src="https://user-images.githubusercontent.com/13514156/191838081-b053e18c-46aa-4371-8811-848a0b86476a.png">
</p>

Now the first node in the stack is the one that stores the value four. root points to that node. Recall that root is the external pointer to the list that stores the address of the first node. The node we just inserted into the pointer field stores the address of the node that stores the value 10.

Now what happens if we pop a node from the stack. Which one is extracted? As we know in a stack the last one to enter is extracted.

Pulling from the stack we have: pull()

<p align="center">
<img width="180" src="https://user-images.githubusercontent.com/13514156/191837827-49d47c6d-3ebb-4930-890d-956fc45eb397.png">
</p>

The stack is left with one node.

You have to be careful that if a new node is extracted, the stack will be empty and you will not be able to extract other values (warn that the stack is empty)


## Example

Program that manages a stack-like list (must be able to insert, extract and print the data from the stack)

```java
public class ListStack {

    static class Node {
        int info;
        Node next;
    }

    private Node root;

    public ListStack() {
        root = null;
    }

    public void push(int x) {
        Node newNode = new Node();
        newNode.info = x;
        if(root == null){
            newNode.next = null;
        } else {
            newNode.next = root;
        }
        root = newNode;
    }

    public int pull(){
        if (root != null){
            int information = root.info;
            root = root.next;
            return information;
        } else{
            return Integer.MAX_VALUE;
        }
    }

    public void print() {
        Node pointer = root;
        System.out.println("List of all elements in the stack.");
        while (pointer != null) {
            System.out.print(pointer.info + "-");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int total() {
        int quantity = 0;
        Node pointer = root;
        while (pointer != null) {
            quantity++;
            pointer = pointer.next;
        }
        return quantity;
    }

    public static void main(String[] ar) {
        ListStack listStack = new ListStack();
        listStack.push(10);
        listStack.push(40);
        listStack.push(3);
        listStack.print();
        System.out.println("Pull of stack: " + listStack.pull());
        listStack.print();
    }
}
```