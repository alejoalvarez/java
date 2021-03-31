## Variables

Variables are containers for storing data values. A variable is assigned with a data type.
Variable is a name of memory location. There are three types of variables in java: local, instance and static.
They are memory spaces used for our programs

**Variable** is name of reserved area allocated in memory. In other words, it is a name of memory location. It is a combination of "vary + able" that means its value can be changed.

Type of variables:
- local variable
- instance variable
- static variable


## Local Variable
A variable declared inside the body of the method is called local variable. You can use this variable only within that method and the other methods in the class aren't even aware that the variable exists.

A local variable cannot be defined with "static" keyword.


## Instance Variable
A variable declared inside the class but outside the body of the method, is called instance variable. It is not declared as static.

It is called instance variable because its value is instance specific and is not shared among instances

## Static variable
A variable which is declared as static is called static variable. It cannot be local. You can create a single copy of static variable and share among all the instances of the class. Memory allocation for static variable happens only once when the class is loaded in the memory.

Example
```java
class Main{  
    int number=500;//instance variable  
    static int number1=100;//static variable  
    void method(){  
    int number3=900;//local variable  
    }  
}
```

Data type:
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