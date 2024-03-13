# Java 8 Lambda Expressions and Method References #

Java 8 introduced lambda expressions to provide the implementation of the abstract method of a functional interface

Review th JDK **Iterable** class, it has a **default** method **forEach()** to accept a function interface **Consumer** 

```java
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

First, we can provide an anonymous class as the `forEach` implementation.

```java
List<String> list = Arrays.asList("node", "java", "python", "ruby");

list.forEach(new Consumer<String>() { // anonymous class
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
list.forEach(System.out::println); // method references
```

## Lambda Scopes
Accessing outer scope variables from lambda expressions is very similar to anonymous objects. You can access final variables from the local outer scope as well as instance fields and static variables.

### Accessing local variables

We can read final variables from the outer scope of lambda expressions:

```java
final int num = 1;
Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
stringConverter.convert(2); // 3
```

But different to anonymous objects the variable num does not have to be declared final. This code is also valid:

```java
int num = 1;
Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
stringConverter.convert(2); // 3
```

However ```num``` must be implicitly final for the code to compile. The following code **does not** compile:

```java
int num = 1;
Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
num = 3;
```

Writing to num from within the lambda expression is also prohibited.

### Accessing fields and static variables

In contrast to local variables we have both read and write access to instance fields and static variables from within lambda expressions. This behavior is well known from anonymous objects.

```java
class LambdaExample {

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

Remember the formula example from the first section? Interface `Formula` defines a default method `sqrt` which can be accessed from each formula instance including anonymous objects. This does not work with lambda expressions.

Default methods **cannot** be accessed from within lambda expressions. The following code does not compile:

```java
Formula formula = (a) -> sqrt( a * 100);
```

## Example

Let's start with a simple example of how to sort a list of strings in prior versions of Java:

```java
List<String> names = Arrays.asList("Alejo", "Juan", "Ana", "Maria");

Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
});
```

The static utility method Collections.sort accepts a list and a comparator in order to sort the elements of the given list. You often find yourself creating anonymous comparators and pass them to the sort method.

Instead of creating anonymous objects all day long, Java 8 comes with a much shorter syntax, lambda expressions:

```java
Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});
```

As you can see the code is much shorter and easier to read. But it gets even shorter:

```java
Collections.sort(names, (String a, String b) -> b.compareTo(a));
```

For one line method bodies you can skip both the braces {} and the return keyword. But it gets even shorter:

```java
names.sort((a, b) -> b.compareTo(a));
```

List now has a sort method. Also the java compiler is aware of the parameter types so you can skip them as well. Let's dive deeper into how lambda expressions can be used in the wild.






