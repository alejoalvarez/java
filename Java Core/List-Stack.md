# List type Stack

A list behaves like a stack if the insertions and extractions are done on the same side of the list. Also called LIFO (Last In First Out) lists.

**Important**: 

A stack, being a list, can store any type of value in the information field (int, char, float, character vector, an object, etc.)

Initially the **stack** is empty and we say that the root pointer points to null (if it points to null we say that it does not have a memory address):

IMAGE

We push an integer value on the stack: insert(10)

IMAGE

After performing the insertion, the stack type list looks like this: a node with the value 10 and root points to that node. The node pointer points to null since there is no other node after it.

We then insert the value 4: insert(4)

image

Now the first node in the stack is the one that stores the value four. root points to that node. Recall that root is the external pointer to the list that stores the address of the first node. The node we just inserted into the pointer field stores the address of the node that stores the value 10.

Now what happens if we pop a node from the stack. Which one is extracted? As we know in a stack the last one to enter is extracted.

Pulling from the stack we have: pull()

IMAGE

The stack is left with one node.

You have to be careful that if a new node is extracted, the stack will be empty and you will not be able to extract other values (warn that the stack is empty)


## Example

Program that manages a stack-like list (must be able to insert, extract and print the data from the stack)

```java
public class Stack {
	
    class Node {
        int info;
        Node sig;
    }
	
    private Node root;
    
    public Stack () {
        root = null;
    }
    
    public void push(int x) {
    	Node newNode;
        newNode = new Node();
        newNode.info = x;
        if (root == null)
        {
            newNode.sig = null;
            root = newNode;
        }
        else
        {
            newNode.sig = root;
            root = newNode;
        }
    }
    
    public int pull ()
    {
        if (root != null)
        {
            int information = root.info;
            root = root.sig;
            return information;
        }
        else
        {
            return Integer.MAX_VALUE;
        }
    }
    
    public void print() {
        Node pointer = root;
        System.out.println("List of all elements in the stack.");
        while (pointer != null) {
            System.out.print(pointer.info + "-");
            pointer = pointer.sig;
        }
        System.out.println();
    }
    
    public static void main(String[] ar) {
        Stack stack1=new Stack();
        stack1.push(10);
        stack1.push(40);
        stack1.push(3);
        stack1.print();
        System.out.println("Pull of stack: " + stack1.pull());
        stack1.print();        
    }
}
```
