# Collections

<p align="center">
<img height="270" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/Collections.jpeg">
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