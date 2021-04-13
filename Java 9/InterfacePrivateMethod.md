# Interface Private Methods

In Java 9, we can create private methods inside an interface. Interface allows us to declare private methods that help to share common code between non-abstract methods.

Before Java 9, creating private methods inside an interface cause a compile time error. The following example is compiled using Java 8 compiler and throws a compile time error.

```java
interface Sayable{  
    default void say() {  
        saySomething();  
    }  
    // Private method inside interface  
    private void saySomething() {  
        System.out.println("Hello... I'm private method");  
    }  
}  
public class PrivateInterface implements Sayable {  
    public static void main(String[] args) {  
        Sayable s = new PrivateInterface();  
        s.say();  
    }  
}  
```

## Java 9 Private Static Methods Example

```java
interface Sayable{  
    default void say() {  
        saySomething(); // Calling private method  
        sayPolitely(); //  Calling private static method  
    }  
    // Private method inside interface  
    private void saySomething() {  
        System.out.println("Hello... I'm private method");  
    }  
    // Private static method inside interface  
    private static void sayPolitely() {  
        System.out.println("I'm private static method");  
    }  
}  
public class PrivateInterface implements Sayable {  
    public static void main(String[] args) {  
        Sayable s = new PrivateInterface();  
        s.say();  
    }  
}

RESULT
Hello... I'm private method
I'm private static method
```



