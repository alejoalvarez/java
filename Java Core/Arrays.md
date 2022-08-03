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
