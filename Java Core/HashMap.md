# HashMap

A HashMap store items in "key/value" pairs, and you can access them by an index of another type (e.g. a String).

One object is used as a key (index) to another object (value). It can store different types: String keys and Integer values, or the same type, like: String keys and String values.

Example:

Create a HashMap object called capitalCities that will store String keys and String values:

```java
import java.util.HashMap; // import the HashMap class
HashMap<String, String> capitalCities = new HashMap<String, String>();
```

## Add Items
The HashMap class has many useful methods. For example, to add items to it, use the **put()** method:

Example

```java
import java.util.HashMap;
public class Main {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<String, String> capitalCities = new HashMap<String, String>();
// Add keys and values (Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    System.out.println(capitalCities);
  }
}
```

## Access an Item
To access a value in the HashMap, use the get() method and refer to its key:

Example

```java
capitalCities.get("England");
```

## Remove an Item
To remove an item, use the remove() method and refer to the key:

Example
```java
capitalCities.remove("England");
```

To remove all items, use the clear() method:
Example

```java
capitalCities.clear();
```
