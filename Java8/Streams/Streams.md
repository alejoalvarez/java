# Streams


It is a Java API for handling data in collections.

It is a wrapper that wraps collections

Streams are a sequence of elements that support sequential and parallel aggregation operations. One of the new Java 8 features that allows you to manipulate collections like never before, almost dreamlike.

Streams are **Monads** (thus playing a big part int bringing functional programming, a mondas is a structure that represents computations defined as sequences of steps. A type with a monad structure defines what it means to chain operations, or nest functions of that type together).

As a programmer you have surely worked with an infinity of collections, surely you have had to go through them, order them, divide them, filter them, eliminate or add new elements in the collection. And every time you did this you were almost forced to perform a foreach on the collection, you even had to do a nested foreach to be able to perform more complex operations; proof of this is that the name **ConcurrentModificationException** reminds you of something (or doesn't it?).

Well, Streams do not allow creating shortcuts when processing collections, creating data flows that allow processing in a declarative way, that is, we focus on what we want to solve, and not on how we should do it, as it happens in imperative programming.

Let's see the simplest case when using a collection, let's print all the values ​​of a list Simple isn't it?

```java
public static void printForeach(){
  List<String> names = getStringArray();
  for (String name : names) {
     System.out.println(name);
  }
}
```

This code that you are seeing is a normal scenario that you would use to print all the elements of a list (I bet it is), isn't there anything strange? The truth is that no, because we are already used to doing it like this, but I bet you that your point of view about this code would change if you said that I can do the foreach in a single line of code

```java
public static void printStream(){
    List<String> names = getStringArray();
    names.stream().forEach(System.out::println);
}
```

Note that we are using the **stream()** method to obtain the Stream, followed by, we only use the **forEach()** method in which we define what we are going to do for each element of the collection. In this case we are printing each employee using **Method Reference.**

Imagine that streams are a way to iterate all the elements of the collection in a simple way, and that while you iterate them you can perform operations on the collection in a declarative way. That is, we are going to perform operations but focusing on the objective we seek, not on how to implement the algorithm to make it work. Let's look at another more complex example.

## Example

We have a list of Employees, each employee has a DNI that identifies him as unique, has a name and the department to which he belongs. The list of employees is as follows:

<p>

| Id | Name | Department |
|---|---|---|
| 1  | Alejo Alvarez   |  System |
| 2  | Maria Gutierrez  | Sales  |
| 3  | Manuela Rojas  |  RH |
| 4  | Pepito Perez  |  Sales |
| 5  | Laura Pulido |  Sales |
| 1  | Alejo Alvarez |  System |
</p> </br>

Now, on this list we want to filter all the Employees that belong to the systems department, then we are going to order all the employees in ascending order by their name, then we are going to filter the repeated elements by their ID, finally, we will print the name of all employees who followed all the rules.

```java
public static void printOrderedSystemEmployees(){
    List<Employee> employess = getEmployeeArray();
    employess.stream()
            .filter(x -> x.getDepartment().equals("Systems"))
            .sorted((x,y) -> x.getName().compareToIgnoreCase(y.getName()))
            .distinct()
            .forEach(System.out::println);
}
```


