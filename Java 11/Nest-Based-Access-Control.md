# Nest-Based Access Control

Java 11 introduced nest-based access control that allows classes to access each other's private members without the need for bridge methods created by the compiler. These methods are called accessibility-broadening bridge methods and the compiler inserts these into the code during the program execution.

Before Java 11, if we have private members in our code then the compiler creates accessibility-broadening bridge methods that increase the size of the deployed applications and may lead to confusion. That's why Java improved nest-based access control.

Java 11 allows classes and interfaces to be nested within each other. These nested type can be private fields, methods, and constructors.

Basic Example:

In this example, we are calling a private method inside a nested class. If we execute this code using earlier versions of Java than Java 11, the compiler will create a bridge method to call the private method, but using Java 11 there is no need of a bridge method to call private members.

```java
public class Main {
	
	private void display() {
		System.out.println("hello from private method");
	}
	
	class NestedMain{
		void msg() {
			display();
		}
	}
	
	public static void main(String[] args){
		
		Main m = new Main();
		Main.NestedMain n = m.new NestedMain();
		n.msg();
		
	}   
}
RESULT:
hello from private method
```

This output snippet shows after executing javap -v Main command from the terminal and we get the following details of nest-members.

```java
public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=4, locals=3, args_size=1
         0: new           #5                  // class myjavaproject/Main
         3: dup
         4: invokespecial #6                  // Method "<init>":()V
         7: astore_1
         8: new           #7                  // class myjavaproject/Main$NestedMain
        11: dup
        12: aload_1
        13: dup
        14: invokestatic  #8                  // Method java/util/Objects.requireNonNull:(Ljava/lang/Object;)Ljava/lang/Object;
        17: pop
        18: invokespecial #9                  // Method myjavaproject/Main$NestedMain."<init>":(Lmyjavaproject/Main;)V
        21: astore_2
        22: aload_2
        23: invokevirtual #10                 // Method myjavaproject/Main$NestedMain.msg:()V
        26: return
      LineNumberTable:
        line 17: 0
        line 18: 8
        line 19: 22
        line 21: 26
}
SourceFile: "Main.java"
NestMembers:
  myjavaproject/Main$NestedMain
InnerClasses:
  #12= #7 of #5;                          // NestedMain=class myjavaproject/Main$NestedMain of class myjavaproject/Main
```

## Reflection API new Methods

Java added some new methods to Java Reflection API Class. We can use these methods to get information on nest-based access control.

```java
public Class<?> getNestHost()
public boolean isNestmateOf(Class<?> c)
public Class<?>[] getNestMembers()
```

The **getNestHost()** method is used to get the name of nest host while the isNestmateOf() method is used to check whether a class is a nestmate.

The **getNestMembers()** method returns an array of nest members including classes and interfaces.

## Example: Using getNestHost()

In Java, each class is a member of exactly one nest. We can use getNestHost() method to get the nest host of the nest.

```java
import java.util.Arrays;

public class Main {
	
	private void display() {
		System.out.println("hello from private method");
	}

	class NestedMain{
		void msg() {
			display();
		}
	}	
	public static void main(String[] args){
		
		Main m = new Main();
		Main.NestedMain n = m.new NestedMain();
		n.msg();
		// Get Nest Host Name
		System.out.println(Main.class.getNestHost());
		// Get Nest Members
		System.out.println(Arrays.toString(Main.class.getNestMembers()));
		// Check whether a class is nestmateg
		System.out.println(Main.class.isNestmateOf(NestedMain.class));
	}   
}
RESULT:
hello from private method
class myjavaproject.Main
[class myjavaproject.Main, class myjavaproject.Main$NestedMain]
true
```


