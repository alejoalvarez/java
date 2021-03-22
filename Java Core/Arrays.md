## Arrays

Objects in which more than one variable can be saved according to their size and capacity, the saved variables must be of the same type
- One-dimensional arrays (called vectors)
- Multidimensional arrays (we call arrays)

Example one-dimensional

```java
Option 1
String [] array = new String[2];
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
int[] myNum = {10, 20, 30, 40};

Option 2
String array [] = new String[2];
String [] array = new String[variable];
```

• Multidimensional arrays (we call arrays)
A multidimensional array is an array containing one or more arrays.

Example multidimensional:

```java
String [][] array = new String [3][3];
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };

```

**Irregular array**

They are those that the number of elements in each row is variable, it is only mandatory to indicate the number of rows

```java
int [][] matriz2 = new int[3][];
int [][] numeros = {{6,7,5}, {3, 8, 4}, {1,0,2}, {9,5,2}}; 
int [][] a = {{6,7,5,0,4}, {3, 8, 4}, {1,0,2,7}, {9,5}};

```
