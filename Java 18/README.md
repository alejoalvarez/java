# Java 18

## UTF-8 by Default

In Java 18, this JEP makes the default charset to UTF-8. However, we still allow configuring the default charset to others by providing the system property ‘file.encoding’.

In Java 18, if the file.encoding system property is COMPACT, the JVM uses Java 17 and an earlier algorithm to choose the default charset.

```sh
java -Dfile.encoding=COMPAT
```

If the file.encoding is UTF-8, the default charset will be UTF-8, a no-op value in Java 18.

```sh
java -Dfile.encoding=UTF-8
```

## Simple Web Server

This JEP provides a command-line tool, jwebserver to start a simple web server to serve static files, suitable for prototyping, ad-hoc coding, testing, and educational purpose, not for a production server.

By default, the jwebserver starts a simple web server at port 8000, and serves the static files from the current directory that start the command. Furthermore, it serves only HEAD and GET requests, and other requests will receive a 501 – Not Implemented or a 405 – Not Allowed response.


## Code Snippets in Java API Documentation

Before Java 18, we used {@code ...} to include the source code snippets in the documentation like this:

```java
/**
 * <pre>{@code
 *     int sum = widgets.stream()
 *                      .filter(w -> w.getColor() == RED)
 *                      .mapToInt(w -> w.getWeight())
 *                      .sum();
 * }</pre>
 */
```

The javadoc tool will render the body of the {@code ...} tag as HTML code. This method has some disadvantages, like the inability to do syntax highlighting, can’t to contain HTML markups, indentation issues, etc.

This JEP introduces the @snippet tag to allow developers to be more flexible in including source code snippets in the documentation.

Inline snippets
The generated documentation will render the body of the {@snippet ...} tag as HTML code. There is no need to escape special characters like < and>` with HTML entities.

```java
/**
* The following code shows how to use {@code Optional.isPresent}:
* {@snippet :
* if (v.isPresent()) {
*     System.out.println("v: " + v.get());
* }
* }
*/
```

External snippets
This includes the source code snippet from a separate file.

A comment from ShowExample.java links the source code snippets from a separate file ShowOptional.java.


```java
 public class ShowExample {
     /**
      * The following code shows how to use {@code Optional.isPresent}:
      * {@snippet file="ShowOptional.java" region="example"}
      */
     void test() {
       //...
     }
 }
```

Where ShowOptional.java is a file containing:

```java
public class ShowOptional {
    void show(Optional<String> v) {
        // @start region="example"
        if (v.isPresent()) {
            System.out.println("v: " + v.get());
        }
        // @end
    }
}
```

## Reimplement Core Reflection with Method Handles

The existing core reflection has three internal mechanisms for invoking methods and constructors. Adding new features to the core reflection may modify all three code paths. Which is costly.

- VM native methods
- Dynamically generated bytecode stubs
- Method handles

This JEP reimplements core reflection with method handles as the underlying reflective mechanism. There is no change to the java.lang.reflect API; solely an implementation change.

## Vector API (Third Incubator)

improves the Vector API performance and other enhancements in response to feedback.

History

- Java 16, JEP 338 introduced new Vector API as an incubating API.
- Java 17, JEP 414 enhanced the Vector API second incubator.

## Internet-Address Resolution SPI

By default, the java.net.InetAddress API uses the operating system’s built-in resolver to resolve host names to Internet Protocol (IP) addresses.

```sh
InetAddress ip = InetAddress.getByName("google.com");
```

This JEP redesign java.net.InetAddress API to use service loader to find the resolver instead of using the operating system’s built-in resolver.

```java
  private static InetAddressResolver loadResolver() {
      return ServiceLoader.load(InetAddressResolverProvider.class)
              .findFirst()
              .map(nsp -> nsp.get(builtinConfiguration()))
              .orElse(BUILTIN_RESOLVER);
  }
```

## Foreign Function & Memory API (Second Incubator)

This Foreign Function & Memory API allows the developer to access the code outside the JVM (foreign functions), data stored outside the JVM (off-heap data), and accessing memory not managed by the JVM (foreign memory).

This JEP improves the Foreign Function & Memory API and other enhancements in response to feedback.

## Pattern Matching for switch (Second Preview)

is the second preview of pattern matching for the switch, with the following enhancements since the first preview:

### Dominance checking of the same type.

Review the below switch pattern matching, every value that matches the String s also matches the CharSequence cs, which makes String s unreadable and will cause a compile-time error.

```java
  static void error (Object o){
        switch (o) {
            case CharSequence cs -> System.out.println("A sequence of length " + cs.length());
            case String s ->    // Error - pattern is dominated by previous pattern
                    System.out.println("A string: " + s);
            default -> {
                break;
            }
        }
    }
```

### Exhaustiveness of switch expressions and statements

The switch expression requires all possible values to be handled in the switch block, else prompts a compile-time error.

Review the below code:

```java
    static int coverage(Object o) {
        return switch (o) {         // Error - not exhaustive
            case String s  -> s.length();
            case Integer i -> i;
        };
    }
```

```
Output:

java: the switch expression does not cover all possible input values
```

The below code is fine because the default will handle all the possible types.

```java
    static int coverage(Object o) {
        return switch (o) {
            case String s  -> s.length();
            case Integer i -> i;
            default -> 0;
        };
    }
```

## Deprecate Finalization for Removal

The object finalization is unpredictable and dangerous; read this and this.

```java
  // deprecated since Java 9
  @Deprecated(since="9", forRemoval=true)
  protected void finalize() throws Throwable { }
```