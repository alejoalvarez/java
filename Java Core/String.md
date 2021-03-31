# String

In Java, string is basically an object that represents sequence of char values. An array of characters works same as Java string. For example:

```java
char[] ch={'j','a','v','a'};  
String s=new String(ch);  
```

is the same:
```java
String s="java";  
```

Java String class provides a lot of methods to perform operations on strings such as compare(), concat(), equals(), split(), length(), replace(), compareTo(), intern(), substring() etc.

The java.lang.String class implements Serializable, Comparable and CharSequence interfaces.

<p align="center">
<img height="270" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/string-implements.png">
</p> 

CharSequence Interface

The CharSequence interface is used to represent the sequence of characters. String, StringBuffer and StringBuilder classes implement it. It means, we can create strings in java by using these three classes.

<p align="center">
<img height="270" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/charsequence.png">
</p> 

The Java String is immutable which means it cannot be changed. Whenever we change any string, a new instance is created. For mutable strings, you can use StringBuffer and StringBuilder classes.

We will discuss immutable string later. Let's first understand what is String in Java and how to create the String object.

## How to create a string object?

There are two ways to create String object:

By string literal
By new keyword


- String literal

Java String literal is created by using double quotes. For Example:

```java
String variable1 = "Say hello";
```

Each time you create a string literal, the JVM checks the "string constant pool" first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string doesn't exist in the pool, a new string instance is created and placed in the pool. For example:

```java
String s1="Say hello";  
String s2="Say hello"; //It doesn't create a new instance  
```

IMAGEN FOR STRING POOLS

In the above example, only one object will be created. Firstly, JVM will not find any string object with the value "Welcome" in string constant pool, that is why it will create a new object. After that it will find the string with the value "Welcome" in the pool, it will not create a new object but will return the reference to the same instance.

The concept of String literal allow To make Java more memory efficient (because no new objects are created if it exists already in the string constant pool).

- new Keyword

```java
String variable =new String("Say hello"); //creates two objects and one reference variable  
```

## Methods

The java.lang.String class provides many useful methods to perform operations on sequence of char values.

| Method | Description |
|---|---|
| char charAt(int index) |	returns char value for the particular index|
| int length() | returns string length|
| static String format(String format, Object... args) | returns a formatted string.|
| static String format(Locale l, String format, Object... args) | returns formatted string with given locale.|
| String substring(int beginIndex) | returns substring for given begin index.|
| String substring(int beginIndex, int endIndex) | returns substring for given begin index and end index.|
| boolean contains(CharSequence s) | returns true or false after matching the sequence of char value.|
| static String join(CharSequence delimiter, CharSequence... elements)	| returns a joined string.|
| static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) | returns a joined string.|
| boolean equals(Object another) | checks the equality of string with the given object.|
| boolean isEmpty()	| checks if string is empty.|
| String concat(String str)	| concatenates the specified string.|
| String replace(char old, char new) | replaces all occurrences of the specified char value.|
| String replace(CharSequence old, CharSequence new) | replaces all occurrences of the specified CharSequence.|
| static String equalsIgnoreCase(String another) | compares another string. It doesn't check case.|
| String[] split(String regex)	| returns a split string matching regex.|
| String[] split(String regex, int limit)	| returns a split string matching regex and limit.|
| String intern()	| returns an interned string.|
| int indexOf(int ch)	| returns the specified char value index.|
| int indexOf(int ch, int fromIndex)	| returns the specified char value index starting with given index.|
| int indexOf(String substring)	| returns the specified substring index.|
| int indexOf(String substring, int fromIndex)	| returns the specified substring index starting with given index.|
| String toLowerCase()	| returns a string in lowercase.|
| String toLowerCase(Locale l)	| returns a string in lowercase using specified locale.|
| String toUpperCase()	| returns a string in uppercase.|
| String toUpperCase(Locale l)	| returns a string in uppercase using specified locale.|
| String trim() | removes beginning and ending spaces of this string.|
| static String valueOf(int value) | converts given type into string. It is an overloaded method.|