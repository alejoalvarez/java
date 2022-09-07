# Arrays

- A Java array is a data structure that allows you to store data of the same type
- One-dimensional arrays (called vectors)
- Multidimensional arrays (we call arrays)
- The size of arrays is declared and cannot be changed at runtime.

## Important

- Arrays can have data items of simple and similar types such as int or float, or even user-defined datatypes like structures and objects.
- The direct superclass of an array type is Object.
- Arrays are considered as objects in Java.
- The indexing of the variable in an array starts from 0.
- Each array type implements the ```Cloneable``` and ```java.io.Serializable``` interfaces.
- We must define an array before we can use it to store information.
- The storage of arrays in Java is in the form of dynamic allocation in the heap area.
- We can find the length of arrays using the member ‘length’.
- The size of an array must be an int value.
- The array can contain primitive data types as well as objects of a class according to the definition of the array.
  - For **primitive data types**, the real values are stored in **contiguous memory locations**.
  - For **objects of a class**, the real objects are stored on the **heap**

## Arrays can be of 3 types:

- Single Dimensional Arrays
- Two-dimensional Arrays
- Multi-dimensional arrays

## One-dimensional array (vector)

```java
Option 1
String [] array = new String[2];
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
int[] myNum = {10, 20, 30, 40};

Option 2
String array [] = new String[2];
String [] array = new String[variable];
```

**Literal array**

In a situation where the size and elements of the array are known, array literals can be used.
```java
int[] intArray = new int[]{1,2,3,4};
```
- it is not necessary to write ```new int[]``` in the latest versions of java

### Multidimensional array (Arrays)
- A multidimensional array is an array containing one or more arrays.


```java
String [][] array = new String [3][3];
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };

```

### Irregular array

They are those that the number of elements in each row is variable, it is only mandatory to indicate the number of rows

```java
int [][] matriz2 = new int[3][];
int [][] numeros = {{6,7,5}, {3, 8, 4}, {1,0,2}, {9,5,2}}; 
int [][] a = {{6,7,5,0,4}, {3, 8, 4}, {1,0,2,7}, {9,5}};

```

## Cloning array
when cloning a single one-dimensional array, such as Object[], a deep copy is made, with the new array containing copies of the original array's elements rather than references

```java
public class CloningOneDimensionalArray {
    public static void main(String args[]){
        int[] intArray = {1, 2, 3};

        int[] cloneArray = intArray.clone();
        // prints false as a deep copy is created
        System.out.println(intArray == cloneArray);
        for(int i = 0; i < cloneArray.length; i++){
            System.out.print(cloneArray[i] + " ");
        }
    }
}
```

however, a clone of a multidimensional array (such as Object[][]) is a "shallow copy", meaning that only a new array is created with each element array as a reference to an original element array, but subfields are shared.

```java
public class CloningMultiDimensionalArray {
    public static void main(String args[]){
        int[][] intArray = {{1, 2, 3},{4,5}};

        int[][] cloneArray = intArray.clone();
        // prints true as a deep copy is created
        System.out.println(intArray == cloneArray);
        System.out.println(intArray[0] == cloneArray[0]);
        System.out.println(intArray[1] == cloneArray[1]);
    }
}
```

# Methods of Java Array Class

## int compare(array1, array2)

This method compares two arrays in lexicographic order. 

We pass two arrays as parameters to its methods. 
It returns:
- **1** if array1 is greater than array2,
- **-1** if array1 is smaller than array2
- **0** if both arrays are equal to each other.

```java

import java.util.Arrays;

public class CompareMethod
{
  public static void main(String[] args){
    int myArray1[] = { 10, 15, 32, 30 }; // Create the first Array
    int myArray2[] = { 10, 25, 22 ,30}; // Create the second Array

    // comparing both arrays
    System.out.println("Comparing two integer arrays: " + Arrays.compare(myArray1, myArray2));
  }
}

```

Ouput
```
Comparing two integer arrays: -1
```

## void fill(originalArray, value)

This method is used to fill the specific value to each element of the specified array with a specific type. This method can also be used with all the other primitive data types (byte, short, int, etc.).

```java
import java.util.Arrays;

public class FillMethod{

  public static void main(String[] args){

    int myArray1[] = new int[5]; // Create the Array
    int fillvalue = 15;
    Arrays.fill(myArray1, fillvalue);

    // To fill the arrays
    System.out.println("Integer Array on filling: " + Arrays.toString(myArray1));
  }
}
```

Output
```
Integer Array on filling: [ 15,15,15,15,15 ]
```

## boolean equals(array1, array2)

This method checks whether both the arrays are equal or not and gives the result either as true or false.

```java
import java.util.Arrays;

public class EqualsMethod{

  public static void main(String[] args){
    //create arrays to be compared
    int array1[] = { 45, 68, 34, 20, 56 };
    int array2[] = { 45, 68, 34, 20, 56 };
    int array3[] = { 55, 78, 44, 10, 56 };

    System.out.println("Comparing array1 and array2: " + Arrays.equals(array1,array2));
    System.out.println("Comparing array2 and array3: " + Arrays.equals(array2,array3));
  }
}
```

Output
```
import java.util.Arrays;

public class EqualsMethod{
  
  public static void main(String[] args){
    //create arrays to be compared
    int array1[] = { 45, 68, 34, 20, 56 };
    int array2[] = { 45, 68, 34, 20, 56 };
    int array3[] = { 55, 78, 44, 10, 56 };

    System.out.println("Comparing array1 and array2: " + Arrays.equals(array1,array2));
    System.out.println("Comparing array2 and array3: " + Arrays.equals(array2,array3));
  }
}
```

Output
```
Comparing array1 and array2: true
Comparing array2 and array3: false
```

## int binarySearch(array [], value)

With the help of this method, we can find or search a specified value inside an array which is given as the first argument. As a result, this method returns the index of the element in the array. The array must be sorted for this search. If the element is not found, it returns a negative value.

```java
import java.util.Arrays;

public class BinarySearch{

  public static void main(String[] args){
    //create arrays
    int array1[] = { 20, 34,56,78,97 };
    int intKey = 56;
    System.out.println(intKey + " found at index = " + Arrays .binarySearch(array1, intKey));
    System.out.println(20 + " found at index = " + Arrays .binarySearch(array1, 20));
  }
}
```

Output
```
56 found at index = 2
20 found at index = 0
```

## copyOf(originalArray, newLength)

We can copy the specified array to a new array with a specified length. The left spaces are assigned to default values in the new array.

```java
import java.util.Arrays;

public class CopyOfMethod{
  
  public static void main(String[] args){

    int array1[] = { 65, 20, 34, 56, 78, 97 }; //create arrays

    // To print the elements in one line
    System.out.println("Integer Array: "+ Arrays.toString(array1));

    System.out.println("\nNew Arrays by copyOf method:");
    System.out.println("Integer Array: "+ Arrays.toString( Arrays.copyOf(array1, 10)));
  }
}
```

Output
```
import java.util.Arrays;

public class CopyOfMethod{
  
  public static void main(String[] args){

    int array1[] = { 65, 20, 34, 56, 78, 97 }; //create arrays

    // To print the elements in one line
    System.out.println("Integer Array: "+ Arrays.toString(array1));

    System.out.println("\nNew Arrays by copyOf method:");
    System.out.println("Integer Array: "+ Arrays.toString( Arrays.copyOf(array1, 10)));
  }
}
```

Output
```
Integer Array: [65, 20, 34, 56, 78, 97]
New Arrays by copyOf method:
Integer Array: [65, 20, 34, 56, 78, 97, 0, 0, 0, 0]
```
