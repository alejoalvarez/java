# Functional Interface #

Java 8 introduced **@FunctionalInterface**, an interface that has exactly one abstract method.

The compiler will treat any interfaces metting the definition of a functional interface as a functional interface; it means the @FunctionalInterface annotation is optional.

A functional interface can implement one or more methods by default, but you must necessarily have a single abstract method (Abstract method is a method without implementation).

They become important when using lambdas expressions.

Six basics function interfaces:
  
|Interface|Signature|Example|
|---|---|---|
|UnaryOperator<T>|T apply(T t)|String::toLowerCase, Math::tan|
|BinaryOperator<T>| T apply(T t1, T t2)|BigInteger::add, Math::pow|
|Function<T, R>|  R apply(T t)| Arrays::asList, Integer::toBinaryString|
|Predicate<T, U>|boolean test(T t, U u)| String::isEmpty, Character::isDigit  |
|Supplier<T>|T get() | LocalDate::now, Instant::now|
|Consumer<T>|void accept(T t)|System.out::println, Error::printStackTrace|

It is recommended to use the **@FunctionalInterface** annotation to follow good development practices.


<img src="https://alejoalvarez.github.io/Images/Java-Functional-Interface/FunctionalInterface1.png">


In this interface, we define a method that sends a greeting to the person that we pass as a parameter, but the body of the method is not yet defined.

<img src="https://alejoalvarez.github.io/Images/Java-Functional-Interface/FunctionalInterface2.png">

This second interface is also a functional interface, since it only has an abstract method.

Another way to ensure that we are defining a functional inteface correctly is to annotate it with @FunctionalInterface, since when annotating it the IDE will automatically throw us an error if we do not comply with the rules of a functional interface. However, it is important to note that at runtime it will not give us a different behavior, since it is used to prevent errors when defining interfaces. Let's see how the previous class would look with this annotation:

<img src="https://alejoalvarez.github.io/Images/Java-Functional-Interface/FunctionalInterface3.png">

## Functional Interfaces with lambda expressions ##

Let's see how you could use the IStrategy class using lambda expressions:

<img src="https://alejoalvarez.github.io/Images/Java-Functional-Interface/FunctionalInterface4.png">

Let's see how in line 8 we define a lambda expression where "Hello" concatenates with the name of the person that is passed as a parameter, then this expression is assigned to the variable to the **functional1** variable, which is of type **IFunctional**. After this we call the sayHelloTo method which returns the greeting to "Alejo Alvarez", followed in line 11 we call the sayHelloWord method, which sends a Hello Word.


```
Hello Alejo Alvarez
Hello world!
```
