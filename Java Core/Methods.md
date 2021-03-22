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

Example: 
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

## Modifiers

 Access modifier, meaning that it is used to set the access level for classes, attributes, methods and constructors

 We divide modifiers into two groups:

- Access Modifiers - controls the access level
- Non-Access Modifiers - do not control access level, but provides other functionality

### Access Modifiers

For classes, you can use either public or default:
- ```public``` => The class is accessible by any other class
- ```default``` => The class is only accessible by classes in the same package. This is used when you don't specify a modifier.

For attributes, methods and constructors, you can use the one of the following:
- ```public``` => The code is accessible for all classes
- ```private``` => The code is only accessible within the declared class
- ```default``` => The code is only accessible in the same package. This is used when you don't specify a modifier
- ```protected``` => The code is accessible in the same package and subclasses

<p align="center">
<img height="270" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/AccessModifiers.jpeg">
</p>

### Non-Access Modifiers 

For classes, you can use either final or abstract:
- ```final``` => The class cannot be inherited by other classes
- ```abstract``` => The class cannot be used to create objects (To access an abstract class, it must be inherited from another class

For attributes and methods,
- ```final``` => Attributes and methods cannot be overridden/modified
- ```static``` => Attributes and methods belongs to the class, rather than an object
- ```abstract``` => Can only be used in an abstract class, and can only be used on methods. The method does not have a body, for example abstract void run();. The body is provided by the subclass (inherited from)
- ```transient``` => Attributes and methods are skipped when serializing the object containing them
- ```syncrhonized``` => Methods can only be accessed by one thread at a time
- ```volatile``` => The value of an attribute is not cached thread-locally, and is always read from the "main memory"

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

**Instance method:**

It is the one that is invoked on an instance

```java
Person p1 = new Person();
p1.getName(); // to invoke it you need to create an object of the class
```

**Class method (static)**

It is the one that can be invoked without existing an instance

```java
public static String getName(){}
nameClass.nameMethod(){...}

```
- When a class is defined with static, the attributes no longer belong to the object, it belongs to the class, this means that if we make a modification to the value of this attribute, all the objects that are using this attribute will be modified
- Another perculiarity of a static attribute is that it does not need to be an instance, it can be called only by referencing the name of the class

Static helps save memory as the class is invoked directly and no additional object creation is required
