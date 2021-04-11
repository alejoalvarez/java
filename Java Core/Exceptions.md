# Exeptions

The Exception Handling in Java is one of the powerful mechanism to handle the runtime errors so that normal flow of the application can be maintained.

In Java, an exception is an event that disrupts the normal flow of the program. It is an object which is thrown at runtime.

There are two types of exceptions :
- **checked exception**
- **unchecked exception** 


## What is Java Exception?
Exception, in general, refers to some contradiction or unexpected situation, or in short, an unexpected error that occurs during program execution. There may be some cases during program development, where the programmer is not sure that this code-fragment is going to work correctly or not.

The reason for this is that sometimes the resources are not available or sometimes the range of an array is invalid. These types of anomalous situations are called exceptions and the way to handle them is called exception handling.

The unexpected errors or bugs during the runtime or normal execution of a program is a Java Exception.

This exception causes disruption in the execution of the program.

**Examples of Java Exception**

Some common examples of Exceptions in Java are:

- Divide by zero errors
- Trying to access the array elements with an invalid index
- Invalid input data by the user
- Hard disk crash
- Opening a file that does not exist
- Heap memory exhausted
- Network connection loss in the middle of a communication
- JVM has run out of memory.


## Difference between Checked and Unchecked Exceptions**

**Checked Exception**
The classes which directly inherit Throwable class except RuntimeException and Error are known as checked exceptions e.g. IOException, SQLException etc. Checked exceptions are checked at compile-time.

**Unchecked Exception**
The classes which inherit RuntimeException are known as unchecked exceptions e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc. Unchecked exceptions are not checked at compile-time, but they are checked at runtime.

**Error**
Error is irrecoverable e.g. OutOfMemoryError, VirtualMachineError, AssertionError etc.

**Checked** – Extends ```java.lang.Exception```, for recoverable condition, try-catch the exception explicitly, compile error.
**Unchecked** – Extends ```java.lang.RuntimeException```, for unrecoverable condition, like programming errors, no need try-catch, runtime error.


## Java Exception Methods

The Following list shows some important methods available in the Throwable class.

|Method |	Description|
|---|---|
|public String getMessage()	| It returns a detailed description of the occurred exception. |
|public Throwable getCause() |	Returns the cause of the occurred exception.|
|public String toString()	| Returns the result of the getMessage() method.|
|public void printStackTrace()	| Prints the result of the toString() method with the stack trace.|
|public StackTraceElement [] getStackTrace()	| Returns an array containing each element of the stack trace. |

**Hierarchy Exceptions**

<p align="center">
<img height="300" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/hierarchyException.jpeg">
</p>

| keyword | Description |
|---|---|
|try | is used to specify a block where we should place exception code. The try block must be followed by either catch or finally. It means, we can't use try block alone. |
| catch |  is used to handle the exception. It must be preceded by try block which means we can't use catch block alone. It can be followed by finally block later. |
| finally |  is used to execute the important code of the program. It is executed whether an exception is handled or not. | 
| throw |  is used to throw an exception. |
| throws | is used to declare exceptions. It doesn't throw an exception. It specifies that there may occur an exception in the method. It is always used with method signature. |

Java allows us to control exceptions so that our program does not stop unexpectedly and even if an exception occurs, our program continues its execution. For this we have the structure "try - cath - finally" that we show below:


## Try block

is used to enclose the code that might throw an exception. It must be used within the method.

If an exception occurs at the particular statement of try block, the rest of the block code will not execute. So, it is recommended not to keeping the code in try block that will not throw an exception.

Java try block must be followed by either catch or finally block.

Examples

```java
try{    
//code that may throw an exception    
}catch(Exception_class_Name ref){
    // code here
}  
```

```java
try{    
//code that may throw an exception    
}finally{
    // code here
}  
```

## catch block

is used to handle the Exception by declaring the type of exception within the parameter. The declared exception must be the parent class exception ( i.e., Exception) or the generated exception type. However, the good approach is to declare the generated type of exception.

The catch block must be used after the try block only. You can use multiple catch block with a single try block.

**Multi-catch block**

A try block can be followed by one or more catch blocks. Each catch block must contain a different exception handler. So, if you have to perform different tasks at the occurrence of different exceptions, use java multi-catch block.

All catch blocks must be ordered from most specific to most general, i.e. catch for ArithmeticException must come before catch for Exception.

```All catch blocks must be ordered from most specific to most general, i.e. catch for ArithmeticException must come before catch for Exception.```

example
```java
public class Main {  
  
    public static void main(String[] args) {  
          
           try{    
                int a[]=new int[5];    
                a[5]=30/0;    
               }    
               catch(ArithmeticException e)  
                  {  
                   System.out.println("Arithmetic Exception occurs");  
                  }    
               catch(ArrayIndexOutOfBoundsException e)  
                  {  
                   System.out.println("ArrayIndexOutOfBounds Exception occurs");  
                  }    
               catch(Exception e)  
                  {  
                   System.out.println("Parent Exception occurs");  
                  }             
               System.out.println("rest of the code");    
    }  
}  
```

## finally block

is a block that is used to execute important code such as closing connection, stream etc.

Java finally block is always executed whether exception is handled or not.

Java finally block follows try or catch block

```If you don't handle exception, before terminating the program, JVM executes finally block(if any).```

***Why use java finally**

Finally block in java can be used to put "cleanup" code such as closing a file, closing connection etc.

```java
public class Main{  
  public static void main(String args[]){  
    try{  
        int data=55/0;  
        System.out.println(data);  
    } catch(ArithmeticException e){
        System.out.println(e);
    } finally{
        System.out.println("finally block is always executed");    
    }  
    
    System.out.println("rest of code");  
  }  
} 

//RESULT 
Exception in thread main java.lang.ArithmeticException:/ by zero
finally block is always executed
rest of code
```

## throw 

is used to explicitly throw an exception.

We can throw either checked or uncheked exception in java by throw keyword. The throw keyword is mainly used to throw custom exception. We will see custom exceptions later.

Example 

```java
public class Main {
  static void checkAge(int age) {
    if (age < 18) {
      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }
public static void main(String[] args) {
    checkAge(15); // Set age to 15 (which is below 18...)
  }
}

// RESULT 
Exception in thread main java.lang.ArithmeticException: Access denied - You must be at least 18 years old.
```

### Exception propagation

An exception is first thrown from the top of the stack and if it is not caught, it drops down the call stack to the previous method,If not caught there, the exception again drops down to the previous method, and so on until they are caught or until they reach the very bottom of the call stack.This is called exception propagation.

```By default Unchecked Exceptions are forwarded in calling chain (propagated).```

```java
class Main{  
  void method1(){  
    int data=10/0;  
  }

  void method2(){  
    method1();  
  }
    
  void method3(){  
   try{  
        method2();  
   }catch(Exception e){
       System.out.println("exception handled");
    }  
  }  
  public static void main(String args[]){  
   Main obj=new Main();  
   obj.method3();  
   System.out.println("continue flow");  
  }  
}

// RESULT 
exception handled
continue flow
```

In the above example exception occurs in **method1()** method where it is not handled,so it is propagated to previous **method2()** method where it is not handled, again it is propagated to **method3()** method where exception is handled.

Exception can be handled in any method in call stack either in **main()** method, **method3()** method, **method2()** method or **method1()** method.

```default, Checked Exceptions are not forwarded in calling chain (propagated).```

```java
class Main{  
  void method1(){  
    throw new java.io.IOException("any error"); //checked exception  
  }

  void method2(){  
    method1();  
  }
    
  void method3(){  
   try{  
        method2();  
   }catch(Exception e){
       System.out.println("exception handled");
    }  
  }  
  public static void main(String args[]){  
   Main obj=new Main();  
   obj.method3();  
   System.out.println("continue flow");  
  }  
}

// RESULT 
Compile Time Error
```

## throws

is used to declare an exception. It gives an information to the programmer that there may occur an exception so it is better for the programmer to provide the exception handling code so that normal flow can be maintained.

Exception Handling is mainly used to handle the checked exceptions. If there occurs any unchecked exception such as NullPointerException, it is programmers fault that he is not performing check up before the code being used.

**Which exception should be declared**
Answer => checked exception only, because:

- unchecked Exception: under your control so correct your code.
- error: beyond your control e.g. you are unable to do anything if there occurs VirtualMachineError or StackOverflowError.

**Advantages**

Now Checked Exception can be propagated (forwarded in call stack).

It provides information to the caller of the method about the exception.


```java
class Main{  
  void method1() throws IOException {  
    throw new java.io.IOException("any error"); //checked exception  
  }

  void method2() throws IOException {  
    method1();  
  }
    
  void method3(){  
   try{  
        method2();  
   }catch(Exception e){
       System.out.println("exception handled");
    }  
  }  
  public static void main(String args[]){  
   Main obj=new Main();  
   obj.method3();  
   System.out.println("continue flow");  
  }  
}

// RESULT 
exception handled
contiue flow
```

```If you are calling a method that declares an exception, you must either caught or declare the exception.```

There are two cases:
- You caught the exception i.e. handle the exception using try/catch.
- You declare the exception i.e. specifying throws with the method.

### handle the exception
In case you handle the exception, the code will be executed fine whether exception occurs during the program or not.

```java
import java.io.*;  

class Example{
 void method() throws IOException{  
  throw new IOException("any error");  
 }  
}

public class Main{  
   public static void main(String args[]){  
    try{  
        Example obj = new Example();  
        obj.method();  
    }catch(Exception e){
        System.out.println("exception handled");
    }     
  
    System.out.println("continue flow");  
  }  
}  

//RESULT 
exception handled
continue flow   
```

### declare the exception

- In case you declare the exception, if exception does not occur, the code will be executed fine.
- In case you declare the exception if exception occures, an exception will be thrown at runtime because throws does not handle the exception.

**Program if exception does not occur**

```java
import java.io.*;  

class Example{  
 void method() throws IOException{  
  System.out.println("operation executed");  
 }  
}  
class Main{  
   public static void main(String args[])throws IOException{ //declare exception  
     Example obj = new Example();  
     obj.method();  
  
    System.out.println("continue flow");  
  }  
}  

// RESULT
operation executed
continue flow
```

**Program if exception occurs**

```java
import java.io.*;  

class Example {  
 void method()throws IOException{  
  throw new IOException("any error");  
 }  
}  
class Main{  
   public static void main(String args[]) throws IOException{//declare exception  
     Example obj = new Example();  
     obj.method();  
  
    System.out.println("continue flow");   
  }  
}

//RESULT
Runtime Exception
```

## Difference between throw and throws in Java

| throw	| throws |
| Java throw keyword is used to explicitly throw an exception.	| Java throws keyword is used to declare an exception.|
| Checked exception cannot be propagated using throw only.	| Checked exception can be propagated with throws.|
| Throw is followed by an instance.	| Throws is followed by class.|
| Throw is used within the method.	| Throws is used with the method signature.|
| You cannot throw multiple exceptions.	| You can declare multiple exceptions e.g.
 public void method()throws  IOException,SQLException. 

## ExceptionHandling with MethodOverriding


There are many rules if we talk about methodoverriding with exception handling. The Rules are as follows:

- If the superclass method does not declare an exception
    - If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.
- If the superclass method declares an exception
    - If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.

**If the superclass method does not declare an exception**


```If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception.```

```java
import java.io.*;  

class Parent{  
    void msg(){
        System.out.println("parent");
    }  
}  
  
class Main extends Parent{ 

  void msg()throws IOException{  
    System.out.println("child exception");  
  }  
  public static void main(String args[]){  
   Parent parent=new Main();  
   parent.msg();  
  }  
}  

// RESULT
Compile Time Error
```

```If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but can declare unchecked exception.```

```java
import java.io.*;  

class Parent{  
    void msg(){
        System.out.println("parent");
    }  
}  
  
class Main extends Parent{  
  void msg()throws ArithmeticException{  
    System.out.println("child exception");  
  }  
  public static void main(String args[]){  
   Parent obj = new Main();  
   obj.msg();  
  }  
} 

// RESULT
child exception
```

***If the superclass method declares an exception**

```If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.```

Example: subclass overridden method declares parent exception

```java
import java.io.*;  

class Parent{  
    void msg()throws ArithmeticException{
        System.out.println("parent");
    }  
}  
  
class Main extends Parent{  
  void msg()throws Exception{System.out.println("child exception");}  
  
  public static void main(String args[]){  
    Parent obj = new Main();  
    try{  
        obj.msg();  
    }catch(Exception e){
        // code here
    }  
  }  
} 

//RESULT
Compile Time Error
```

Example: subclass overridden method declares same exception

```java
import java.io.*;  

class Parent{  
    void msg()throws Exception{
      System.out.println("parent");
    }  
}  
  
class Main extends Parent{  
  void msg()throws Exception{System.out.println("child exception");}  
  
  public static void main(String args[]){  
   Parent obj = new Main();  
   try{  
        obj.msg();  
   } catch(Exception e){

   }  
  }  
}

// RESULT
child exception
```

Example: subclass overridden method declares subclass exception

```java
import java.io.*;  
class Parent{  
    void msg()throws Exception{
      System.out.println("parent");
    }  
}  
  
class Main extends Parent{  
  void msg()throws ArithmeticException{System.out.println("child exception");}  
  
  public static void main(String args[]){  
   Parent obj = new Main();  
   try{  
        obj.msg();  
   }catch(Exception e){

   }  
  }  
} 

//RESULT
child exception
```

Example: subclass overridden method declares no exception

```java
import java.io.*;  

class Parent{  
    void msg()throws Exception{
          System.out.println("parent");
    }  
}  
  
class Main extends Parent{  
  void msg(){System.out.println("child exception ");}  
  
  public static void main(String args[]){  
   Parent obj = new Main();  
   try{  
        obj.msg();  
   }catch(Exception e){

   }  
  }  
}  

// RESULT
child exception
```

## Custom Exception

If you are creating your own Exception that is known as custom exception or user-defined exception. Java custom exceptions are used to customize the exception according to user need.

By the help of custom exception, you can have your own exception and message.

Let's see a simple example of java custom exception.

Example 

```java
class InvalidAgeException extends Exception{  
 InvalidAgeException(String s){  
  super(s);  
 }  
}  

class Main{  
  
   static void validate(int age)throws InvalidAgeException{  
     if(age<18)  
      throw new InvalidAgeException("cannot vote");  
     else  
      System.out.println("can vote");  
   }  
     
   public static void main(String args[]){  
      try{  
      validate(17);  
      }catch(Exception ex){
        System.out.println("Exception occured: " + ex);
    }  
  
      System.out.println("continue code");  
  }  
}  
//RESULT
Exception occured: InvalidAgeException: cannot vote
continue code
```

## Custom Checked Exception

Some popular checked exception : IOException, FileNotFoundException

If the client is able to recover from the exception, make it a checked exception. To create a custom checked exception, extends java.lang.Exception

```java
public class NameNotFoundException extends Exception {

    public NameNotFoundException(String message) {
        super(message);
    }
}
```

For checked exception, you need to try and catch the exception.

```java
import com.mkyong.examples.exception.NameNotFoundException;

public class CustomerService {

    public Customer findByName(String name) throws NameNotFoundException {

        if ("".equals(name)) {
            throw new NameNotFoundException("Name is empty!");
        }
        return new Customer(name);
    }

    public static void main(String[] args) {
        CustomerService obj = new CustomerService();

        try {
            Customer cus = obj.findByName("");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

## Custom unchecked Exception

Some popular unchecked exception : NullPointerException, IndexOutOfBoundsException, IllegalArgumentException

If the client cannot do anything to recover from the exception, make it an unchecked exception. To create a custom unchecked exception, extends java.lang.RuntimeException

```java
public class ListTooLargeException extends RuntimeException{

    public ListTooLargeException(String message) {
        super(message);
    }
}
```

For unchecked exception, try and catch the exception is optional.

```java
import com.co.alejo.examples.exception.ListTooLargeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerService {

    public void analyze(List<String> data) {

        if (data.size() > 50) {
            //runtime exception
            throw new ListTooLargeException("List can't exceed 50 items!");
        }
        //...
    }

    public static void main(String[] args) {

        CustomerService obj = new CustomerService();

        //create 100 size
        List<String> data = new ArrayList<>(Collections.nCopies(100, "mkyong"));

        obj.analyze(data);
    }
}
```

In Java, runtime errors (when the program is running) are called exceptions, and this occurs when an error occurs in any of the instructions in our program, such as when dividing by zero, when a object is 'null' and cannot be, when a file is not opened correctly, etc. When an exception occurs, an error message is displayed on the screen and you can terminate the execution of the program or perform another process as defined in the code.

In Java (as in other programming languages), there are many types of exceptions and listing each of them would be almost an infinite task. With regard to exceptions, it must be said that they are learned through experience, from encountering them and knowing how to solve them.

An exception is an event that breaks the normal execution of a program (due to an error), when an event like this occurs an object of the Exception class is generated or "thrown" (throw)

There are several types of Exception derived classes depending on what happened.
- IOException
- IndexOutOfBoundsException
- UnknownHostException
- etc

When this happens, the JAVA interpreter looks for a suitable exception handler for this exception, which executes a piece of code (programmed by the user) that should react appropriately to this program failure. This is called "catching an exception" (catch).

When no handlers have been written to catch this exception, the program stops (crashes). The reason for introducing exceptions is that programming to react to faults is made easier (you don't have to anticipate all of them).

When an exception occurs in Java, an object of a certain class is created (depending on the type of error that has occurred), which will keep the information about the error produced and will provide us with the necessary methods to obtain said information. These classes have the Throwable class as their parent class, therefore a hierarchy is maintained in the exceptions.

## Comparison between Checked Exceptions and Java Unchecked Exception in Java
| Checked Exception	| Unchecked Exception|
|---|---|
| Checked exceptions occur at compile time.	| Unchecked exceptions occur at runtime.|
|	Also called Compile-time exceptions	| Also called Run-time exceptions|
| The compiler checks a checked exception.	| The compiler ignores the unchecked exceptions.|
| We can handle these types of exceptions during compilation.	| We cannot catch or handle these exceptions during the compilation because they are generated by the mistakes in the program.|
| The compiler will give an error if the code does not handle the checked exceptions.	| The compiler will never give an error if the code does not handle the unchecked exceptions.|
| They are the direct subclass of the Exception class.	| They are runtime exceptions and hence are not a part of the Exception class and are the subclass of RuntimeException class|
| JVM needs to catch and handle the checked exception.	| JVM needs not catch and handle the unchecked exception.|
| Checked Exceptions mainly occur when the chances of failure are too high.	| Unchecked Exceptions mainly occur due to programming mistakes.|
| We can create user-defined checked exceptions by extending java.Lang.Exception class	We can create user-defined Unchecked exceptions by extending RuntimeException class|
