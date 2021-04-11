# Serialization

<p align="center">
<img src="https://github.com/alejoalvarez/Images/blob/trunk/Java/serialization.png">
</p>

The basic concept is that we will convert the object into the form of a byte array and we will send that byte array to the server that we will again convert this byte array into the object. Basically the process of converting the object into the byte stream is called Serialization; we say that we serialize the object into the byte array. And, when we convert the byte stream back to the object then we call it Deserialization; we say that the byte stream is being deserialized to the object.

Serialization in Java is a process of writing the state of an object into a byte stream. We need to convert an object into a byte stream because the byte stream is platform-independent. So we can use this advantage by serializing an object on one platform and using the byte stream on different platforms. In order to serialize an object, we need to implement the java.io.Serializable interface.

The technique of Serialization in Java is mainly used in technologies like RMI(Remote Method Invocation), EJB(Enterprise Java Beans), JPA(Java Persistence API), and Hibernate, etc. To serialize an object into a byte stream, we need to call the writeObject() method of the ObjectOutputStream class.

## java.io.Serializable Interface
The java.io.Serializable is a marker interface that adds a Serializable behavior to a class that implements it.

## ObjectOutputStream class

The class ObjectInputStream is a high-level stream that contains the methods for serializing an object into a byte stream. The ObjectOutputStream class writes objects and primitive data types to an OutputStream. The rule is that we can write only that object to the streams that support the java.io.Serializable interface.

**Constructor of ObjectOutputStream class**
We use the constructor of the ObjectOutputStream class that has the following syntax:

```java
public ObjectOutputStream(OutputStream output) throws IOException 
{
      //code
}
```

This constructor creates an ObjectOutputStream that writes to the specified OutputStream.

## Important Methods of ObjectOutputStream class
There are some important methods in the ObjectOutputStream class that help us to serialize an object. These methods are listed in the following table:

|Method |	Description|
|---|---|
| public final void writeObject(Object obj) throws IOException {}	| This method writes the specified object to the ObjectOutputStream class.|
| public void flush() throws IOException {}	| This method flushes the current output stream object.|
| public void close() throws IOException {}	| This method closes the current output stream object.|


Example

To understand the working of Serialization in java, we will first create a class that implements the Serializable interface. We will create a class Teacher. This class implements the java.io.Serializable interface and has 2 members and one constructor.

```java

import java.io.Serializable;  

public class Customer implements Serializable
{  
    
    int id;  
    String name;  
    public Customer(int id, String name)
    {  
      this.id = id;  
      this.name = name;  
   }  
}
```

Now after this, we will serialize the object of the Teacher class. To accomplish this, we will use the writeObject() method of ObjectOutputStream class that is used to serialize the object into a byte stream. We will store the object’s state into a text file exampleFile.txt.

```java

import java.io.*;  

public class Serialization{  
    public static void main(String args[])
    {  
        try {  
            //Creating the object  of Customer class
            Customer t1 = new Customer(101," John");  
            //Creating the byte stream and writing the object into a file 
            FileOutputStream file = new FileOutputStream("exampleFile.txt");  
            ObjectOutputStream output = new ObjectOutputStream(file);  
            output.writeObject(t1);  
            output.flush();  
        
            //closing the stream  
            output.close();  
            System.out.println("Successfully created a byte stream and written it in the specified file");  
        } catch(Exception e){
            System.out.println(e);  
        } 
    }    
}  

```

## Deserialization

It is the reverse process of Serialization which converts the created byte stream back into the state of the object. The method used to deserialize a byte stream into an object is readObject() method of ObjectInputStream class.

### ObjectInputStream class

An ObjectInputStream is a high-level stream class that contains methods that help us in deserializing a byte stream back to the state of the object. It deserializes the objects and primitive data that are written using an ObjectOutputStream.

**Constructor of ObjectInputStream class**
We use the constructor of the ObjectOutputStream class that has the following syntax:

```java
public ObjectInputStream(InputStream in) throws IOException {
  //code
}
```

This constructor creates an ObjectInputStream that reads from the specified InputStream.

**Important Methods of ObjectInputStream class**
There are some important methods in the ObjectInputStream class that help us to deserialize an object. These methods are listed in the following table:

| Method	| Description|
|---|---|
| public final Object readObject() throws IOException, ClassNotFoundException{}	| This method reads an object from the input stream. |
| public void close() throws IOException {}	| This method is used to close the object of  ObjectInputStream |

Example

```java
package com.techvidvan.deserialization;
import java.io.*;  
public class Deserialization {  
    public static void main(String args[]) {

        try{  
            //Creating stream to read the object  
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("exmapleFile.txt"));  
            Customer teacher = (Teacher)input.readObject();  
        
            //printing the data of the serialized object  
            System.out.println(“The id of the teacher is:” +teacher.id);  
            System.out.println(“The name of the teacher is:” +teacher.name); 
            
            //closing the stream  
            input.close();  
        } catch(Exception e) {
            System.out.println(e);
        }  
    }  
}  
```

## Java Serialization with Inheritance (IS-A Relationship)

If the parent class implements the Serializable interface, then all its child classes will also be Serializable automatically. To understand this concept, let’s take an example:

**Parent class:**
```java
import java.io.Serializable;  

class Employee implements Serializable {  
    int id;  
    String name;  
    
    Employee(int id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
}
```

**Child class:**

```java
class Teacher extends Employee {  
    String subjectName;  
    double salary;  
    public Teacher(int id, String name, String subjectName, double salary) {  
        super(id,name);     
        this.subjectName= subjectName;
        this.salary = salary;;  
    }  
}  
```

Now we can easily serialize the object of the Teacher class that extends the Employee class. As the Employee class is Serializable, the Teacher class will automatically become Serializable without implementing the Serializable interface.

<p align="center">
<img src="https://github.com/alejoalvarez/Images/blob/trunk/Java/Serialization-De-Serialization-in-java.png">
</p>

## Java Serialization with the static data member
If our class contains any static data member, it will not be serialized because static is the part of the class not the object.

```java

import java.io.*;

class Student implements Serializable{  
    int id;  
    String name;  
    static String collegename = "SVV University";    //We can’t serialize the static member
   
    public Student(int id, String name){  
        this.id = id;  
        this.name = name;  
   }  
}  
```

## Java transient Keyword
There are some cases when you don’t want to serialize any data member of a class but also include it in the code of serialization. In this case, you can mark or declare that member with the transient keyword which will restrict the member from being serialized.

```java

import java.io.*;

class Student implements Serializable{  
    transient int id;    //Making id transient so that it cant be serialized
    String name;  
   
    public Student(int id, String name){  
        this.id = id;  
        this.name = name;  
   }  
}  
```

Now, the transient member id can not be serialized. When we deserialize the object, then you will get the values of only name or other non-transient members. But the value of id as default will be returned. In our case, it will return 0 as default value as id is of int type