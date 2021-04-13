# Java 9 Anonymous Inner Classes Improvement

Java 9 introduced a new feature that allows us to use diamond operator with anonymous classes. Using the diamond with anonymous classes was not allowed in Java 7.

In Java 9, as long as the inferred type is denotable, we can use the diamond operator when we create an anonymous inner class.

Data types that can be written in Java program like int, String etc are called denotable types. Java 9 compiler is enough smart and now can infer type.

```This feature is included to Java 9, to add type inference in anonymous inner classes.```

## Java 9 Anonymous Inner Classes Example

```java
abstract class ABCD<T>{  
    abstract T show(T a, T b);  
}

public class TypeInferExample {  
    public static void main(String[] args) {  
        ABCD<String> a = new ABCD<>() { // diamond operator is empty, compiler infer type  
            String show(String a, String b) {  
                return a+b;   
            }  
        };    
        String result = a.show("Java","9");  
        System.out.println(result);  
    }  
}  

RESULT
Java9
```

Although we can specifying type in diamond operator explicitly and compiler does not produce any error message. See, the following example, type is specified explicitly.

