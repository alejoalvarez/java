# Table of Contents

## JEP 350 Dynamic CDS Archives

Java 10 introduced JEP 310 Application Class-Data Sharing. This JEP simplifying the process of creating CDS archives.
  
This command creates a CDS archive file of a ```.jar```
  
 ```
 $ java -XX:ArchiveClassesAtExit=hello.jsa -cp hello.jar Hello
 ```

 
This command runs a .jar with an existing CDS archive.
  
```
$  bin/java -XX:SharedArchiveFile=hello.jsa -cp hello.jar Hello
```

The Class Data Sharing (CDS) improves startup performance by creating a class-data archive once and reusing it so that the JVM needs not to recreate it again.

More information: JEP 350: [Dynamic CDS Archives](https://openjdk.java.net/jeps/350)

## JEP 351 ZGC: Uncommit Unused Memory

Java 11 introduced the JEP 333: Z Garbage Collector (Experimental); it provides a short pause times when cleaning up heap memories. However, it didn’t return unused heap memory to the operating system, even when it was unused for a long time.

This JEP enhanced the ZGC by returning unused heap memory to the operating system.

More information: JEP 351 ZGC: [Uncommit Unused Memory](https://openjdk.java.net/jeps/351)

## JEP-353 Reimplement the Legacy Socket API

The underlying implementations of java.net.Socket and java.net.ServerSocket are ancient, dating back to JDK 1.0, a mix of legacy Java and C code that is hard to maintain and debug. This JEP introduces new underlying implementations for the Socket APIs, which is the default implementation in Java 13.

Before Java 13, it uses the PlainSocketImpl for the SocketImpl

```java
ServerSocket.java


public class ServerSocket implements java.io.Closeable {

    /**
     * The implementation of this Socket.
     */
    private SocketImpl impl;

}
```

Java 13 introduced a new **NioSocketImpl** class as a drop-in replacement for **PlainSocketImpl**. However, if something goes wrong, we can still switch back to the old implementation PlainSocketImpl by setting **jdk.net.usePlainSocketImpl** system property.

Review a simple Socket example.

```java

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JEP353 {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8888)){

            boolean running = true;
            while(running){

                Socket clientSocket = serverSocket.accept();
                //do something with clientSocket
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

More information: JEP-353: [Reimplement the Legacy Socket API](https://openjdk.java.net/jeps/353)

## JEP-354 Switch Expressions (Preview)

Java 12 introduced JEP 325 Switch expressions. This JEP dropped break value in favor of yield keyword to return a value from switch expressions.

P.S This is a preview language feature in Java 13

The traditional switch statement, we can return a value like this:

```java
private static String getNumber(int number) {
        String result = "";
        switch (number) {
            case 1:
            case 2:
                result = "one or two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
            case 5:
            case 6:
                result = "four or five or six";
                break;
            default:
                result = "unknown";
        }
        ;
        return result;
    }
```

In Java 12, we can use break to return a value from a switch.

```java
 private static String getNumberViaBreak(int number) {
      String result = switch (number) {
          case 1, 2:
              break "one or two";
          case 3:
              break "three";
          case 4, 5, 6:
              break "four or five or six";
          default:
              break "unknown";
      };
      return result;
  }
```

In Java 13, the above Java 12 value break is dropped in favor of yield keyword to return a value.

```java
private static String getNumberViaYield(int number) {
      return switch (number) {
          case 1, 2:
              yield "one or two";
          case 3:
              yield "three";
          case 4, 5, 6:
              yield "four or five or six";
          default:
              yield "unknown";
      };
  }
```

The rule labels or arrow or case L is still supported in Java 13.

```java
  private static String getNumberViaCaseL(int number) {
      return switch (number) {
          case 1, 2 -> "one or two";
          case 3 -> "three";
          case 4, 5, 6 -> "four or five or six";
          default -> "unknown";
      };
  }
```

Or like this, mixed the use of arrow syntax and yield.

```java
  private static String getNumberViaCaseL2(int number) {
      return switch (number) {
          case 1, 2 -> "one or two";
          case 3 -> "three";
          case 4, 5, 6 -> {
              int i = 0;
              i++;
              yield "four or five or six :" + 1;
          }
          default -> "unknown";
      };
  }
```

More information: JEP-354: [Switch Expressions (Preview)](https://openjdk.java.net/jeps/354)

## JEP-355 Text Blocks (Preview)

This JEP introduces a multi-line string literal, a text block, finally.

P.S This text blocks is a permanent feature in Java 15.

Before Java 13

```java
 String html ="<html>\n" +
              "   <body>\n" +
              "      <p>Hello, World</p>\n" +
              "   </body>\n" +
              "</html>\n";


 String json ="{\n" +
              "   \"name\":\"mkyong\",\n" +
              "   \"age\":38\n" +
              "}\n";
```
Now Java 13

```java
 String html =  """
                <html>
                    <body>
                        <p>Hello, World</p>
                    </body>
                </html>
                        """;

 String json = """
                {
                    "name":"mkyong",
                    "age":38
                }
                """;
  ```

More information: JEP-355: [Text Blocks (Preview)](https://openjdk.java.net/jeps/355)
