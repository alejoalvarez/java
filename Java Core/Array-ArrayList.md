# Array vs ArrayList

Both Array and ArrayList are the data structures in Java that serve the same purpose. Both are being used for storing variables of the same data type and performing operations on them but they have some differences in terms of implementation and performance.

# Difference between Array and ArrayList in Java

## 1- Nature

Arrays in Java are static in nature, i.e we can not change their length. The length of the array is fixed. Once we declare the length at the time of array creation, we can not change its size again.

On the other hand, ArrayList in Java is dynamic in nature, therefore we also sometimes call it a re-sizeable array or dynamic array. ArrayList can automatically grow in their size if we add more limits beyond its defined capacity, therefore it is dynamic in nature.

## 2- Implementation

An array is a fundamental feature of Java, while ArrayList is a part of the Collection Framework API in Java. ArrayList in Java is internally implemented using Arrays. ArrayList is a class that carries all the properties of a normal class; we can create objects from it and call methods with the object.

While an Array is an object in Java but there is no method that we can call using this object. An array just has a single attribute called length that too is constant.

## 3- Performance

Since ArrayList internally works based on the array, you may think that performance of both of them would be the same.

Basically, it can be considered true but the performance of ArrayList may be slower as compared to Arrays because it has some extra functionality other than Arrays. The performance of ArrayList affects mainly in terms of CPU time and memory usage.

Any resize() operation on ArrayList may degrade the performance of ArrayList since it involves the creation of a new array and then copying the content from the old array to the new array. This operation, therefore, slows down the performance of ArrayList.

## 4- Flexibility

Flexibility is the most important factor that significantly differentiates the array and ArrayList in Java. ArrayList is more flexible as compared to Arrays in Java. This is because ArrayList is dynamic in nature. ArrayList can grow automatically when the elements are being added beyond its capacity, which is not possible with arrays. Moreover, ArrayList also allows us to remove elements from it while it is not possible with arrays. We can’t remove elements from an array after adding them.

## 5. Type of data stored

Arrays can contain both primitive data types or objects of a class as the array elements. But ArrayList can contain only objects of a class. It can not have primitive data types as its elements.

Whenever we pass an integer to the add method of ArrayList, it converts that number into the Wrapper class Integer object. Thus, we can say that the Autoboxing of Java 5 provides us the way to use the primitive data types in the ArrayList.

**For example:**

```java
ArrayList arrayList = new ArrayList();
arrayList.add(12); //  add 12 int primitive data type
```

Here, JVM through will automatically convert the primitive data type into the equivalent object and ensures that only objects are added to the array list.

Thus , above step internally works like this :

```java
arrayList.add(new Integer(12));
// Converting int primitive to Integer object and added to arrayList object.
```

## 6- Generics

One more major difference between arrays and ArrayList is that ArrayList supports the generics in Java but arrays do not support generics. This is because of the interaction problem of arrays with the Generics; Arrays are covariant in nature while Generics is invariant.

The compiler does not allow the arrays to use Generics in them. While, it is possible to use Generics with ArrayList.

## 7- Iteration

The elements of an array can iterate only with the help of for loop, for-each or a while loop. But to iterate the elements of [ArrayList](https://www2.cs.duke.edu/csed/java/jdk1.6/api/java/util/ArrayList.html) there is a facility of iterators in Java. We can use the Iterator and ListIterator class to iterate over an ArrayList.

However, we can also use the for, while, and for-each loops to iterate an ArrayList. But arrays do not support an iterator to iterate it as the case in ArrayList. This concludes that ArrayList provides more ways to iterate than Arrays.

## 8. Checking the Size

We can check the size of an array using its attribute called length. While the ArrayList provides a method called size() to check its size.

Moreover, the length attribute of the array only specifies the number of slots in the array; that is how many elements an array can store; it does not provide us the information that how many slots are filled and how many of them aren’t filled.

The size() method of ArrayList is different as it also provides the current capacity of the ArrayList.

**For example:**

```java
int array[] = new int[3];
arrayLength = array.length; //using length attribute

ArrayList arrayList = new ArrayList();
arrayList.add(12);
arrayList.size(); //using size() method
```

## 9- Dimension

This is another significant difference between an Array and an ArrayList.An Array can be single dimensional or multi-dimensional; i.e., it can also have multiple dimensions that help us to represent 2-D and 3-D objects.

On the other hand, ArrayList can not be multi-dimensional, it can only be one or single-dimensional. In fact, it does not allow you to specify the dimension. It is by default one-dimensional in nature.

**For example:**
```java
Integer myArray[][] = new Integer[3][2]; //multidimensional array
myArray[0][0] = new Integer(8);
```

## 10- Type Safety

As we discussed earlier, ArrayList supports generics while array does not, so ArrayList is type-safe as it allows the compiler to check whether the objects of the ArrayList are correct or not. On the other hand, type checking is not possible with arrays as it does not have a support of Generics, therefore array is not type-safe.

ArrayList supports compile-time checking which ensures type safety during the compilation process itself. But array supports Runtime Checking and therefore the compiler will not show an error related to type checking. Instead, you will get an ArrayStoreException at the runtime of the code.

**For example:**
```java
String stringArray[] = new String[5];
// creates a string array of size 5
stringArray[0] = new Integer(12);
// throws ArrayStoreException, trying to add Integer object in String[]
```

## 11- Supported operations

ArrayList provides many methods or operations to manipulate it while array does not provide any such method. ArrayList supports methods such as ```get()```, ```isEmpty()```, ```indexOf()```, ```replaceAll()```, ```contains()```, ```clear()```, ```removeAll()```. There is no support for such methods in Arrays.

# Example of Array and ArrayList in Java

```java

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayVSArrayList {
  public static void main(String args[]) {
    //Normal Arrays
    int[] arr = new int[5];
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    arr[3] = 4;
    arr[4] = 5;
    //Accessing array elements
    System.out.println("The first element of array is: " + arr[0]);
    System.out.println("The second element of array is: " + arr[1]);

    //ArrayList
    //Creating an arrayList with initial capacity 5
    ArrayList < Integer > arrayList = new ArrayList < Integer > (5);

    // Add elements to ArrayList
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);

    // Accessing the  elements of ArrayList
    System.out.println("The first element of arrayList is: " + arrayList.get(0));
    System.out.println("The second  element of arrayList is: " + arrayList.get(1));
  }
}
```

Output
```
The first element of array is: 1
The second element of array is: 2
The first element of arrayList is: 1
The second element of arrayList is: 2
```

```java
import java.util.ArrayList;
import java.util.Arrays;
public class Test {
  public static void main(String args[]) {
    //Normal arrays in which we need to specify the size for array
    int[] myArray = new int[5];
    myArray[0] = 1;
    myArray[1] = 2;
    myArray[2] = 3;
    myArray[3] = 4;
    myArray[4] = 5;

    System.out.println("Accessing arrays:");
    System.out.println(Arrays.toString(myArray));

    /* We cannot add more elements to array myArray as it is fixed size, otherwise we will get an error.*/

    //ArrayList we need not to specify size in ArrayList

    ArrayList < Integer > arrayList = new ArrayList < Integer > ();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    // We can add more elements to arrayList

    System.out.println("Accessing ArrayList:");

    System.out.println(arrayList);
  }
}
```

Output
```
Accessing arrays: 
[1,2,3,4,5]
Accessing ArrayList:
[1,2,3,4] 
```

**Code to illustrate that arrays can contain primitive and object types but ArrayList cannot have primitive type elements:**

```java

import java.util.ArrayList;
public class DemoClass {
  public static void main(String args[]) {
    // primitive types allowed in an array
    int[] array = new int[3];

    // Objects are also allowed in an array
    DemoClass[] array1 = new DemoClass[3];

    // Not allowed to add primitive type-below line gives compiler error)

    ArrayList < char > arrayList = new ArrayList < char > ();

    // This is Allowed in ArrayList
    ArrayList < Integer > arrayList1 = new ArrayList < >();
    ArrayList < String > arrayList2 = new ArrayList < >();
    ArrayList < Object > arrayList3 = new ArrayList < >();
  }
}
```

Output
```
DemoClass.java:14: error: unexpected type 
ArrayList<char> arrayList = new ArrayList<char>();
^
required: reference
found: char
```

