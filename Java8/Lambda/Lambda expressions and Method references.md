# Java 8 Lambda Expressions and Method References #

Java 8 introduced lambda expressions to provide the implementation of the abstract method of a functional interface

Review th JDK **Interable** class, it has a **default** method **forEach()** to accept a fnction interface **Consumer** 

```java
Iterable.java

public interface Iterable<T> {

    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

   //...
}
```

First, we can provide an anonymius class as the **forEach** implementation.

```java
List<String> list = Arrays.asList("node", "java", "python", "ruby");
list.forEach(new Consumer<String>() {       // anonymous class
    @Override
    public void accept(String str) {
        System.out.println(str);
    }
});
```

Alternatively, we can use a lambda expression to shorten the code like this:
```java
List<String> list = Arrays.asList("node", "java", "python", "ruby");
list.forEach(str -> System.out.println(str)); // lambda expressions
```

To gain better readability, we can replace lambda expression with method reference.

```java
List<String> list = Arrays.asList("node", "java", "python", "ruby");
list.forEach(System.out::println);           // method references
```


## Lambda Scopes
Accessing outer scope variables from lambda expressions is very similar to anonymous objects. You can access final variables from the local outer scope as well as instance fields and static variables.

### Accessing local variables

We can read final variables from the outer scope of lambda expressions:

```java
final int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);

stringConverter.convert(2);     // 3
```

But different to anonymous objects the variable num does not have to be declared final. This code is also valid:

```java
int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);

stringConverter.convert(2);     // 3
```

However ```num``` must be implicitly final for the code to compile. The following code **does not** compile:

```java
int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);
num = 3;
```

Writing to num from within the lambda expression is also prohibited.

### Accessing fields and static variables

In constrast to local variables we have both read and write access to instance fields and static variables from within lambda expressions. This behaviour is well known from anonymous objects.

```java
class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}
```

### Accessing Default Interface Methods

Remember the formula example from the first section? Interface ```Formula``` defines a default method ```sqrt``` which can be accessed from each formula instance including anonymous objects. This does not work with lambda expressions.

Default methods **cannot** be accessed from within lambda expressions. The following code does not compile:

```java
Formula formula = (a) -> sqrt( a * 100);
```