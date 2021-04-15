# Var in lambda expression

The var is a keyword in Java that is used to declare a local variable. It was introduced in Java 10 to improve type inference in Java.

In Java 11, we can use var with lambda expression parameters to avoid using the type name with the variable name. In earlier versions of Java, while working with the lambda expression, the var keyword was not allowed but now we can use that.

Let's understand it by an example. Before Java 11, the lambda expression may or may not have a variable type. It means, we can use type (int, float, etc), with the variable and may skip as well.

Example:

This is a simple example where we have a lambda expression with two parameters and no type(type skipped) is mentioned there. It means, the compiler infers the type of parameters.

```java
interface Calulate{
	int sum(int a, int b);
}

public class Main {  
	public static void main(String[] args){
		
		 Calulate cal = (a, b)-> a+b;		
		 int result = cal.sum(10, 20);
		 System.out.println(result);
	}        
}
RESULT:
30
```

This example works fine with Java 8 and higher versions.

Example 2:
This is another example in which we have mentioned type (int) for the parameters. Both examples execute fine and produce the desired result.

```java
interface Calculate{
	int sum(int a, int b);
}

public class Main {  
	public static void main(String[] args){
		
		 Calculate cal = (int a, int b)-> a+b;		
		 int result = cal.sum(10, 20);
		 System.out.println(result);
	}        
}

30
```

## Example 3: With Java 11 var Keyword

In this example, we used var in lambda expression where we used int type in the previous example. This is allowed only into Java 11, if you execute this code earlier in version of java then the compiler reports an error. So, execute this code using Java 11 and the code will execute fine.

```java
interface Cal{
	int sum(int a, int b);
}

public class Main {  
	public static void main(String[] args){
		
		 Cal cal = (var a, var b)-> a+b;		
		 int result = cal.sum(10, 20);
		 System.out.println(result);
	}        
}
RESULT:
30
```

## Points To Remember:

While using var with lambda expression make sure you keep in mind the following scenario and rules.

```java
(var s1, s2) -> s1 + s2 //no skipping allowed
(var s1, String y) -> s1 + y //no mixing allowed

var s1 -> s1 //not allowed. Need parentheses if you use var in lambda.
```

- If there are multiple parameters then use var with all the parameters. No skipping allowed.
- If one parameter use var then other parameters must use var rather than other types like int, float, etc.
- Must use parenthesis () while using the var with the parameters.

