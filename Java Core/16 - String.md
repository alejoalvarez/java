# String

In Java, string is basically an object that represents sequence of char values. An array of characters works same as Java string. For example:

```java
char[] ch = {'j', 'a', 'v', 'a'};  
String s = new String(ch);  
```

is the same:
```java
String s = "java";  
```

The ```java.lang.String``` class implements ```Serializable```, ```Comparable``` and ```CharSequence``` interfaces.

<p align="center">
<img height="270" src="https://user-images.githubusercontent.com/13514156/120518319-12557300-c397-11eb-9838-7a9ff8501101.png">
</p> 

## CharSequence Interface

Is used to represent the sequence of characters.
- String
- StringBuffer
- StringBuilder.

That classes implement CharSequence.

<p align="center">
<img height="270" src="https://user-images.githubusercontent.com/13514156/120518375-21d4bc00-c397-11eb-9a55-9c5033a437c0.png">
</p> 

The Java String is immutable which means it cannot be changed. Whenever we change any string, a new instance is created. For mutable strings, you can use StringBuffer and StringBuilder classes.

## How to create a string object?

There are two ways to create String object:

- By string literal
- By new keyword

### String literal

Java String literal is created by using double quotes. For Example:

```java
String variable1 = "Say hello";
```

Each time you create a string literal, the JVM checks the "string constant pool" first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string doesn't exist in the pool, a new string instance is created and placed in the pool. For example:

```java
String s1 = "Say hello";  
String s2 = "Say hello"; //It doesn't create a new instance  
```

In the above example, only one object will be created. Firstly,

The concept of String literal allow To make Java more memory efficient (because no new objects are created if it exists already in the string constant pool).

### new Keyword

```java
String variable = new String("Say hello"); //creates two objects and one reference variable  
```

## Immutable String 

In java, string objects are immutable. Immutable simply means unmodifiable or unchangeable.

Once string object is created its data or state can't be changed but a new string object is created.

```java
class Main{  

 public static void main(String args[]){  
   String s = "Test1";  
   s.concat(" Test2");// concat() method appends the string at the end  
   System.out.println(s);// will print Test1 because strings are immutable objects  
 }  
} 

```
Output
```Test1```

```java
class Main{  
 
 public static void main(String args[]){  
   String s = "Test1";  
   s = s.concat(" Test2");  
   System.out.println(s);  
 }  
}  

```
Output
```Test1 Test2```

## String compare

We can compare string in java on the basis of content and reference.

There are three ways to compare string in java:

- By equals() method
- By = = operator
- By compareTo() method

### String compare by equals() or equalsIgnoreCase() method

The String equals() method compares the original content of the string.

### String compare by == operator

The == operator compares references not values.

```java
class Main{

 public static void main(String args[]){  
   String s1 = "Alejo";  
   String s2 = "Alejo";  
   String s3 = new String("Alejo");  
   System.out.println(s1==s2);  //true (because both refer to same instance)  
   System.out.println(s1==s3);  //false(because s3 refers to instance created in nonpool)  
 }  
}
```

### String compare by compareTo() method

The String compareTo() method compares values lexicographically and returns an integer value that describes if first string is less than, equal to or greater than second string.

Suppose s1 and s2 are two string variables. If:

- s1 == s2 :0
- s1 > s2   :positive value
- s1 < s2   :negative value

## String Concatenation

In java, string concatenation forms a new string that is the combination of multiple strings. There are two ways to concat string in java:

By + (string concatenation) operator
By concat() method

### String Concatenation by + (string concatenation) operator

Java string concatenation operator (+) is used to add strings

```java
class Main{  
 public static void main(String args[]){  
   String s = "Alejo"+" Alvarez";  
   System.out.println(s);
 }  
}
```
Output
```Alejo Alvarez```

### String Concatenation by concat() method

The String concat() method concatenates the specified string to the end of current string.

```java
class Main{

 public static void main(String args[]){  
   String s1 = "Alejo ";  
   String s2 = "Alvarez";  
   String s3 = s1.concat(s2);  
   System.out.println(s3);
  }
}
```
Output ```Alejo Alvarez```

## Substring

A part of string is called substring

You can get substring from the given string object by one of the two methods:

- ```public String substring(int startIndex)```: This method returns new String object containing the substring of the given string from specified startIndex (inclusive).
- ```public String substring(int startIndex, int endIndex)```: This method returns new String object containing the substring of the given string from specified startIndex to endIndex.

```java
String s = "Alejo";  
System.out.println(s.substring(0,2));
```
Output
```Al```

# Methods

Let's see the important methods of String class.

### String toUpperCase() and toLowerCase() method

```java
String s = "Alejo";  
System.out.println(s.toUpperCase());
System.out.println(s.toLowerCase());
System.out.println(s);
```
Ouptut
```
ALEJO
alejo
Alejo
```

### String trim() method

The string trim() method eliminates white spaces before and after string.

```java
String s = "  Alejo  ";  
System.out.println(s);
System.out.println(s.trim());
```
Output
``` Alejo
Alejo
```

### String startsWith() and endsWith() method

```java
String s = "Alejo";  
System.out.println(s.startsWith("Al"));
System.out.println(s.endsWith("o"));
```
Output
```
true
true
```

### String charAt() method

The string charAt() method returns a character at specified index.

```java
String s = "Alejo";  
System.out.println(s.charAt(0));//A  
System.out.println(s.charAt(3));//j  
```
Output
```
A
j
```

### String length() method

The string length() method returns length of the string.

```java
String s = "Alejo";  
System.out.println(s.length());
```
Output
```4```

### String intern() method
A pool of strings, initially empty, is maintained privately by the class String.

When the ```intern``` method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object) method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String object is returned.

```java
String s = new String("Alejo");  
String s2 = s.intern();
System.out.println(s2);
```
Output
```
Alejo
```

### String valueOf() method

The string valueOf() method coverts given type such as int, long, float, double, boolean, char and char array into string.

```java
int a = 11;
String s = String.valueOf(a);
System.out.println(s + 11);
```
Output
```
1111
```

### String replace() method

The string replace() method replaces all occurrence of first sequence of character with second sequence of character.

```java
String s1 = "Java is the best programming language";
String replaceString = s1.replace("Java","Tava");
System.out.println(replaceString);
```
Output
```
Tava is the best programming language
```

### StringBuffer class
Java StringBuffer class is used to create mutable (modifiable) string. The StringBuffer class in java is same as String class except it is mutable i.e. it can be changed.

```Java StringBuffer class is thread-safe i.e. multiple threads cannot access it simultaneously. So it is safe and will result in an order.```

#### Constructors of StringBuffer class (most important)

- ```StringBuffer()```	creates an empty string buffer with the initial capacity of 16.
- ```StringBuffer(String str)``` creates a string buffer with the specified string.
- ```StringBuffer(int capacity)```	creates an empty string buffer with the specified capacity as length.

#### methods of StringBuffer class (importants)

| Modifier and Type	| Method |	Description|
|---|---|---
| public synchronized StringBuffer	append(String s)|  is used to append the specified string with this string. The append() method is overloaded like append(char), append(boolean), append(int), append(float), append(double) etc.|
| public synchronized StringBuffer	insert(int offset, String s)|	is used to insert the specified string with this string at the specified position. The insert() method is overloaded like insert(int, char), insert(int, boolean), insert(int, int), insert(int, float), insert(int, double) etc.|
| public synchronized StringBuffer	replace(int startIndex, int endIndex, String str)|	is used to replace the string from specified startIndex and endIndex.|
| public synchronized StringBuffer	delete(int startIndex, int endIndex) |	is used to delete the string from specified startIndex and endIndex.|
| public synchronized StringBuffer	reverse() |	is used to reverse the string.|
| public int	capacity() |	is used to return the current capacity.|
| public void	ensureCapacity(int minimumCapacity)	| is used to ensure the capacity at least equal to the given minimum.|
| public char	charAt(int index) |	is used to return the character at the specified position.|
| public int	length() |	is used to return the length of the string i.e. total number of characters.|
| public String	substring(int beginIndex)	| is used to return the substring from the specified beginIndex.|
| public String	substring(int beginIndex, int endIndex)	| is used to return the substring from the specified beginIndex and endIndex.|

**What is mutable string**
A string that can be modified or changed is known as mutable string. StringBuffer and StringBuilder classes are used for creating mutable string.

### StringBuffer append() method

The append() method concatenates the given argument with this string.

```java
class Main{  
    public static void main(String args[]){  

        StringBuffer sb = new StringBuffer("Hello ");  
        sb.append("World");
        System.out.println(sb);
    }  
} 
```
Output 
```Hello Word```

### StringBuffer insert() method

The insert() method inserts the given string with this string at the given position.

```java
class Main{  
    public static void main(String args[]){  
        StringBuffer sb = new StringBuffer("Hello ");  
        sb.insert(1,"World");
        System.out.println(sb);
    }  
} 
```
Output
```
HWorldello
```

### StringBuffer delete() method

The delete() method of StringBuffer class deletes the string from the specified beginIndex to endIndex.

```java
class Main{  
    public static void main(String args[]){  
        StringBuffer sb = new StringBuffer("Hello");  
        sb.delete(1,3);
        System.out.println(sb);
    }  
}
```
Output
```
Hlo
```

### StringBuffer reverse() method

The reverse() method of StringBuilder class reverses the current string.

```java
class Main{  
    public static void main(String args[]){  
        StringBuffer sb = new StringBuffer("Hello");  
        sb.reverse();
        System.out.println(sb);
    }  
}  
```
Output
```
olleH
```

### StringBuffer capacity() method

The capacity() method of StringBuffer class returns the current capacity of the buffer. The default capacity of the buffer is 16. If the number of character increases from its current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34.

```java
class Main{  
    public static void main(String args[]){  
        StringBuffer sb = new StringBuffer();  
        System.out.println(sb.capacity());//default 16  
        sb.append("Hello");  
        System.out.println(sb.capacity());//now 16  
        sb.append("java is my favorite language");  
        System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
    }  
}
```

### StringBuffer ensureCapacity() method

The ensureCapacity() method of StringBuffer class ensures that the given capacity is the minimum to the current capacity. If it is greater than the current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34.

```java
class Main{  
    public static void main(String args[]){  
        StringBuffer sb = new StringBuffer();  
        System.out.println(sb.capacity());//default 16  
        sb.append("Hello");  
        System.out.println(sb.capacity());//now 16  
        sb.append("java is my favourite language");  
        System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
        sb.ensureCapacity(10);//now no change  
        System.out.println(sb.capacity());//now 34  
        sb.ensureCapacity(50);//now (34*2)+2  
        System.out.println(sb.capacity());//now 70  
    }  
}  
```

## StringBuilder class

Java StringBuilder class is used to create mutable (modifiable) string. The Java StringBuilder class is same as StringBuffer class except that it is non-synchronized. It is available since JDK 1.5.

### Constructors of StringBuilder class (most important)

| Constructor	| Description|
|---|---|
| StringBuilder() |	creates an empty string Builder with the initial capacity of 16.|
|StringBuilder(String str) |	creates a string Builder with the specified string.|
|StringBuilder(int length) |	creates an empty string Builder with the specified capacity as length.|


### methods of StringBuilder class

| Method	| Description|
|---|---|
| public StringBuilder append(String s)	| is used to append the specified string with this string. The append() method is overloaded like append(char), append(boolean), append(int), append(float), append(double) etc.|
| public StringBuilder insert(int offset, String s) |	is used to insert the specified string with this string at the specified position. The insert() method is overloaded like insert(int, char), insert(int, boolean), insert(int, int), insert(int, float), insert(int, double) etc.|
| public StringBuilder replace(int startIndex, int endIndex, String str)	| is used to replace the string from specified startIndex and endIndex.|
| public StringBuilder delete(int startIndex, int endIndex)	| is used to delete the string from specified startIndex and endIndex.|
| public StringBuilder reverse()	| is used to reverse the string.|
| public int capacity()	 | is used to return the current capacity.|
| public void ensureCapacity(int minimumCapacity)	| is used to ensure the capacity at least equal to the given minimum.|
| public char charAt(int index)	| is used to return the character at the specified position.|
| public int length()	| is used to return the length of the string i.e. total number of characters.|
| public String substring(int beginIndex)	| is used to return the substring from the specified beginIndex.|
| public String substring(int beginIndex, int endIndex)	| is used to return the substring from the specified beginIndex and endIndex.|


### StringBuilder append() method
The StringBuilder append() method concatenates the given argument with this string.

```java
class Main{  
    public static void main(String args[]){  
        StringBuilder sb = new StringBuilder("Hello ");  
        sb.append("World");
        System.out.println(sb);
    }  
}  
```
Output
```
Hello World
```

### StringBuilder insert() method
The StringBuilder insert() method inserts the given string with this string at the given position.

```java
class Main{  
    public static void main(String args[]){  
        StringBuilder sb = new StringBuilder("Hello ");  
        sb.insert(1,"World");
        System.out.println(sb);
    }  
}  
```
Output
```
HWorldello
```

### StringBuilder replace() method
The StringBuilder replace() method replaces the given string from the specified beginIndex and endIndex.

```java
class Main{  
    public static void main(String args[]){  
        StringBuilder sb = new StringBuilder("Hello");  
        sb.replace(1,3,"World");  
        System.out.println(sb);//prints HWorldlo  
    }  
}  
```
Output
```
HWorldlo
```

### StringBuilder delete() method
The delete() method of StringBuilder class deletes the string from the specified beginIndex to endIndex.

```java
class Main{  
    public static void main(String args[]){  
        StringBuilder sb = new StringBuilder("Hello");  
        sb.delete(1,3);
        System.out.println(sb);
    }  
}  
```
Output
```
Hlo
```

### StringBuilder reverse() method
The reverse() method of StringBuilder class reverses the current string.

```java
class Main{  
    public static void main(String args[]){  
        StringBuilder sb = new StringBuilder("Hello");  
        sb.reverse();  
        System.out.println(sb);
    }  
}  
```
Output
```
OlleH
```

### StringBuilder capacity() method
The capacity() method of StringBuilder class returns the current capacity of the Builder. The default capacity of the Builder is 16. If the number of character increases from its current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34.

```java
class Main{  
    public static void main(String args[]){  
        StringBuilder sb = new StringBuilder();  
        System.out.println(sb.capacity());//default 16  
        sb.append("Hello");  
        System.out.println(sb.capacity());//now 16  
        sb.append("java is my favourite language");  
    System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
    }  
}  
```

### StringBuilder ensureCapacity() method
The ensureCapacity() method of StringBuilder class ensures that the given capacity is the minimum to the current capacity. If it is greater than the current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34.

```java
class Main{  
    public static void main(String args[]){  
        StringBuilder sb = new StringBuilder();  
        System.out.println(sb.capacity());//default 16  
        sb.append("Hello");  
        System.out.println(sb.capacity());//now 16  
        sb.append("java is my favourite language");  
        System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
        sb.ensureCapacity(10);//now no change  
        System.out.println(sb.capacity());//now 34  
        sb.ensureCapacity(50);//now (34*2)+2  
        System.out.println(sb.capacity());//now 70  
    }  
}  
```

## Difference between String and StringBuffer   

|String	| StringBuffer|
|---|---|
| String class is immutable.	| StringBuffer class is mutable.|
| String is slow and consumes more memory when you concat too many strings because every time it creates new instance.	| StringBuffer is fast and consumes less memory when you cancat strings.|
| String class overrides the equals() method of Object class. So you can compare the contents of two strings by equals() method.	| StringBuffer class doesn't override the equals() method of Object class.|

### Performance Test of String and StringBuffer

```java
public class ConcatPerformanceTest{  
    
    public static String concatWithString()    {  
        String t = "Java";  
        for (int i=0; i<10000; i++){  
            t = t + " test";  
        }  
        return t;  
    }  
    public static String concatWithStringBuffer(){  
        StringBuffer sb = new StringBuffer("Java");  
        for (int i=0; i<10000; i++){  
            sb.append("test");  
        }  
        return sb.toString();  
    }  
    public static void main(String[] args){  
        long startTime = System.currentTimeMillis();  
        concatWithString();  
        System.out.println("Time taken by Concating with String: "+(System.currentTimeMillis()-startTime)+"ms");  
        startTime = System.currentTimeMillis();  
        concatWithStringBuffer();  
        System.out.println("Time taken by Concating with  StringBuffer: "+(System.currentTimeMillis()-startTime)+"ms");  
    }  
}
```

## Difference between StringBuffer and StringBuilder

Java provides three classes to represent a sequence of characters: String, StringBuffer, and StringBuilder. The String class is an immutable class whereas StringBuffer and StringBuilder classes are mutable. There are many differences between StringBuffer and StringBuilder. The StringBuilder class is introduced since JDK 1.5.

| StringBuffer	| StringBuilder|
|---|---|
| StringBuffer is synchronized i.e. thread safe. It means two threads can't call the methods of StringBuffer simultaneously. | StringBuilder is non-synchronized i.e. not thread safe. It means two threads can call the methods of StringBuilder simultaneously.|
| StringBuffer is less efficient than StringBuilder.	| StringBuilder is more efficient than StringBuffer.|


### Performance Test of StringBuffer and StringBuilder
Let's see the code to check the performance of StringBuffer and StringBuilder classes.


```java
//Java Program to demonstrate the performance of StringBuffer and StringBuilder classes.  
public class ConcatPerformanceTest{  
    public static void main(String[] args){  
        long startTime = System.currentTimeMillis();  
        StringBuffer sb = new StringBuffer("Java");  
        for (int i=0; i<10000; i++){  
            sb.append("World");  
        }  
        System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");  
        startTime = System.currentTimeMillis();  
        StringBuilder sb2 = new StringBuilder("Java");  
        for (int i=0; i<10000; i++){  
            sb2.append("World");  
        }  
        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");  
    }  
}
```

## toString() method

If you want to represent any object as a string, toString() method comes into existence.

The toString() method returns the string representation of the object.

If you print any object, java compiler internally invokes the toString() method on the object. So overriding the toString() method, returns the desired output, it can be the state of an object etc. depends on your implementation

```java
class Student{  
    int rollno;  
    String name;  
    String city;  
  
    Student(int rollno, String name, String city){  
    this.rollno=rollno;  
    this.name=name;  
    this.city=city;  
 }  
   
 public String toString(){
    return rollno+" "+name+" "+city;  
 }  
 
 public static void main(String args[]){  
   Student s1=new Student(101,"Alejo1","Alvarez1");  
   Student s2=new Student(102,"Alejo2","Alvarez2");  
     
   System.out.println(s1);//compiler writes here s1.toString()  
   System.out.println(s2);//compiler writes here s2.toString()  
 }  
}  
```

## StringTokenizer

The java.util.StringTokenizer class allows you to break a string into tokens. It is simple way to break string.

It doesn't provide the facility to differentiate numbers, quoted strings, identifiers etc. like StreamTokenizer class. We will discuss about the StreamTokenizer class in I/O chapter.

### Constructors of StringTokenizer class

| Constructor	| Description |
|---|---|
| StringTokenizer(String str)	| creates StringTokenizer with specified string.|
| StringTokenizer(String str, String delim)	| creates StringTokenizer with specified string and delimeter.| 
| StringTokenizer(String str, String delim, boolean returnValue)	| creates StringTokenizer with specified string, delimeter and returnValue. If return value is true, delimiter characters are considered to be tokens. If it is false, delimiter characters serve to separate tokens.|

### Methods of StringTokenizer class

| Public method	| Description|
| boolean hasMoreTokens()	| checks if there is more tokens available. | 
| String nextToken()	| returns the next token from the StringTokenizer object. |
| String nextToken(String delim)	| returns the next token based on the delimeter. |
| boolean hasMoreElements()	| same as hasMoreTokens() method.|
| Object nextElement()	| same as nextToken() but its return type is Object.|
| int countTokens()	| returns the total number of tokens.|

Example of StringTokenizer class

Let's see the simple example of StringTokenizer class that tokenizes a string "my name is khan" on the basis of whitespace.

```java
import java.util.StringTokenizer;  
public class Main{  
 public static void main(String args[]){  
   
   StringTokenizer st = new StringTokenizer("My name is Alejo"," ");  
     while (st.hasMoreTokens()) {  
         System.out.println(st.nextToken());  
     }  
   }  
}  
```
Output
```
My
name
is
Alejo
```


```StringTokenizer class is deprecated now. It is recommended to use split() method of String class or regex (Regular Expression).```