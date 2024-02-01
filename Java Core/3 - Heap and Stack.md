# Heap and Stack

# Heap (Heap memory)
When running a Java program, the JVM requests memory from the operating system for all its functions, this memory is called Heap memory.

- Save Objects
- It is the dynamic memory zone (Management objects - creation, modification, deletion)
- It is managed by the garbage collector
- When trying to create more objects in memory and the memory has no capacity, an ```OutOfMemoryError``` is generated.
- A minimum and maximum is defined in the JVM parameters.
```java
java - Xms <size> -Xmx <size>
- xms initial size
- xmx size when it runs out xms
```

## Heap Sections


- **Young generation:**  New created objects
- **Old generation:** objects with a certain lifetime
- **Permanent generation:** Metadata for JVM

# Stack (Stack memory)

- Stores all primitive type variables and references. (FIFO)
- Each thread has its own Stack when the thread is running
- Stack memory is like an array that stores variables, method invocations and object references.
- When this memory limit is reached, a `StackOverFlowError` is generated.
- A size the JVM parameters.

```java
java -Xms <size>
```

