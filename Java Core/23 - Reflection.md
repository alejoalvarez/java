# Reflection

**Use of reflection:**
- Reflection in Java is to inspect and change the behavior of a program at runtime.
- With the help of this reflection API, you can inspect classes, constructors, modifiers, fields, methods, and interfaces at runtime. For Example, you can get the name of the class or you can get details of the private members of the class.
- whenever possible it is better to dispense with the use of reflection as it affects the performance of the program.

**Using Reflection API, we can implement the reflection on the following entities:**

- **Field**: The Field class has information that we use to declare a variable or a field like a datatype (int, double, String, etc.), access modifier (private, public, protected, etc.), name (identifier) and value.
- **Method**: The Method class can help us to extract information like access modifier of the method, method return type, method name, method parameter types, and exception types raised by the method.
- **Constructor**: Constructor class gives information about class constructor that includes constructor access modifier, constructor name, and parameter types.
- **Modifier**: Modifier class gives us information about a specific access modifier.

## The Reflection API is mainly used in:

- Reflection is mainly used in debugging tools, JUnit, and frameworks to inspect and change the behavior at runtime.
- Test Tools etc.
- It is used, when your application has third-party libraries and when you want to know about the classes and methods available.

What is Reflection for in Java?

The concept of Reflection simply means that the program has the ability to dynamically observe and modify its structure. Hence, its same code is reflected: we can choose a class that we have previously written in an IDE and after compiling, while the program is running, we can modify it.

Suppose we have this class:

```java
public class BaseClass {

	public String stringVariable = "Text";
	private int intVariable = 5;

	public String getStringVariable(String concat) {
		return stringVariable + concat;
	}

	private int getIntVariablet(int add) {
		return intVariable + add;
	}
}
```

The Java virtual machine creates a Class instance for each type of object that includes functions for examining object properties and type information, all at run time. The following image shows the process of creating a class and instantiating it (Some parts of the image are explained a little later):

Therefore, to access the information on variables and functions, we will have to obtain the Class of whatever we want (To obtain the Class it is necessary to put the <generic type>; it is usually enough to put “Class <?>”, Especially when we go through several objects of different classes. Although here there may be a security problem if we do not define the generic type correctly; to avoid security problems, we can tell you better to take the object that inherits from my class <? extends BaseClass>, this way we ensure that we cannot insert other things as they do not inherit from BaseClass). For this we will extract it from the object with the getClass () function:

```java
BaseClass objectBaseClass = new BaseClass();

Class<? extends BaseClass> objectClassWithInfoBaseClass = objetBaseClass.getClass();
```

Examples to encompass a class

```java
//Get the Class directly from an object
Class classOfText = "text".getClass();

Integer number = 5;
Class classOfNumber = number.getClass();

//For primitive types we have to use ".class" or with ".TYPE" (preferably use ".class")
Class classBooleanA = boolean.class;
Class classBooleanB = boolean.TYPE;

//We can also get a class from a fully-quailified name; that is, the name of the package where our class is, followed by the name of the class
Class c = Class.forName("com.package.BaseClass");
```
get information directly from the class

```java
//Get the class name
String nameClass = objectClassWithInfoBaseClass.getSimpleName();
```

This may seem a bit confusing: I have to use a Class object to access the information of my class that is on the other hand, it is too complicated ... Not at all complicated, a trick is to think that the Class object extracted from your class it's your own class without instantiating.

## Get variables

```java
// get public variable

Field stringVariables = objectClassWithInfoBaseClass.getField("oneStringVariable");

// get public or private variable
Field intVariable = objectClassWithInfoBaseClass.getDeclaredField("oneIntVariable");

// get array with all public variables for the class
Field[] allVariables1 = objectClassWithInfoBaseClass.getFields();

// get all variabes (public or private)
Field[] allVariables2 = objectClassWithInfoBaseClass.getDeclaredFields();
```

When we only obtain a variable of type Field with the name “hardcoded” (“hardcoded” means that any text in a String is written directly in the source code; for example we have written "oneStringVariable" passing it to getField ()); For the prevention of errors since it is possible that the variable whose name is "hardcoded", the IDE that we use will ask us to put try and catch.

examples
```java
Field stringVariables = null;
try {
	stringVariables = objectClassWithInfoBaseClass.getField("oneStringVariable");	
} catch (NoSuchFieldException | SecurityException e) {
	e.printStackTrace();
}
```

## get functions

```java
//If we want to get a public method. If it has parameters we can pass each of its types class in order after the name.
Method getStringMethod = objectClassWithInfoBaseClass.getMethod("getStringVariable", String.class);

//If we want to get a method, be it private or not. If it has parameters we can pass each of its types class in order after the name.
Method getIntMethod = objectClassWithInfoBaseClass.getDeclaredMethod("getIntVariable", int.class);

//If we want to obtain an array with all the public variables of our class
Method[] allMethods = objectClassWithInfoBaseClass.getMethods();

//If we want to get all the methods, regardless of whether they are private or not
Method[] allDeclaredMethods = objectClassWithInfoBaseClass.getDeclaredMethods();
```

As with the Fields, if we obtain it by “hardcoded” the texts, we will have to put the try and catch

In addition, these two ways to obtain an individual method, if it has parameters we can pass them after the name; You will have to put as many as you have (if you don't have any, you don't put anything). For example, if we had the function:

```java
public void getUnaVariableString(String a, int b, float c) {
	//Contenido…
}
```

```java
Method method = object.getMethod("variableName, String.class, int.class, float.class); 
```

## get constructor

```java
//You can use getConstructor () passing it an array with the Class input parameters that the constructor has, so that it returns the Constructor type object, normally it is not used and to reduce code we do not put examples (if you want to know more you have more information in the bibliography)

//If we want to obtain an array with all the public constructors of our class
Constructor[] allConstructor = objectClassWithInfoBaseClass.getConstructors();

//If we want to get all the methods, regardless of whether they are private or not
Constructor[] todosLosConstructores = objectClassWithInfoBaseClass.getDeclaredConstructors();
```

## Browse basic information

We obtain all the variables of the class "BaseClass" with:

```java
Field[] allDeclaredVariables = objectClassWithInfoBaseClass.getDeclaredFields();
```

Within the list "allDeclaredVariables" will be contained:

```java
public String stringVariable = "Text";
private int intVariable = 5; 
```

we can go through it with

```java
for (Field variable : allDeclaredVariables) {
	System.out.println(variable);
}
```

