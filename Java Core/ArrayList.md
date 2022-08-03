## ArrayList

The difference between a built-in array and an ```ArrayList``` in Java, is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one). While elements can be added and removed from an ArrayList whenever you want. 

Important

- Arrays can have data items of simple types such as int or float, or even user-defined datatypes like structures and objects.
- The common data type of array elements is known as the base type of the array.
- Arrays are considered as objects in Java.
- The indexing of the variable in an array starts from 0.
- Like other variables in Java, an array must be defined before it can be used to store information.
- Arrays in Java are stored in the form of dynamic allocation in the heap area.
- We can find the length of arrays using the member ‘length’.
- The size of an array must be an int value.
- Object class is a superclass of the Array.
- Array implements the two interfaces: Serializable and Cloneable.

## Example

```java
import java.util.ArrayList;

ArrayList<String> cars = new ArrayList<String>();
```

### Add Items

Example

```java
import java.util.ArrayList;
public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Audi");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
  }
}
```

### Access an Item
To access an element in the ArrayList, use the ```get()``` method and refer to the index number:

Example
```java
cars.get(0);
```

### Change an Item
To modify an element, use the ```set()``` method and refer to the index number:

Example
```java
cars.set(0, "item");
```

### Remove an Item
To remove an element, use the ```remove()``` method and refer to the index number:

Example
```java
cars.remove(0);
```

### Remove all items
To remove all the elements in the ArrayList, use the ```clear()``` method:

Example
```java
cars.clear();
```

### ArrayList Size
To find out how many elements an ArrayList have, use the ```size()``` method:

Example
```java
cars.size();
```

### Loop - ArrayList

Loop through the elements of an ArrayList with a for loop, and use the size() method to specify how many times the loop should run:

Example
```java
public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Audi");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i));
    }
  }
}
```

You can also loop through an ArrayList with the for-each loop:

Example
```java
public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Audi");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    for (String i : cars) {
      System.out.println(i);
    }
  }
}
```

### Sort an ArrayList
Another useful class in the java.util package is the Collections class, which include the ```sort()``` method for sorting lists alphabetically or numerically:


Sort an ArrayList of Strings:

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Audi");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    Collections.sort(cars);
    for (String i : cars) {
      System.out.println(i);
    };
  }
}
```

Sort an ArrayList of Integers:

```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    myNumbers.add(33);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(34);
    myNumbers.add(8);
    myNumbers.add(12);
    Collections.sort(myNumbers);
    for (int i : myNumbers) {
      System.out.println(i);
    };
  }
}
```
