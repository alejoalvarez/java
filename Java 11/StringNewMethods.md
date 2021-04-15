# Java 11 added new methods to the String class for better string handling. These methods are:

- isBlank()
- lines()
- strip()
- stripLeading()
- stripTrailing()
- repeat()

We will discuss each method with the help of examples.

## Java String isBlank() Method

This method is used to check whether the string is blank or not. It returns true if the string is empty or contains only white space codepoints, otherwise false. The syntax of the method is given below:

```java
public boolean isBlank()
```

Basic Example:

In this example, we have two string values, one is non-blank and the other one is blank to check using the isBlank() method.

```java
public class Main {  
	public static void main(String[] args){
		String str = "AlejoExample";
		boolean r = str.isBlank();
		System.out.println(r);
		str = "";
		r = str.isBlank();
		System.out.println(r);	
	}        
}
RESULT:
false
true
```

## Java String lines() Method

This method is used to get a stream of lines extracted from the string, separated by line terminators. The syntax of the method is given below:

```java
public Stream<String> lines()
```

Basic Example:

In this example, we are getting a stream of the string by using lines() method. The string is broken at termination points like "\n", "\r".

```java
import java.util.stream.Stream;

public class Main {  
	public static void main(String[] args){
		String str = "Example \n String \r line \n Java 11"; 
		 
        Stream<String> lines = str.lines();

        lines.forEach(System.out::println);	
	}        
}
RESULT:
Example
String 
line
Java 11
```

## Java String strip() Method

This method is used to remove all the leading and trailing spaces from a string. If you want to remove only leading spaces then use the stripLeading() method and for trailing, spaces use the stripTrailing() method. The syntax of these methods are given below.

```java
public String strip()
public String stripLeading()
public String stripTrailing()
```

Basic Example:
In this example, we are using strip() method to remove all leading and trailing methods of a string.

```java
public class Main {  
	public static void main(String[] args){
		String str = "      Example strip "; 
		System.out.println(str);
        String str2 = str.strip();
        System.out.println(str2);
		
	}        
}
RESULT:
Example strip
Example strip
```

In this example, we are using the stripLeading() method to remove all the leading spaces from a string.

```java
public class Main {  
	public static void main(String[] args){
		String str = "      Example stripLeading"; 
		System.out.println(str);
        String str2 = str.stripLeading();
        System.out.println(str2);
		
	}        
}
RESULT:
Example stripLeading
Example stripLeading
```

In this example, we are using the stripTrailing() method to remove all the trailing spaces from a string.

```java
public class Main {  
	public static void main(String[] args){
		String str = "    Example stripTrailing   "; 
		System.out.println(str);
		System.out.println(str.length());
        String str2 = str.stripTrailing();
        System.out.println(str2);
        System.out.println(str2.length());
		
	}        
}
RESULT:
Example stripTrailing
28
Example stripTrailing
21
```

## Java String repeat() Method

This method is used to repeat a string at the specified time. It returns a string whose value is the concatenation of this string repeated specified times.

```java
public String repeat(int count)
```

Basic Example:

In this example, we are using the repeat() method to repeat the string multiple times:

```java
public class Main {  
	public static void main(String[] args){
		String str = "#"; 
		System.out.println(str);
		String str2 = str.repeat(3);
		System.out.println(str2);
		str = "test";
		System.out.println(str);
		str2 = str.repeat(5);
		System.out.println(str2);
	}        
}

#
###
test
testtesttesttesttest
```
