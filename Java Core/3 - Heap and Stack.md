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

<p align="center">
<img width="471"  src="https://github.com/alejoalvarez/java/assets/13514156/c3dcc689-5782-454f-bc98-2548c4741ad0">
</p>

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

# Operation Heap

<p align="center">
<img width="471"  src="https://github.com/alejoalvarez/java/assets/13514156/6d77a308-8a8a-49a6-a205-43a6c3f5d54f">
</p>

<p align="center">
<img width="471"  src="https://github.com/alejoalvarez/java/assets/13514156/5fce2be5-efe1-4793-b155-00b2442c5803">
</p>

When the **createCard** method finishes, the stack variables and their references are removed, and the objects are removed from the Heap (this is done through the garbage collector).

# Operation Stack

<p align="center">
<img width="471"  src="https://github.com/alejoalvarez/java/assets/13514156/eadbc247-46bf-4cee-b0b6-a85dd50f69ef">
</p>

<p align="center">
<img width="471"  src="https://github.com/alejoalvarez/java/assets/13514156/224a9fac-944c-4977-bb20-ba9921736353">
</p>

When the **createCard** method terminates, the **createCard** section is deleted.

<p align="center">
<img width="471"  src="https://github.com/alejoalvarez/java/assets/13514156/62da4854-e6ba-4164-86d7-99ab8652c6dd">
</p>










