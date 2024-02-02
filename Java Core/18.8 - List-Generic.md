# List type generic

A list behaves as generic when inserts and extracts are performed anywhere in the list.


```java
void push(int pos, int x)
```

Extracts the information of the node of the indicated position (pos). The node must be removed.

```java
int pull(int pos)
```

Delete the node from the position (pos).

```java
void delete(int pos)
```

It exchanges the information of the nodes of the pos1 and pos2 positions.

```java
void exchange(int pos1,int pos2)
```

Returns the value of the node with more information.

```java
int higher()
```

Returns the position of the node with more information.

```java
int posHigher()
```

Returns the number of nodes in the list.
```java
int quantity()
```

It should return true if the list is sorted from smallest to largest, false otherwise.

```java
boolean sorted()
```

It must return true if the information that arrives in the parameter exists, false otherwise.
```java
boolean exist(int info)
```

The empty method should return true if it is empty and false if it is not.
```java
boolean empty()
```

Code:
```java
public class GenericList {
    
    class Node {
        int info;
        Node next;
    }
    
    private Node root;
    
    public GenericList () {
        root = null;
    }
      
    void push (int pos, int x){
        if (pos <= quantity() + 1){
            Node new1 = new Node ();
            new1.info = x;
            if (pos == 1){
                new1.next = root;
                root = new1;
            } else if (pos == quantity() + 1)    {
                    Node pointer = root;
                    while (pointer.next != null) {
                        pointer = pointer.next;
                    }
                    pointer.next = new1;
                    new1.next = null;
                } else {
                    Node pointer = root;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        pointer = pointer.next;
                    Node next = pointer.next;
                    pointer.next = new1;
                    new1.next = next;
                }
        }
    }

    public int pull (int pos) {
        if (pos <= quantity())    {
            int information;
            if (pos == 1) {
                information = root.info;
                root = root.next;
            } else {
                Node pointer;
                pointer = root;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    pointer = pointer.next;
                Node prox = pointer.next;
                pointer.next = prox.next;
                information = prox.info;
            }
            return information;
        }
        else
            return Integer.MAX_VALUE;
    }

    public void delete(int pos){
        if (pos <= quantity()){
            if (pos == 1) {
                root = root.sig;
            } else {
                Node pointer;
                pointer = root;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    pointer = pointer.next;
                Node prox = pointer.next;
                pointer.next = prox.next;
            }
        }
    }
    
    public void exchange (int pos1, int pos2){
        if (pos1 <= quantity() && pos2 <= quantity())    {
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
    
    public int higher(){
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
    
    public int posHigher(){
        if (!empty())    {
            int may = root.info;
            int x=1;
            int pos=x;
            Node pointer = root.next;
            while (pointer != null){
                if (pointer.info > may) {
                    may = pointer.info;
                    pos=x;
                }
                pointer = pointer.next;
                x++;
            }
            return pos;
        }
        else
            return Integer.MAX_VALUE;
    }

    public int quantity(){
        int cant = 0;
        Node pointer = root;
        while (pointer != null) {
            pointer = pointer.next;
            cant++;
        }
        return cant;
    }
    
    public boolean sorted(){
        if (quantity()>1) {
            Node pointer1 = root;
            Node pointer2 = root.next;
            while (pointer2! = null) {
                if (pointer2.info < pointer1.info) {
                    return false;
                }
                pointer2 = pointer2.next;
                pointer1 = pointer1.next;
            }
        }
        return true;
    }
    
    public boolean exist(int x){
        Node pointer = root;
        while (pointer = null) {
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
    
    public void print(){
        Node pointer = root;
        while (pointer != null) {
            System.out.print (pointer.info + "-");
            pointer = pointer.next;
        }
        System.out.println();
    }
        
    public static void main(String[] ar){
        GenericList lg = new GenericList();
        lg.push (1, 10);
        lg.push (2, 20);
        lg.push (3, 30);
        lg.push (2, 15);
        lg.push (1, 115);
        lg.print ();
        System.out.println("After deleting the first");
        lg.delete(1);
        lg.print();
        System.out.println("After extracting the second");
        lg.pull(2);
        lg.print();
        System.out.println("After exchanging the first with the third");
        lg.exchange(1, 3);
        lg.print();
        if (lg.exist(20))
            System.out.println("20 is found on the list");
        else
            System.out.println("20 not found in the list");
        System.out.println("The position of the elder is: " + lg.posMayor());
        if (lg.sorted())
            System.out.println("The list is sorted from smallest to largest");
        else
            System.out.println("The list is not sorted from smallest to largest");
    }
}
```

# Proposed Problems

Create a class to manage a generic list by implementing the following methods:a) Insert a node at the beginning of the list.b) Insert a node at the end of the list.c) Insert a node in the second position. If the list is empty, the node is not inserted.d) Insert a node in the last position.e) Delete the first node.f) Delete the second node.g) Delete the last node.h) Delete the node with information elderly.

```java
public class GenericList {

    class Node {
        int info;
        Node next;
    }

    private Node root;

    public GenericList() {
        root = null;
    }

    void insertFirst(int x){
        Node new1 = new Node();
        new1.info = x;
        new1.next = root;
        root = new1;
    }

    public void insertLast(int x){
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
        }
    }

    public void insertSecond(int x) {
        if (root != null) {
              Node new1 = new Node();
            new1.info = x;
            if (root.next == null) {
                //there is only one node
                root.next = new1;
            } else {
                new1.next = root.next;
                root.next = new1;
            }
        }
    }

    public void insertBeforeLast(int x) {
        if (root != null) {
            Node new1 = new Node();
            new1.info = x;
            if (root.next == null) {
                //there is only one node
                new1.next = root;
                root = new1;
            } else {
                Node back = root;
                Node pointer = root.next;
                while (pointer.next != null) {
                    back = pointer;
                    pointer = pointer.next;
                }
                new1.next = back.next;
                back.next = new1;
            }
        }
    }

    public void removeFirst() {
        if (root != null) {
            root = root.next;
        }
    }

    public void removeSecond() {
        if (root != null) {
            if (root.next != null) {
                Node third = root.next;
                third = third.next;
                root.next = third;
            }
        }
    }

    public void removeLast() {
        if (root != null) {
            if (root.next == null) {
                root = null;
            } else {
                Node pointer = root.next;
                Node back = pointer;
                while(pointer.next != null) {
                    back = pointer;
                    pointer = pointer.next;
                }
                back.next = null;
            }
        }

    }
    public void print() {
        Node pointer = root;
        while (pointer != null) {
            System.out.print (pointer.info + "-");
            pointer = pointer.nex;
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
            Node back = root;
            while (pointer != null) {
                if (pointer.info == may) {
                    if (pointer == root) {
                        root = root.next;
                        back = root;
                        pointer = root;
                    } else {
                        back.next = pointer.next;
                        pointer = pointer.next;
                    }
                } else {
                    back = pointer;
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
        System.out.println("Insert a node at the end:");
        lg.insertLast(160);
        lg.print();
        System.out.println("Insert a node in the second position:");
        lg.insertSecond(13);
        lg.print();
        System.out.println("Insert a node in the penultimate position:");
        lg.insertBeforeLast(600);
        lg.print();
        System.out.println("Remove the first node from the list: ");
        lg.removeFist();
        lg.print();
        System.out.println("Remove the second node from the list: ");
        lg.removeSecond();
        lg.print();
        System.out.println("Remove the last node from the list:");
        lg.removeLast();
        lg.print();
        System.out.println("Remove the largest from the list: ");
        lg.removeHigher();
        lg.print();
    }
}
```