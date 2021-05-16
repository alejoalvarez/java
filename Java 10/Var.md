# Local variables

Java added a new way to declare and initialize Java variables by using var keyword. It reduces the effort to specify the type during variable declaration. By using var, we don't need to use types such as int, float, etc. It automatically infers the type of the variable based on the assigned value. This feature is known as Local Variable Type Inference or LVTI in Java. Let's compare a new and older version approach.

```java
// Java 9 or older

int a = 10; 

// Java 10 or higher

var a = 10;
```

Note: It is required to initialize the variable during declaration otherwise the compiler can't infer the type and will generate an error.

```java
// Java 10 or higher

var a; // error: not allowed (must be initialized)
```

This feature is restricted to – local variables with initializers, indexes in the enhanced for-loop, and locals declared in a traditional for-loop. It would not be available for method formals, constructor formals, method return types, fields, catch formals or any other kind of variable declaration.

It can be used in the following context:
Local variables with initializers

Indexes in the enhanced for-loop

Locals declared in a traditional for-loop

## Example: Local Variable with Initializer

This example explains the use of var as a Local variable. Notice, we created two string variables, one is by using the String type and the second is by using the var. Both work fine in Java 10.

```java
public class Main
{
	public static void main(String args[])
	{  
		String s = "Example1";
		var s2 = "Example1";  
		System.out.println(s);  
		System.out.println(s2);
	}
}

Example1
Example1
```

## Example: Variable must be Initialized

This example explains that variable must be initialized when declared with var else the compiler will generate an error. See the example below.

```java
public class Main
{
	public static void main(String args[])
	{  
		String s = "Example1";
		var s2 ;
		System.out.println(s);  
		System.out.println(s2);
	}
}
RESULT
Error: Cannot use 'var' on variable without initializer
```

When using var, you must initialize the variable at the same place. You cannot put the declaration and initialization at different places. If you do not initialize the variable in place, then you will get a compilation error – Cannot use 'var' on the variable without the initializer.

```java
var str;

str = "Studytonight" // not valid : error
```

## Example Local Variable Inference in Collection

In this example, we used the var to create a list-type variable and see it works fine and holds the list elements.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {  
	public static void main(String[] args){
		
		List<Integer> list = new ArrayList<>();
		list = Arrays.asList(2,5,6,8,4,7);
		
		// using var
		
		var list2 = Arrays.asList(2,5,6,8,4,7);
		System.out.println(list2);
	}
}
RESULT
[2, 5, 6, 8, 4, 7]
```

## Example: Type Inference in For loop

Java allows to use var in for loop to create a local variable. Here, we used var to declare a val variable that holds the elements of List. See the example below.

```java
import java.util.Arrays;
public class Main {  
	public static void main(String[] args){
		var list = Arrays.asList(2,5,6,8,4,7);
		for (var val : list) {
			System.out.println(val);
		}
	}
}
RESULT
2
5
6
8
4
7

```

## It cannot be used in the following context:

While working with Local type inference, we must aware that it has restricted scope and can be used in limited scenarios. The following are the scenarios where Java does not allow to use of var.

- Not allowed as class fields
- Not allowed as a parameter
- Not allowed as catch formal
- Not allowed in the method return type
- Not allowed in method parameters

## Example: Where var can't be used
Let's have an example where we will not use the var:

```java
import java.util.Arrays;

public class Main {  
	static var price = 10; // Not allowed as instance variable
	public static void main(String[] args){
		var list = Arrays.asList(2,5,6,8,4,7);
		for (var val : list) {
			System.out.println(add(val, price)); // no return infered
		}
	}
	// Not allowed in return type
	static var add(int a, var b) // not allowed as parameter {
		return (a+b);
	}
}
```
