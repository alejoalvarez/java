# Files new methods

Java 11 added new methods in Files class for better file handling. These methods are:

- readString(Path path)
- writeString(Path path, CharSequence csq, OpenOption... options)
- writeString(Path path, CharSequence csq, Charset cs, OpenOption... options)

## Java Files readString() Method

This method is used to read all content from a file into a string. The method ensures that the file is closed when all content has been read. The syntax of the method is given below:

```java
public static String readString(Path path) throws IOException
```

Basic Example:

In this example, we are reading a file by using the readString() method that returns data in string form:

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {  
	public static void main(String[] args) throws IOException{
		try {
		Path path = Paths.get("abc.txt");
		String data = Files.readString(path);
		System.out.println(data);
		System.out.println(data.getClass().getName());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}        
}
```

```
Output:

Hello World.
java.lang.String
```

## Java Files writeString() Method

This method is used to write a string to a file. Characters are encoded into bytes using the UTF-8 charset. Files provide one more method that allows setting charset:

```java
public static Path writeString?(Path path, CharSequence csq, OpenOption... options) throws IOException

public static Path writeString?(Path path, CharSequence csq, Charset cs, OpenOption... options) throws IOException
```

Basic Example:

In this example, we are writing a string to file "abc.txt" by using the writeString() method and reading the written string using readString() method.

```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {  
	public static void main(String[] args) throws IOException{
		try {
		Path path = Paths.get("abc.txt");
		path = Files.writeString(path, "Welcome to Java!!");
		String data = Files.readString(path);
		System.out.println(data);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}        
}
```

```
Output:

Welcome to Java!!
```

## Another Example: Specify Charset

If we want to specify charset of charSequence during writing to file then you can use forName() method. See the example below:

```java
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {  
	public static void main(String[] args) throws IOException{
		try {
		Path path = Paths.get("abc.txt");
		path = Files.writeString(path, "Welcome to Java!!", Charset.forName("UTF-8"));
		String data = Files.readString(path);
		System.out.println(data);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}        
}
```

```
Output:

Welcome to Java!!
```