# Exeptions

Tthere are two types of exceptions – **checked** and **unchecked** exception :

**Checked** – Extends ```java.lang.Exception```, for recoverable condition, try-catch the exception explicitly, compile error.
**Unchecked** – Extends ```java.lang.RuntimeException```, for unrecoverable condition, like programming errors, no need try-catch, runtime error.


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

When an exception occurs in Java, an object of a certain class is created (depending on the type of error that has occurred), which will keep the information about the error produced and will provide us with the necessary methods to obtain said information. These classes have the Throwable class as their parent class, therefore a hierarchy is maintained in the exceptions. Here are some of the classes to give us an idea of ​​the hierarchy that the exceptions follow, but there are many more exceptions than the ones we showed:


**Hierarchy Exceptions**

<p align="center">
<img height="300" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/hierarchyException.jpeg">
</p>


Java allows us to control exceptions so that our program does not stop unexpectedly and even if an exception occurs, our program continues its execution. For this we have the structure "try - cath - finally" that we show below:

### Try - catch - finally

Syntax:
```java
    try {
        // code block when there is not an exception
    } catch(TypeExcpetion ex) {
        // code block when exist an exception
    }finally{
        // code block that always it run.
}
```

Regarding the "try - catch - finally" structure, it must be said that the "try" block is executed first, if an exception occurs the "catch" block is executed and the "finally" block is executed last. In this structure, you can omit either the "catch" block or the "finally" block, but not both.

## Throw and Throws

To send the error that occurs in a method to the previous method or to whoever called the method that has the exception before.

Example 

Throw an exception if age is below 18 (print "Access denied"). If age is 18 or older, print "Access granted":

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
```






