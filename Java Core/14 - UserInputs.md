# User Input

The Scanner class is used to get user input, and it is found in the java.util package.
To use the Scanner class, create an object of the class and use any of the available methods found in the Scanner class documentation. In our example, we will use the nextLine() method, which is used to read Strings:

Example
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter username");
String userName = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + userName);  // Output user input
  }
}
```

## Input Types

In the example above, we used the ```nextLine()``` method, which is used to read Strings. To read other types, look at the table below:


| Method | Description |
|---|---|
| nextBoolean()| Reads a boolean value from the user|
| nextByte() | Reads a byte value from the user |
| nextDouble() | Reads a double value from the user |
| nextFloat() | Reads a float value from the user |
| nextInt() | Reads a int value from the user |
| nextLine() | Reads a String value from the user |
| nextLong() | Reads a long value from the user |
| nextShort() | Reads a short value from the user |

Examples:

```java
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter name, age");
    
    // String input
    String name = myObj.nextLine();
    
    // Numerical input
    int age = myObj.nextInt();
   
    // Output input by user
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
  }
}
```