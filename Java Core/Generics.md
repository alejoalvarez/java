# Generics

Beginning with Java 5, generics have been added to provide compile-time type checking and eliminate the risk of ClassCastException that was common when working with collection classes.
• Diamonds are used <>

It has mainly two functionalities
• Provides type safety (When I put generics I am doing type safety ie u)
• Avoid casting

• T is a letter of a stereotype
Person <T> public class example
The most common type parameter names are:
• E -> Element (widely used by the Java collections framework)
• K -> key
• N -> Number
• T -> Type
• V -> Value
S, U, V, etc. –2nd, 3rd, 4th types

If before it was declared in a GenericsMethodClass class

```java[
public class GenericMethodClass {]
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

## Generics <?> (Generics wildcard or comodin card)

It allows executing the generics without specifying the data type, that is, this data will be specified in runtime (runtime)

### Wildcard unbounded (use extends)

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
```

or

```java
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

• This means that ? It will write any data that inherits from the Object class
• extends in generics refers to inheritance and implementation (that is, it serves for interfaces)
Any type of Object is expected

### Wildcard upperBounded

```java
public void listUpperBounded(List<? extends Person> list){
    for(Person per : list){
       System.out.println(per.getName());
    }
}
```

Any type of the indicated subclass is used, for the example any subclass of Person

### Wildcard lowerBounded

```java
public void listLowerBounded(List<? super Student> list){
    for(Object student : list){
       System.out.println(((Student )student).getName());
    }
}
```

We are only going to recognize those classes that are greater than the class that we are going to place in?, That's why super is used,

