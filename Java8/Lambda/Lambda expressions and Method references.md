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
