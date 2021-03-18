# Java CORE / Java Standard Edition

# Table of Contents
1. [JDK - JRE - JVM](#jdk-jre-jvm)
2. [Multiplatform](#multiplatform-java)
3. [Why use java?](#example3)
4. [Development platforms](#example4)
5. [Reserved words](#example5)
6. [Comments](#example6)


## JDK - JRE - JVM

**JDK** is Composed of 3 things:
- **JRE** - Java Runtime Environment, contain the (JVM, libraries, javaw, etc)
    - **JVM** (Java Virtual Machine) => Just in Time compiler (JIT)
- Development API 
- Java compiler

<p align="center">
<img height="250" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/JDK.png">
</p>

```JRE``` => Named at the beginning as JVM, it is made up of the JVM, some clasess of the core of the platform and libraries of the own language

## Multiplatform Java

- The characteristic of being cross-platform is that a program written in java must be compiled and then interpreted by the JRE or JVM
- Compile (Go to source code to machine code)
- Source code is .java
- Java generates an intermediate called bytescode.class which is neither machine code nor .java language. The JRE is applied to this intermediate file to later generate a file interpreted in real time which, if it is machine code

## Why use java?

- Object oriented
- Language compiled and embedded at the same time
- Strongly typed
- Java works on different platforms (Windows, Mac, Linux, Raspberry Pi, etc.)
- Simplicity
- Strong
- Has garbage collector
- 100% portable
- Ease of programming in networks

## Development platforms

Java SE
- J2SE
- Desktop

Java ME
- J2ME
- Moviles

Java EE
- J2EE
- Desktop, Web, Architectures, etc

Java FX
- Rich internet applications

## Reserved Words

Here some reserved words

<p align="center">
<img height="250" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/reservedWords.jpeg">
</p>

## Comments

Comments can be used to explain Java code. It can also be used to prevent execution when testing alternative code

- One line

    ```// Here put the comment**```
- Several lines

   ``` /* Here put the comments */```

- Documentation comments (is used with javadoc)
```
   /**
    method: description
    params: description
    return: description
   */
```

## Identifiers

- They are names of variables or methods
- Must be identified with unique names.
- They do not have maximum length
- The first character of the identifier must be lowercase letter and cannot contain whitespace (can contain letters, digits, underscores and dollar signs)
- It is not allowed to use reserved words as identifier

valid examples

- yearBird
- _example_
- NameOfVariableSoLongButNotMatter

invalid examples

- 3values (contain numbers)
- day&month (contain &)
- two-values (contain -)
- example 2 (contain spaces)

## Variables

Variables are containers for storing data values
They are memory spaces used for our programs

Type of variables:

- **String** - stores text, such as "Hello". String values are surrounded by double quotes
- **int** - stores integers (whole numbers), without decimals, such as 123 or -123
- **float** - stores floating point numbers, with decimals, such as 19.99 or -19.99
- **char** - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
- **boolean** - stores values with two states: true or false

Syntax: 
type variableName = value;

Examples

- int variable1;
- double price;
- boolean flag;
- String name;

## Constants

Refers to values ​​that do not change during program execution

Examples

- final double PI = 3.1416;
- final string NAME = "Alejo"
- final boolean CHECK = true;

## Data Types

- Primitive Type
They have no methods
They are not objects
They do not need an invocation to be created
short, int, char, boolean

- Object Type
Commonly called wrapper
With methods
They need an invocation to be created
Types of the standard library - String, it is for text chain others are (Scanner, TreeSet, ArrayList ...)
User-defined types, example (Car, Bus, People etc)
Array types - vector or matrix type elements, they are special objects that lack methods
Wrapper types, the same as primitive types but as objects (Byte, Short, Integer etc.)

Note: ```The difference between int and Integer is that Integer being a wrapper allows null```

<p align="center">
<img height="250" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/primitiveType.jpeg">
</p>

<p align="center">
<img height="250" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/objectType.jpeg">
</p>


**Type casting**

Type casting is when you assign a value of one primitive data type to another type.

In Java, there are two types of casting:

Widening Casting (automatically) - converting a smaller type to a larger type size
byte -> short -> char -> int -> long -> float -> double

Narrowing Casting (manually) - converting a larger type to a smaller size type
double -> float -> long -> int -> char -> short -> byte

## Control instructions

**Conditional instructions:**

- if 
Syntax
```java 
    if (condition) //code block; 
```

- if/else 
Syntax
```java
    ìf (condition) {
        // code block, if the condition is true;
    } else {
        // code block, if the condition is false;
    }
```

- else if
Syntax
```java
    if (condition1) {
    // block of code to be executed if condition1 is true
    } else if (condition2) {
    // block of code to be executed if the condition1 is false and condition2 is true
    } else {
    // block of code to be executed if the condition1 is false and condition2 is false
}

- Ternary operator
Syntax
```java
variable = 	condition ? expressionTrue: expressionFalse
```


**Loops**
- while
The while loop loops through a block of code as long as a specified condition is true:

Sintax
```java
    while (condition) {
  // code block to be executed
}
```
- do
The do/while loop is a variant of the while loop. This loop will execute the code block once, before checking if the condition is true, then it will repeat the loop as long as the condition is true

Syntax
```java
    do {
    // code block to be executed
    }   
    while (condition);
```
- for
When you know exactly how many times you want to loop through a block of code, use the for loop instead of a while loop:

Syntax
```java
    for (instruction1 ; limit; instruction2){
        instructions;
    }
```

- for-each
There is also a "for-each" loop, which is used exclusively to loop through elements in an array:

Syntax
```java
    for (type variableName : arrayName) {
    // code block to be executed
    }
```
example 
```java
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    for (String i : cars) {
    System.out.println(i);
    }
```

**Selection**

Use the switch statement to select one of many code blocks to be executed.

- switch/case
```java
    switch (expression){

    case x: 
        // code block
        break;
    case y:
        // code block
        break;
    default:
        // code block
}
```

This is how it works:

The ```switch``` expression is evaluated once.
The value of the expression is compared with the values of each case.
If there is a match, the associated block of code is executed.
The ```break``` and ```default``` keywords are optional

```break```: When Java reaches a break keyword, it breaks out of the switch block.
- This will stop the execution of more code and case testing inside the block
- When a match is found, and the job is done, it's time for a break. There is no need for more testing.

```default```: The default keyword specifies some code to run if there is no case match
Note that if the default statement is used as the last statement in a switch block, it does not need a break.


## Operators
Operators are used to perform operations on variables and values.

**Arithmetic**
Arithmetic operators are used to perform common mathematical operations.

|Operator|Name|Description|Example|
|---|---|---|---|
|+|Addition|Adds two values|x + y|
|-|Substraction|subtracts two values|x - y|
|*|Multiplication|Multiplies two values|x * y|
|/|Division|Divide one vlue from another value|x / y|
|%|Modulus|Returns the division remainder|x % y|
|++|Increment|Increases the value of a variable by 1|++x|
|--|Decrement|Decreases the value of a variable by 1|--x|
|++|Increment|Increases the value of a variable by 1|x++|
|--|Decrement|Decreases the value of a variable by 1|x--|

**Assignment**
Assignment operators are used to assign values to variables.

|Operator|Example|Equals|
|---|---|---|
|=|x=5|x=5|
|+=|x+=5|x= x + 5|
|-=|x-=5|x= x - 5|
|*=|x*=5|x= x * 5|
|/=|x/=5|x= x / 5|
|%=|x%=5|x= x % 5|
|&=|x&=5|x= x & 5|

**Relationals / Comparison**
Comparison operators are used to compare two values:

|Operator|Name|Example|
|---|---|---|
|==|Equal to| x == y|
|!=|Distinct| x != y|
|>|Greater than| x > y|
|<|Less than| x < y|
|>=|Greater than or equal to| x >= y|
|<=|Less than or equal to| x <= y|

**instanceOf**
<object> instanceof <class> determines if an object belongs to a class

example
```java
    if (professor instanceOff InternalProfessor){
        // code block
    }else
    {
        code block
}
```

**Logicals**
Logical operators are used to determine the logic between variables or values:

|Operator|Name|Description|Example|
|---|---|---|---|
|&&|AND - Logical and| Returns true if both statements are true| 	x < 5 &&  x < 10 |
|```|||```|OR -  Logical or| 	Returns true if one of the statements is true|x < 5 ```||``` x < 4|
|!| NOT - Logical not| 	Reverse the result, returns false if the result is true |!(x < 5 && x < 10)|

&& y || perform lazy operations 
- Op1 && Op2 => if Op1 is false Op2 is not evaluated
- Op1 || Op2 => if Op1 is false Op2 is not evaluated
& y | the two operators are always evaluated

example

```java
    (x > y) ?  x : y  /// x is IF, y is ELSE
```

**Bit level**
>>, <<, >>>, &, |, ^, ~

## Arrays

Objects in which more than one variable can be saved according to their size and capacity, the saved variables must be of the same type
• One-dimensional arrays (called vectors)

example one-dimensional

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



example multidimensional

```java
String [][] array = new String [3][3];
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };

```

Irregular array

They are those that the number of elements in each row is variable, it is only mandatory to indicate the number of rows

## Methods
- A method is a block of code which only runs when it is called.
- Methods are used to perform certain actions, and they are also known as functions.
- A method must be declared within a class

Example 
```java
public class Main {
  static void exampleMethod() {
    // code to be executed
  }
}
```

**exampleethod()** is the name of the method
**static** means that the method belongs to the Main class and not an object of the Main class. You will learn more about objects and how to access methods through objects later in this tutorial.
**void** means that this method does not have a return value. You will learn more about return values later in this chapter

### Parameters and arguments

Information can be passed to methods as parameter. Parameters act as variables inside the method.


Example 
```java
public class Main {
  static void printName(String name) {
    System.out.println(name + " Alejo");
  }

  public static void main(String[] args) {
    printName("Alejo"); // Alejo

  }
}
```

### Method overloading 

Multiple methods can have the same name with different parameters:

- int printNumbers(int x)
- float printNumbers(float x)
- double printNumbers(double x, double y)

### Static vs Non-static

You will often see Java programs that have either static or public attributes and methods.

Static method, which means that it can be accessed without creating an object of the class, unlike public, which can only be accessed by objects:

example

```java
public class Main {
  // Static method
  static void staticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void publicMethod() {
    System.out.println("Public methods must be called by creating objects");
  }

  // Main method
  public static void main(String[] args) {
    staticMethod(); // Call the static method
    // publicMethod(); This would compile an error

    Main myObj = new Main(); // Create an object of Main
    myObj.publicMethod(); // Call the public method on the object
  }
}

```

## Constructor Method

A constructor in Java is a special method that is used to initialize objects. The constructor is called when an object of a class is created. It can be used to set initial values for object attributes

- Note that the constructor name must **match the class name**, and it cannot have a **return type** (like ```void```).

Example:

```java
// Create a Main class
public class Main {
  int x;  // Create a class attribute

  // Create a class constructor for the Main class
  public Main() {
    x = 7;  // Set the initial value for the class attribute x
  }

  public static void main(String[] args) {
    Main myObj = new Main(); // Create an object of class Main (This will call the constructor)
    System.out.println(myObj.x); // Print the value of x
  }
}

// Outputs 7
```

Example 2

```java
public class Main {
  int modelYear;
  String modelName;

  public Main(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    Main myCar = new Main(1980, "Audi");
    System.out.println(myCar.modelYear + " " + myCar.modelName);
  }
}

// Outputs 1969 Mustang
```

## Main method
It is where our application starts
• It is a standard used by the JVM to initialize the execution of any Java program
• For managed containers such as Sevlets, EJB among others, these have their own life cycle methods
• They must always contain the qualifiers public and static
• They should never return a value as a result, you must indicate the void method as a return
• It must have as a parameter the value String []
It can be written in 3 ways:

- public static void main(String args[]){}
- public static void main(String [] args){}
- public static void main(String… args){} 
<<<<<<< HEAD

## Modifiers

 Access modifier, meaning that it is used to set the access level for classes, attributes, methods and constructors

 We divide modifiers into two groups:

- Access Modifiers - controls the access level
- Non-Access Modifiers - do not control access level, but provides other functionality

### Access Modifiers

For classes, you can use either public or default:
- **public** => The class is accessible by any other class
- **default** => The class is only accessible by classes in the same package. This is used when you don't specify a modifier.

For attributes, methods and constructors, you can use the one of the following:
- **public** => The code is accessible for all classes
- **private** => The code is only accessible within the declared class
- **default** => The code is only accessible in the same package. This is used when you don't specify a modifier
- **protected** => The code is accessible in the same package and subclasses

### Non-Access Modifiers 

For classes, you can use either final or abstract:
- **final** => The class cannot be inherited by other classes
- **abstract** => The class cannot be used to create objects (To access an abstract class, it must be inherited from another class

For attributes and methods,
- **final** => Attributes and methods cannot be overridden/modified
- **static** => Attributes and methods belongs to the class, rather than an object
- **abstract** => Can only be used in an abstract class, and can only be used on methods. The method does not have a body, for example abstract void run();. The body is provided by the subclass (inherited from)
- **transient** => Attributes and methods are skipped when serializing the object containing them
- **syncrhonized** => Methods can only be accessed by one thread at a time
- **volatile** => The value of an attribute is not cached thread-locally, and is always read from the "main memory"

Example ```final```

If you don't want the ability to override existing attribute values, declare attributes as final:

```java
public class Main {
  final int x = 10;
  final double PI = 3.1416;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 50; // will generate an error: cannot assign a value to a final variable
    myObj.PI = 25; // will generate an error: cannot assign a value to a final variable
    System.out.println(myObj.x);
  }
}
```

Example ```static```
A static method means that it can be accessed without creating an object of the class, unlike public:


```java
public class Main {
  // Static method
  static void staticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void publicMethod() {
    System.out.println("Public methods must be called by creating objects");
  }

  // Main method
  public static void main(String[ ] args) {
    staticMethod(); // Call the static method
    // publicMethod(); This would output an error

    Main myObj = new Main(); // Create an object of Main
    myObj.publicMethod(); // Call the public method
  }
}
```
=======
>>>>>>> 69c260df89d8d1caa66a4f555b06961cca821835
