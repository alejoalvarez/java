#  Stream API Improvement

In Java 9, Stream API has improved and new methods are added to the Stream interface. These methods are tabled below.

| Modifier and Type	| Method	| Description|
|---|---|---|
| default Stream<T>	| takeWhile(Predicate<? super T> predicate)	| It returns, if this stream is ordered, a stream consisting of the longest prefix of elements taken from this stream that match the given predicate. Otherwise returns, if this stream is unordered, a stream consisting of a subset of elements taken from this stream that match the given predicate.| 
| default Stream<T>	| dropWhile(Predicate<? super T> predicate)	| It returns, if this stream is ordered, a stream consisting of the remaining elements of this stream after dropping the longest prefix of elements that match the given predicate. Otherwise returns, if this stream is unordered, a stream consisting of the remaining elements of this stream after dropping a subset of elements that match the given predicate. |
|static <T> Stream<T>	| ofNullable(T t)	| It returns a sequential Stream containing a single element, if non-null, otherwise returns an empty Stream.
|static <T> Stream<T>	| iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)	| It returns a sequential ordered Stream produced by iterative application of the given next function to an initial element, conditioned on satisfying the given hasNext predicate. The stream terminates as soon as the hasNext predicate returns false.| 

## Java Stream takeWhile() Method

Stream takeWhile method takes each element that matches its predicate. It stops when it get unmatched element. It returns a subset of elements that contains all matched elements, other part of stream is discarded.

Java Stream takeWhile() Method Example 1

In this example, we have a list of integers and picks up even values by using takewhile method.

```java
import java.util.List;  
import java.util.stream.Collectors;  
import java.util.stream.Stream;  
public class StreamExample {  
    public static void main(String[] args) {  
        List<Integer> list   
        = Stream.of(1,2,3,4,5,6,7,8,9,10)  
                .takeWhile(i -> (i % 2 == 0)).collect(Collectors.toList());     
    System.out.println(list);  
    }  
}  
```

```
Output:

[]
```

Java Stream takeWhile() Method Example 2

```java
<p>In this example, we are getting first two elements because these are even and stops at third element. </p>  
<div class="codeblock"><textarea name="code" class="java">  
import java.util.List;  
import java.util.stream.Collectors;  
import java.util.stream.Stream;  
public class StreamExample {  
    public static void main(String[] args) {  
        List<Integer> list   
        = Stream.of(2,2,3,4,5,6,7,8,9,10)  
                .takeWhile(i -> (i % 2 == 0)).collect(Collectors.toList());     
    System.out.println(list);  
    }  
}  
```

```
Output:

[2,2]
```

## Java Stream dropWhile() Method

Stream dropWhile method returns result on the basis of order of stream elements.

**Ordered stream:** It returns a stream that contains elements after dropping the elements that match the given predicate.

**Unordered stream:** It returns a stream that contains remaining elements of this stream after dropping a subset of elements that match the given predicate.

Java Stream dropWhile() Method Example

```java
import java.util.List;  
import java.util.stream.Collectors;  
import java.util.stream.Stream;  
public class StreamExample {  
    public static void main(String[] args) {  
        List<Integer> list   
        = Stream.of(2,2,3,4,5,6,7,8,9,10)  
                .dropWhile(i -> (i % 2 == 0)).collect(Collectors.toList());     
    System.out.println(list);  
    }  
}  
```

```
Output:

[3, 4, 5, 6, 7, 8, 9, 10]
```

## Stream ofNullable Method

Stream ofNullable method returns a sequential stream that contains a single element, if non-null. Otherwise, it returns an empty stream.

It helps to handle null stream and NullPointerException.

Java 9 Stream ofNullable Method Example 1

```java
import java.util.List;  
import java.util.stream.Collectors;  
import java.util.stream.Stream;  
public class StreamExample {  
    public static void main(String[] args) {  
        List<Integer> list   
        = Stream.of(2,2,3,4,5,6,7,8,9,10)  
                .dropWhile(i -> (i % 2 == 0)).collect(Collectors.toList());     
    System.out.println(list);  
    }  
}  
```

```
Output:

25
Stream can have null values also.
```

Java 9 Stream ofNullable Method Example 2

```java
import java.util.stream.Stream;  
  
public class StreamExample {  
    public static void main(String[] args) {  
        Stream<Integer> val   
        = Stream.ofNullable(null);     
    val.forEach(System.out::println);  
    }  
}  
```

This program will not produce any output.

## Stream Iterate Method

A new overloaded method iterate is added to the Java 9 stream interface. This method allows us to iterate stream elements till the specified condition.

It takes three arguments, seed, hasNext and next.

Java Stream Iterate Method Example

```java
import java.util.stream.Stream;  
  
public class StreamExample {  
    public static void main(String[] args) {  
        Stream.iterate(1, i -> i <= 10, i -> i*3)  
        .forEach(System.out::println);  
    }  
}  
```

```
Output:

1
3
9
```