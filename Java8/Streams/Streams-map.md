# Streams - map()

The intermediate operation ```map``` converts each element into another object via the given function. The following example converts each string into an upper-cased string. But you can also use map to transform each object into another type. The generic type of the resulting stream depends on the generic type of the function you pass to ```map```.

```java
stringCollection
    .stream()
    .map(String::toUpperCase)
    .sorted((a, b) -> b.compareTo(a))
    .forEach(System.out::println);

// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
```