# List

A list is a set of nodes, each of which has two fields: an information field and a pointer to the next node in the list. In addition, an external pointer points to the first node in the list.

Graphic representation of a node

IMAGE

The information can be any simple data type, data structure, or even one or more objects.

The address to the next node is a pointer.

Graphic representation of a list

IMAGE


A list is a sequence of nodes

The information of the nodes in this case is an integer and always contains a pointer that stores the address of the next root node is another external pointer to the list that contains the address of the first node.

# Types of lists.

According to the mechanism of insertion and extraction of nodes in the list we have the following types:

- Stack type lists.
- Queue type lists.
- Generic lists.

A list behaves like a **stack** if the insertions and extractions are done on the same side of the list. Also called **LIFO** (Last In First Out) lists.

A list behaves like a **queue** if the inserts are done at the end and the extracts are done at the front of the list. They are also called **FIFO** (First In First Out) lists.

A list behaves as **generic** when insertions and extractions are performed anywhere in the list. We can at some point insert a node in the middle of the list, at another time at the end, delete one from the front, delete one from the bottom or one inside etc.
