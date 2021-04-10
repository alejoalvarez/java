# Annotations

Java Annotation is a kind of a tag that represents the metadata or information attached with class, interface, methods, or fields to show some additional information that Java compiler and JVM can use.

Though Annotations are not a part of the Java code they allow us to add metadata information into our source code. Java introduced Annotations from JDK 5. There is no direct effect of Annotations on the operation of the code they annotate; they do not affect the execution of the program. Annotations provide supplemental information about a program.

Some points about Annotations are:

- They start with ‘@’.
- They do not change the action or execution of a compiled program.
- Annotations help to associate metadata or information to the elements of the program like classes, instance variables, interfaces, constructors, methods, etc.
- We cannot consider Annotations as pure comments as they can change the way a compiler treats a program


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
import java.lang.annotation. * ; @Target(ElementType.TYPE_USE)@interface TypeAnnoDemo {}
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

RESULT
I am annotated with a type annotation
There is a use of annotation with the return type of the function”);
```

### Repeating Annotations in java

Repeating Annotations are the annotations that we apply to a single item more than once. The repeating annotations must be annotated with the @Repeatable annotation, which is present in the java.lang.annotation package. The value of this annotation specifies the container type for the repeatable annotation. There is a container specified as an annotation whose value field is an array of the repeatable annotation type. Hence, to create a repeatable annotation, firstly we need to create the container annotation, and then specify the annotation type as an argument to the @Repeatable annotation.


```java
import java.lang. * ;@Retention(RetentionPolicy.RUNTIME)@Repeatable(MyRepeatedAnnos.class)@interface MyWords {
  String word()
default "Hello World";
  int value()
default 0;
}
// Creating a container annotation
@Retention(RetentionPolicy.RUNTIME)@interface MyRepeatedAnnotations {
  MyWords[] value();
}
public class MyClass {
  @MyWords(word = "Data", value = 1)@MyWords(word = "Flair", value = 2)
  public static void myMethod() {
    MyClass obj = new MyClass();
    try {
      Class < ?>c = obj.getClass();
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

RESULT
@MyRepeatedAnnotations(value={@MyWords(value=1, word=”Data”), @Words(value=2, word=”Flair”)})

```