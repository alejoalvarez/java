# Annotations

Java Annotation is a kind of a tag that represents the metadata or information attached with class, interface, methods, or fields to show some additional information that Java compiler and JVM can use.

Though Annotations are not a part of the Java code they allow us to add metadata information into our source code. Java introduced Annotations from JDK 5. There is no direct effect of Annotations on the operation of the code they annotate; they do not affect the execution of the program. Annotations provide supplemental information about a program.

Some points about Annotations are:

- They start with ‘@’.
- They do not change the action or execution of a compiled program.
- Annotations help to associate metadata or information to the elements of the program like classes, instance variables, interfaces, constructors, methods, etc.
- We cannot consider Annotations as pure comments as they can change the way a compiler treats a program

**Example**
```java
class Base {
  public void display() {
    System.out.println("Base class display() method");
  }
}
public class Derived extends Base{
  
  @Override
  public void display(int x) {
    System.out.println("Derived class display(int) method");
  }
  
  public static void main(String args[]) {
    Derived obj = new Derived();
    obj.display();
  }
}
```

Output
```
error: method does not override or implement a method from a supertype@Override
```


If we remove parameter (int x) from the method or if we remove the @override annotation from the code, then the program compiles fine. The output will be:

Output
```
Base class display() method
```

## Types of Java Annotations
There are five types of nnotations which are:

- Marker Annotations
- Single Value Annotations
- Full Annotations
- Type Annotation
- Repeating Annotation

### Marker Annotations
The only purpose of the Marker Annotation is to mark a declaration. The Marker Annotations do not contain any members and do not consist of any data. Therefore, the presence of these annotations as an annotation is sufficient. Since the marker interface in java contains no members, simply determining whether it is present or absent is sufficient. @Override is an example of Marker Annotation.

Example:
```@TestAnnotation()```

### Single value Annotations

The Single Value Annotations as the name suggests, contain only one member. They allow a shorthand form of specifying the value of the member. When we apply this annotation, we only need to specify the value for that member and also do not need to specify the name of the member. However, in order to use this shorthand, there must be a value for the name of the member.

Example:
```@TestAnnotation(“testing”);```

### Full Annotations

The full Annotations consist of multiple data members/names, values, and pairs.

Example:
```@TestAnnotation(owner= ”Rahul”, value= ”Class DataFlair”)```

### Type Annotations in Java
The type annotations are applicable to any place where there is a use of a type. For example, if we want to annotate the return type of a method, we can declare these annotations with @Target annotation.

Code to demonstrate a Type Annotation

```java
import java.lang.annotation.* ; 

@Target(ElementType.TYPE_USE)
@interface TypeAnnoDemo {}
public class MyClass {
  public static void main(String[] args) {@TypeAnnoDemo String s = "Hello,I am annotated with a type annotation";
    System.out.println(s);
    myMethod();
  }
  static @TypeAnnoDemo int myMethod() {
    System.out.println("There is a use of annotation with the return type of the function”);
            return 0;
      }
}
```

Output
```
I am annotated with a type annotation
There is a use of annotation with the return type of the function”);
```

### Repeating Annotations in java

Repeating Annotations are the annotations that we apply to a single item more than once. The repeating annotations must be annotated with the @Repeatable annotation, which is present in the java.lang.annotation package. The value of this annotation specifies the container type for the repeatable annotation. There is a container specified as an annotation whose value field is an array of the repeatable annotation type. Hence, to create a repeatable annotation, firstly we need to create the container annotation, and then specify the annotation type as an argument to the @Repeatable annotation.


```java
import java.lang.* ;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyWords {
  String word()
  default "Hello World";
  int value()
  default 0;
}

// Creating a container annotation
@Retention(RetentionPolicy.RUNTIME)

@interface MyRepeatedAnnotations {
  MyWords[] value();
}

public class MyClass {
  @MyWords(word = "Data", value = 1)
  @MyWords(word = "Flair", value = 2)
  public static void myMethod() {
    MyClass obj = new MyClass();
    try {
      Class <?>c = obj.getClass();
      Method m = c.getMethod("myMethod");
      Annotation a = m.getAnnotation(MyRepeatedAnnotations.class);
      System.out.println(anno);
    }
    catch(NoSuchMethodException e) {
      System.out.println(e);
    }
  }
  public static void main(String[] args) {
    myMethod();
  }
}
```

Output
```
@MyRepeatedAnnotations(value={@MyWords(value=1, word=”Data”), @Words(value=2, word=”Flair”)})
```

## Custom annotations

```java
public @interface ExampleAnnotation{

  String name();
  String description();
}

class Main{
  @ExampleAnnotation(name = "test", description = "test annotation")
  public void testMethod(){
    // implementation
  }
}
```

## Predefined/ Standard Annotations in java
Java has six built-in annotations as follows:

###  @Override

We should use @Override annotation while overriding a method in the child class to mark that method.

This provides more readability to the code and avoids maintenance issues like you must change the signature in child classes (where we are using this annotation) while changing the method signature of the parent class otherwise, the compiler would throw compilation error.

This is difficult to trace when you do not have used this annotation.

```java
class ParentClass {
  public void display() {
    System.out.println("Parent class display() method");
  }

  public static void main(String args[]) {
    ParentClass obj = new ChildClass);
    obj.display();
  }
}
class ChildClass extends ParentClass {@Override
  public void display() {
    System.out.println("Child class display() method");
  }
}
```

Output
```
Child class display() method
```

### @Deprecated

The @Deprecated annotation indicates that a marked class, method, or field is ‘deprecated’ and they are no longer in use. The compiler gives a warning message whenever there is a use of deprecated class, method, or field marked with the @Deprecated annotation in the program.

When an element is deprecated, there is a need to document them using the Javadoc @deprecated tag. You should note that there is a difference between @Deprecated and @deprecated. @deprecated is for documentation purposes, and @Deprecated is for Annotations.

```java
public class Test {
  
  @Deprecated
  public void display() {
    System.out.println("display() method of Test class");
  }
  public static void main(String args[]) {
    Test obj = new DeprecatedTest();
    obj.display();
  }
}
```

Output
```
display() method of Test class
```

### @SuppressWarnings

The @SupressWarnings annotation instructs the compiler to ignore specific warnings.

For example in the below code, We are calling a deprecated method so the compiler should generate a warning, however, we are using @SuppressWarnings annotation that would suppress that deprecation warning.

```java
class Test {

  @Deprecated
  public void display() {
    System.out.println("display() method of Test class");
  }
}

public class SuppressWarningTest {
  
  @SuppressWarnings({
    "checked",
    "deprecation"
  })
  public static void main(String args[]) {
    DeprecatedTest obj = new DeprecatedTest();
    obj1.display();
  }
}
```

Output
```
display() method of Test class
```

### @Documented Annotations in Java

The @Documented Annotation is a annotation that says a tool that there is a need for documenting an annotation. Annotations are not present in Javadoc comments.

The @Documented annotation enables tools like Javadoc to process it and include the annotation type information in the generated document.

### @Target

The design of Target annotation is such that we can use them only as an annotation to another annotation. @Target Annotation takes one argument and this argument must be a constant value from the ElementType enumeration.

The following table shows the constants along with the type of the declaration to which they correspond.

- @Target - Specifies the type of element to which the annotation is to be associated.
  - ElementType.TYPE - can be applied to any element of the class.
  - ElementType.FIELD - can be applied to a member of the class.
  - ElementType.METHOD - can be applied to a method
  - ElementType.PARAMETER - can be applied to parameters of a method.
  - ElementType.CONSTRUCTOR - can be applied to constructors
  - ElementType.LOCAL_VARIABLE - can be applied to local variables
  - ElementType.ANNOTATION_TYPE - indicates that the declared type itself is an annotation type.
- @Retention - Specifies the retention level of the annotation.
  - RetentionPolicy.SOURCE - Retained only at the code level; ignored by the compiler.
  - RetentionPolicy.CLASS - Held at compile time, but ignored at run time.
  - RetentionPolicy.RUNTIME - Held at run time, only accessible at run time.
- @Documented - Will cause the annotation to be mentioned in the javadoc.

### @Inherited

@Inherited is a marker annotation that we can use only on the annotation declaration. It affects only annotations used on class declarations. @Inherited annotation causes the subclass to inherit the annotation for a superclass.

Therefore, whenever there is a request to a subclass for a specific annotation, and if the annotation is absent in the subclass, then it checks its superclass. If that annotation is present in the superclass, and if it is annotated with @Inherited, then it returns that annotation.



Example

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
 
@Retention(RetentionPolicy.RUNTIME)  // annotation is used in Runtime
@interface MyAnnotation{
     
    String key();
    String value();
}
 
public class MyAnnotationTest {
 
    @MyAnnotation(key="site", value="alejo.com")
    public void myAnnotationTestMethod(){
         
        try {
            Class<? extends MyAnnotationTest> cls = this.getClass();
            Method mth = cls.getMethod("myAnnotationTestMethod");
            MyAnnotation myAnnotation = mth.getAnnotation(MyAnnotation.class);
            System.out.println("key: " + myAnnotation.key());
            System.out.println("value: " + myAnnotation.value());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    public static void main(String a[]){
         
        MyAnnotationTest mat = new MyAnnotationTest();
        mat.myAnnotationTestMethod();
    }
}

// RESULT
key: site
value: alejo.com
```
