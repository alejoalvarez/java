# Java POJO
Java POJO class – Plain Old Java Object

Till now, we have discussed and used the normal objects in Java. In this article, we will learn a special type of object POJO. POJO stands for Plain Old Java Object, which is used to increase the reusability and readability of the Java program. We will discuss how to use Java POJO Class and why it is important to learn it.

## What is POJO class in Java?

**POJO** stands for Plain Old Java Object which is a normal object that is not bound with special restrictions. They are only bound with some restrictions on Java Language Specifications. Simply, POJO acts as a pure data structure that has getter and setter methods. POJO objects do not require any classpath. POJO is the most widely used class in Java because it is very easy to write and understand. Sun Microsystems introduced the POJO class in Java in EJB 3.0.

POJO class can override certain methods such as Serializable or also from the Object class.

A POJO must not do the following:

- A POJO class must not extend the predefined classes such as HttpServlet, Arrays, Calendar, etc. For example, if we write, public class MyClass extends javax.servlet.http.HttpServlet, then the class MyClass can’t be considered as POJO class.
- A POJO class should not contain pre-specified annotations. For example, @Retention(RetentionPolicy.RUNTIME) public class MyClass{..} is not a POJO class.
- A POJO class can’t implement predefined interfaces. For example public class Test implements javax.ejb.EntityBean { … } can’t be considered as a POJO class.

Now, let’s implement POJO class in Java.

POJO class generally defines an entity. For example, if you want an Intern class then you can create a POJO as follows:

```java
// Intern POJO class to represent entity Intern
public class Intern {
  // default field
  String name;
  // public field
  public String role;
  // private field
  private double salary;
  //arg-constructor to initialize fields
  public Intern(String name, String role, double salary) {
    this.name = name;
    this.role = role;
    this.salary = salary;
  }
  // getter method for name
  public String getName() {
    return name;
  }
  // getter method for role
  public String getRole() {
    return role;
  }
  // getter method for salary
  public Double getSalary() {
    return salary;
  }
}
```

The above example clearly shows a well-defined POJO class. In this example, you can see that the access modifiers of the fields are not restricted. They can have any access modifiers like public, private, default, or protected. You can also note that in POJO class there is no need to add any constructor.

We can use the POJO class in any Java code. POJO class is not tied to the framework. But we can’t implement this POJO class with any real conventions to change the state of the class.

POJO behaves like an object that incorporates the business logic of the application. The following figure shows the working of a POJO class. From the image, you can clearly see that the controller interacts with the business logic. The business logic, in turn, interacts with the POJO class for getting access to the database.

## What are Java Beans?

Java Beans are a special type of POJOs. But there are some restrictions on Java beans to become POJO. These restrictions are as follows:

- All JavaBeans can be POJOs but all POJO classes can not be Java Beans.
- Java Beans should implement the Serializable interface.
- All the fields of the Java Beans should be private to provide complete control over the fields.
- All the fields should have either getter or setter methods or both of them.
- There must be a no-arg constructor in a bean.
- We can access the fields only by constructor or getter setters.

```java
import java.io. * ;
class Student implements java.io.Serializable {
  private int id;
  private String name;
  public Student() {}
  public void setId(int id) {
    this.id = id;
  }
  public int getId() {
    return id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
}
public class Test {
  public static void main(String args[]) {
    Student s = new Student(); //object is created
    s.setName("Alejo"); //setting value to the object
    System.out.println(“Name of the student is: ” + s.getName());
  }
}
```


## JAVA POJO Class vs Java Bean

|POJO |	JAVA BEAN |
|---|---|
| There is no restriction on the POJO class other than those forced by Java Specification language. | Java Bean is a special POJO class that has some restrictions. |
| POJO class does not provide much control over the fields. | Java Bean provides complete control over the members.|
| POJO class may or may not implement a Serializable interface. | A Java Bean must implement a Serializable interface.|
| We can directly access the fields by their names	| We can access the fields inside the Java Bean only by getters and setters methods.|
| There can be any of the access modifiers for fields.	| Fields in Java Beans must be only private.|
| There may or may not be a no-arg constructor in the POJO class.	| There must be a no-arg constructor in Java Beans.|
| We use the POJO class when there is no need to put restrictions on the fields and there can be complete access over the fields. |	We use Java Beans when we do not want to give complete access to the entities. |
