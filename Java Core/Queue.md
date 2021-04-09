# Queue

Logically, a queue is a FIFO (First In First Out) data structure and we can physically implement it either as an array or a linked list. Whatever way we use to implement a queue, insertions always take place at the “rear” end and deletions always from the “front” end of the queue.

**Common operations on a queue are:**

- **Enqueue():** Adding elements at the rear end of the queue.
- **Dequeue():** Deleting elements from the front end of the queue.

Variations in Queue:

Depending on the requirements of the program, we can use the queues in several forms and ways. Two popular variations of queues are Circular queues and Dequeues (Double-ended queues).

## Circular Queues
Circular Queues are the queues implemented in circle form rather than a straight manner. Circular queues overcome the problem of unutilized space in the linear queues that we implement as arrays.

## Dequeues
A double-ended queue or a dequeue is a refined queue in which can add or remove the elements at either end but not in the middle.

Applications of a Queue:

- Queues are useful in telephone inquiries, reservation requests, traffic flow, etc. While using telephone directory service, you might have sometimes heard “Please wait, You are in A QUEUE”.
- To access some resources like printers queues, disk queues, etc.
- For breadth-first searching in special data structures like graphs and trees.
- For handling scheduling of processes in a multitasking operating system example FCFS (First Come First Serve) scheduling, Round-Robin scheduling, etc.
