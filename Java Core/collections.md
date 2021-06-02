# Collections

Collection Framework in Java is one of the fundamental parts of the Java programming language. Most of the programming languages majorly use the Collections. Most of them support various types of Collections such as List, Set, Queue, Stack, etc. Today in this article we will learn about the Collections in Java and how to use Collection Frameworks in Java.

**What is a Collection in Java?**

Java Collection is a group of individual items in a single unit. Collections are like containers that merge multiple items into a single unit. For example, a bundle of sticks, a list of employee names, etc. The two principal root interfaces of Java collection classes are Collection interface (java.util.Collection) and Map interface (java.util.Map).

**Collection Framework in Java**

A Collection Framework in Java is a unified architecture that represents a collection of interfaces and classes. It helps in storing and processing the data efficiently. This framework has several useful classes that have a number of useful functions that make a programmer’s task easy. The Collection Frameworks represent and manipulate Collections in Java in a standard way.

**The collection framework met several goals like:**

- It increases the efficiency of the fundamental collections like dynamic arrays, trees, linked lists, and hashtables, etc.
- Let the different types of collections work in an identical manner along with a higher degree of compatibility.
- Easily extend and/or adapt a collection.
- Remove the need for writing the code to implement the data structures and algorithms manually.
- Make our code much more efficient as the Collections Framework is highly optimized.
- Make our data unique we can use the Set interface provided by the Collections Framework.
- We can use the Map interface to store data in key/value pairs.
- Enable the functionality of resizable arrays, we can use the ArrayList class.

## Composition of Java Collection Frameworks
All collections frameworks in Java include the following:

- Interfaces
- Implementation or Classes
- Algorithms

**Interfaces**

Java Collection Framework consists of interfaces which are abstract data types that represent collections. With Interfaces, we can manipulate the collections irrespective of the details of their representation. All the interfaces of the collections framework reside in java.util package.

In object-oriented languages, interfaces normally represent a hierarchy. The root or top-level interface of the Collection Framework is java.util.Collection. It contains some important methods such as add(), size(), remove(), clear(), iterator() that every Collection class must implement.

Some other important interfaces are java.util.List, java.util.Queue ,java.util.Set, and java.util.Map. The only interface that does not inherit the Collection interface is the Map interface but it is the part of the Collections framework.

| Interface 	| Description |
|---|---|
| The Collection Interface | This interface is present at the top of the collections hierarchy and allows you to work with a  group of objects.|
| The List Interface	| This interface extends the Collection interface and the object of List stores an ordered collection of elements.|
| The Set Interface	| This interface also extends the Collection interface and handles the sets that contain unique elements.|
| The SortedSet Interface	| This interface extends the Set interface to handle the sorted sets.|
| The Map Interface	| This interface maps the unique keys to values.|
| The SortedMap Interface	| This interface extends the Map interface and maintains the keys in ascending order.|
| The Map.Entry Interface	| It is an inner class of a Map and represents an element (a key/value pair) on a map. |
| The Enumeration Interface	| It is a legacy interface that defines the methods by which you can enumerate the elements one at a time in a collection of objects. |


**Implementations**

Java Collections framework provides implementation classes for collections which are the concrete implementations of the collection interfaces. In short, these classes are reusable data structures. We can use them again and again to create different types of collections in Java code. Some important classes of collection framework are ArrayList, LinkedList, HashMap, TreeMap, HashSet, TreeSet.

These classes are more than enough to solve most of our requirements in programming, but if we still need some special collection class which we can extend to create our customized collection classes.

| Class | Description|
|---|---|
| AbstractCollection |	This class implements most of the Collection interfaces.|
| AbstractList	| This class extends the AbstractCollection class and implements most of the List interfaces.|
| AbstractSequentialList	| This class extends the AbstractList class to use a collection that performs sequential access rather than random access to its elements.|
| LinkedList |	This class implements a linked list by and extends the  AbstractSequentialList class.|
| ArrayList	| This class extends the AbstractList class and implements a dynamic array.|
| AbstractSet	| This class extends the AbstractCollection class and implements most of the Set interface.|
| HashSet	| This class extends the AbstractSet class to work with a hash table.|
| LinkedHashSet	| This class extends the HashSet class and allows iterations in insertion-order.|
| TreeSet	| This class extends the  AbstractSet class and implements the Set stored in a tree.|
| AbstractMap	| This class implements most of the Map interfaces.|
| TreeMap	| This class extends the AbstractMap class to use a tree.|
| HashMap	| This class extends the AbstractMap class to use a hash table.|
| WeakHashMap	| This class extends the AbstractMap class and uses a hash table with weak keys.|
| LinkedHashMap	| This class extends the HashMap class and allows iterations in insertion-order.|
| IdentityHashMap	| This class Extends AbstractMap class and uses reference equality when comparing documents.|

**Algorithms**

An algorithm refers to the methods that perform useful computing operations, such as searching, sorting and shuffling on objects that implement collection interfaces. The algorithms are polymorphic: that is, we can use the same method on several different implementations of the appropriate Java collection interface. We define these algorithms as static methods within the Collections class.

<p align="center">
<img  src="https://user-images.githubusercontent.com/13514156/120520142-11254580-c399-11eb-961a-2d0bacdf89c2.jpeg">
</p>



As we can see, the highest element is the Collection interface, for which, based on its natural interface, we understand that it has a series of "basic" methods where its behavior will be defined as it is implemented in more elements. The Set and List interfaces are mainly derived from it.

## Set
The Set interface will have the following characteristics:
- Stores unique, non-repeating objects
- Most of the time objects will be stored in disorder
- We do not have indexes
- Objects are stored in sequential order

## HashSet
The elements are stored in disorder and thanks to the mechanism called hasshing (it obtains an identifier of the object) it allows to store unique objects

## TreeSet
Stores unique objects, and thanks to its tree structure access is extremely fast

## ArrayList
May have duplicate records
It is not synchronized therefore it is faster

## LinkedList

May contain duplicate items
It is not synchronized (it is faster)
Being a doubly linked data structure we can add data above the stack or below

## Map

The Map interface does not inherit from the Collection interface because it represents a Mapping data structure and not a simple collection of objects. This structure is more complex, so each element must come together with another piece of information that will function as the element's key.

Map<K,V>

K - Is the key
V - Is the value

### Methods for Mao

```java
Map<Integer, String> map = new HashMap<Integer, String>();

map.size(); // returns the number of map elements
map.isEmpty(); // returns true if elements exist or false otherwise
map.put(K key, V Value); // Add element
map.get(K value); // returns the value of the key or null if it does not exist
map.clear(); // delete all elements
map.remove(K key); // Delete the element (key and value) 
map.containsKey(K key); // returns true if the key exists in the map
map.containsValue(V value); // return true  it he value exist in the map
map.values(); // return a Collection with the values of map
```

Example: 
```java
Map<Integer, String> map = new HashMap<Integer, String>();
Map<Integer, String> treeMap = new TreeMap<Integer, String>();
Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
```

As you can see, the object can only be built with three elements that implement it: HashMap, TreeMap, LinkedHashMap leaving out HashTable (Deprecada, it has redundant methods) and SortedMap (for being interface)


## HashMap

- Items are not sorted
- They do not accept duplicate keys
- They do not accept null values


Example

```java
Map<Integer, String> map = new HashMap<Integer, String>();

map.put(1, "Player1");
map.put(5, "Player5");
map.put(3, "Player3");
map.put(9, "Player9");
map.put(2, "Player2");


Iterator itetator = map.keySet().iterator();
while(it.hasNext()){
    Integer key = it.next();
    System.out.println("Key " + key + " -> Valor: " + map.get(key));
}
```


## LinkedHashMap
Order the elements as they are inserted; causing the searches to be slower

```java
Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

linkedHashMap.put(1, "Player1");
linkedHashMap.put(5, "Player5");
linkedHashMap.put(3, "Player3");
linkedHashMap.put(9, "Player9");
linkedHashMap.put(2, "Player2");


Iterator itetator = linkedHashMap.keySet().iterator();
while(it.hasNext()){
    Integer key = it.next();
    System.out.println("Key " + key + " -> Valor: " + linkedHashMap.get(key));
}
```

## TreeMap

The map sorts it "naturally". For example, if the key is integer values ​​(as we will see later), it orders them from least to greatest
To iterate any of these values ​​it will be necessary to use the Iterator interface and to go through it we will do a while loop as shown:

```java
Map<Integer, String> treeMap = new TreeMap<Integer, String>();

treeMap.put(1, "Player1");
treeMap.put(5, "Player5");
treeMap.put(3, "Player3");
treeMap.put(9, "Player9");
treeMap.put(2, "Player2");


Iterator itetator = treeMap.keySet().iterator();
while(it.hasNext()){
    Integer key = it.next();
    System.out.println("Key " + key + " -> Valor: " + treeMap.get(key));
}
```

Another of the most useful things is to work with the maps as they will follow an ArrayList

```java
for(Entry<Integer, String> players : linkedHashMap.entrSet()){
    Integer key = players.getKey();
    String value = players.getValue();
    System.out.println( key + "-> " + value );
}

```
