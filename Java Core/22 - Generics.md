# Generics

* Beginning with Java 5, generics have been added to provide compile-time type checking and eliminate the risk of **ClassCastException** that was common when working with collection classes.

* Diamonds are used `< >`

It has mainly two functionalities

- Provides type safety (When I put generics I am doing type safety ie u)
- Avoid casting

`T` is a letter of a stereotype
```java
Person <T> public class example
```

The most common type parameter names are:
* `E` -> Element (widely used by the Java collections framework)
* `K` -> key
* `N` -> Number
* `T` -> Type
* `V` -> Value
* `S`, `U`, `V`, etc. –2nd, 3rd, 4th types

If before it was declared in a GenericsMethodClass class

```java
public class GenericMethodClass {
    public <T> void printElement(T element){
        System.out.println(element);
    }
}
```

we can invoke

```java
GenericMethodClass genericMethodClass = new GenericMethodClass();
genericMethodClass.<String>printElement("Hello");
genericMethodClass.<String>printElement(5);
```

But the compiler is smart enough to know that if we pass it a String, we don't have to repeat it, so we can just tell it:

```java
GenericMethodClass genericMethodClass = new GenericMethodClass();
genericMethodClass.printElement("Hello");
genericMethodClass.printElement(5);
```

## Diamond operator

It is an improvement in the inference of types in generics, letting the compiler be the one who determines the type of the generic class and not the programmer, providing savings in effort and time, and as many of us know it does not bring much value to have duplicates on the left and right the guys

With Java 6
```java
List<String> java6List = new ArrayList<String>();
```

With Java 7
```java
List<String> java7List = new ArrayList<>();
```

In this way the compiler knows that Java7List is going to be of type String as it is declared on the left. The two examples do the same

## Declaration of generic classes

- We can not only use generic classes like List, Map, Set, etc. We can create our own classes
- The following example declares a generic class that is of type U, containing a list of type U and with a constructor of type T

```java
import java.util.ArrayList;
import java.util.List;

public class GenericClass <U>{
    List<U> list = new ArrayList<U>;

    <T> GenericClass (T t) throws NoSuchFieldException{
        System.out.println("T " + t.getClass().getSimpleName);       
    }

    public void add(U element){
        list.add(element);
        System.out.println("U " + list.get(0).getClass().getSimpleName());       
    }
}
```

## What is Wildcard in Java?

- Wildcards in Java are basically the question marks which we use in generic programming, it basically represents the unknown type.
- We use Java Wildcard  widely in situations such as in a type of parameter, local variable, or field and also as a return type.
- Unlike arrays, different instantiations of a generic type are not compatible with each other, not even explicitly
- We can remove this incompatibility by using wildcard ‘?’ as an actual type parameter.

## Generics <?> (Generics wildcard)

It allows executing the generics without specifying the data type, that is, this data will be specified in runtime (runtime)

There are 3 types of wildcards in Java: 
- Upper bounded wildcards
- Lower Bounded Wildcards
- Unbounded Wildcards   

### Wildcard unbounded (use extends)

We use the Unbounded wildcards when we want to specify the type of wildcard with the wildcard character ?.  We generally use this wildcard when the code inside the method is using the Object functionality and also when the code inside the method does not depend upon the parameter type.

```java
public void list(List<?> list){
    for(Object a : list){
        if(a instanceof Student){
            System.out.println(((Student) a).getName());
        }else if (a instanceof Professor){
            System.out.println(((Professor) a).getName());
        }
    }
}

or

public void list(List<? extends Object> list){
    for(Object a : list){
        if(a instanceof Student){
            System.out.println(((Student) a).getName());
        }else if (a instanceof Professor){
            System.out.println(((Professor) a).getName());
        }
    }
}
```

Another Example :

```java
import java.util. * ;

public class UnboundedWildcard {
  public static void main(String[] args) {
    //Integer List
    List < Integer > intList = Arrays.asList(10, 20, 30, 40);

    //Double list
    List < Double > doubleList = Arrays.asList(11.5, 13.6, 67.8, 43.7);

    printList(intList);
    printList(doubleList);
  }
  private static void printList(List < ?>list) {
    System.out.println(list);
  }
}
```

Output
```
[10, 20, 30, 40]
[11.5, 13.6, 67.8, 43.7]
```

This means that ```?``` It will write any data that inherits from the Object class extends in generics refers to inheritance and implementation (that is, it serves for interfaces) Any type of Object is expected

### Wildcard upperBounded

The Upper Bounded wildcards are the wildcard that relaxes the restriction of the variable type. That is, if we want to relax the restriction on the type of the variable in the method, we can use this type of wildcards.

```java
public void listUpperBounded(List<? extends Person> list){
    for(Person per : list){
       System.out.println(per.getName());
    }
}
```

Any type of the indicated subclass is used, for the example any subclass of Person

Another example:

```java
public class UpperBoundWildcard {
  public static void main(String[] args) {
    //Upper Bounded Integer List
    List < Integer > intList = Arrays.asList(10, 20, 30, 40);

    //printing the sum of integer elements in list
    System.out.println("Total sum is:" + sum(intList));

    //Upper Bounded Double list
    List < Double > doubleList = Arrays.asList(13.2, 15.6, 9.7, 22.5);

    //printing the sum of double elements in list
    System.out.print("Total sum is: " + sum(doubleList));
  }
  private static double sum(List < ?extends Number > myList) {
    double sum = 0.0;
    for (Number iterator: myList) {
      sum = sum + iterator.doubleValue();
    }
    return sum;
  }
}
```

Output:
```
Total sum is: 100.0
Total sum is: 61.0
```

### Wildcard lowerBounded

We use the Lower Bounded wildcards to widen the use of the type of variable. For example, if we want to add the list of integers in our method we can use the List<Integer>, but using this we will be bound to use only the list of integers. So here, we can also use the List<Number> and List<Object> to store the list of integers. 

So we use the Lower Bounded wildcard to achieve this. We can use this by a wildcard character ? and put a super keyword after that followed by the lower bound.
Example: **<? super LowerBound>**

```java
public void listLowerBounded(List<? super Student> list){
    for(Object student : list){
       System.out.println(((Student )student).getName());
    }
}
```

We are only going to recognize those classes that are greater than the class that we are going to place in?, That's why super is used,

```java
import java.util. * ;
public class LowerBoundWildcard {
  public static void main(String[] args) {
    //Lower Bounded Integer List
    List < Integer > intList = Arrays.asList(10, 20, 30, 40);

    //Passing Integer list object
    printOnlyIntegerClassorSuperClass(intList);

    //Number list
    List < Number > numberList = Arrays.asList(10, 20, 30, 40);

    //Passing Integer list object
    printOnlyIntegerClassorSuperClass(numberList);
  }

  public static void printOnlyIntegerClassorSuperClass(List < ?super Integer > list) {
    System.out.println(list);
  }
}
```

Output
```
[10, 20, 30, 40]
[10, 20, 30, 40]
```

# Guidelines for Using Wildcard in Java

Below is the guideline for using each type of variable in the following cases:

- **Upper bound wildcard:** If the variable belongs to in type , i.e there is an in variable, we use the ‘extends’ keyword with a wildcard.
- **Lower bound wildcard:** If the variable belongs to out type , i.e there is an out variable, we use ‘super’ keyword with a wildcard.
- **Unbounded wildcard:** If we can access a variable using the Object class method, then we should prefer to use the unbounded wildcards.
- **No wildcard:** If the variable is both in and out category, then there is no need to use the wildcards.

# What is not allowed to do with Java Generics?

## a) You can’t have a static field of type

In your generic class, you can not define a static generic parameterized member. Any attempt to do so will generate a compile-time error. The error will be like: Cannot make a static reference to the non-static type T.

```java
public class GenericClass<T>{
        private static T member; //This is not allowed
}
```

## b) You can not create an instance of T

We can also not create an object of T. Any attempt to do so will fail with an error: Cannot instantiate the type T. For example,

```java
public class GenericClass<T>{
    public GenericClass(){    //Constructor created  
        new T();  //Not Allowed
    }
}
```

## c) We can’t use primitive data types with Generics declaration

We can’t declare generic expressions like List or Map <int, double>. But, we can use the ***wrapper classes*** in place of primitive data types and then use the primitives while passing the actual values. Auto-boxing converts these primitive types to their respective wrapper classes.

```java
final HashMap<int> id = new HashMap<>();    //Not allowed

final HashMap<Integer> id = new HasMap<>();  //Allowed
```

## d) You can’t create Generic exception class

We can’t pass an instance of generic type along with exception being thrown. This is not allowed in Java. For example, the following line causes an error.

```
// causes compiler error
public class GenericClass<T> extends Exception {}
```

When you try to do this, you will get an error message like this: The generic class GenericException may not subclass java.lang.Throwable.

Examples:

```java
public class GenericMethodDemo
{
  // defining generic method printArray
  public static <E> void printArray( E[] inputArray )
  {
    for(E element : inputArray){
      System.out.printf("%s ", element);
    }
    System.out.println();
  }

  public static void main(String args[])
  {
    Integer[] intArray = { 10, 20, 30, 40, 50 }; // Create arrays of Integer, Double and Character
    Double[] doubleArray = { 1.2, 2.5, 4.6, 7.8 };
    Character[] charArray = { 'A', 'l', 'e', 'j', 'o'};

    System.out.println("Array integerArray contains:");
    printArray(intArray); // pass an Integer array

    System.out.println("\nArray doubleArray contains:");
    printArray(doubleArray); // pass a Double array

    System.out.println("\nArray characterArray contains:");
    printArray(charArray); // pass a Character array
  }
}
```

Output 
```
Array integerArray contains:
10 20 30 40 50
Array doubleArray contains:
1.2 2.5 4.6 7.8
Array characterArray contains:
Alejo
```


