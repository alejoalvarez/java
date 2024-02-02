## Java Dates

Java does not have a built-in Date class, but we can import the ```java.time package``` to work with the date and time API. The package includes many date and time classes. For example:

| Class | Description |
|---|---|
| LocalDate | Represents a date (year, month, day (yyyy-MM-dd)) |
| LocalTime | Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns)) |
| LocalDateTime | Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns) |
| DateTimeFormatter	| Formatter for displaying and parsing date-time objects |


## Display Current Date

To display the current date, import the ```java.time.LocalDate``` class, and use its now() method:

Example:

```java
import java.time.LocalDate;

public class Main {
  
  public static void main(String[] args) {
    LocalDate myObj = LocalDate.now();
    System.out.println(myObj);
  }
}
```

The output will be:
```2021-03-18```


## Display Current Time

To display the current time (hour, minute, second, and nanoseconds), import the java.time.LocalTime class, and use its now() method:

Example:

```java
import java.time.LocalTime;

public class Main {
  
  public static void main(String[] args) {
    LocalTime myObj = LocalTime.now();
    System.out.println(myObj);
  }
}
```

The output will be:
```18:47:32.681964```

## Display Current Date and Time

To display the current date and time, import the java.time.LocalDateTime class, and use its now() method:

Example:
```java
import java.time.LocalDateTime;

public class Main {
  
  public static void main(String[] args) {
    LocalDateTime myObj = LocalDateTime.now();
    System.out.println(myObj);
  }
}
```

The output will be:
```2021-03-18T18:47:32.682613```


## Formatting Date and Time

The "T" in the example above is used to separate the date from the time. You can use the DateTimeFormatter class with the ofPattern()method in the same package to format or parse date-time objects. The following example will remove both the "T" and nanoseconds from the date-time:

Example:
```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  
  public static void main(String[] args) {
    LocalDateTime myDateObj = LocalDateTime.now();
    System.out.println("Before formatting: " + myDateObj);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
  }
}
```

The output will be:
```
Before Formatting: 2021-03-18T18:47:32.682694 
After Formatting: 18-03-2021 18:47:32
````