# Exeptions
Tthere are two types of exceptions – **checked** and **unchecked** exception :

**Checked** – Extends ```java.lang.Exception```, for recoverable condition, try-catch the exception explicitly, compile error.
**Unchecked** – Extends ```java.lang.RuntimeException```, for unrecoverable condition, like programming errors, no need try-catch, runtime error.


## Custom Checked Exception

Some popular checked exception : IOException, FileNotFoundException

If the client is able to recover from the exception, make it a checked exception. To create a custom checked exception, extends java.lang.Exception

```java
public class NameNotFoundException extends Exception {

    public NameNotFoundException(String message) {
        super(message);
    }
}
```

For checked exception, you need to try and catch the exception.

```java
import com.mkyong.examples.exception.NameNotFoundException;

public class CustomerService {

    public Customer findByName(String name) throws NameNotFoundException {

        if ("".equals(name)) {
            throw new NameNotFoundException("Name is empty!");
        }
        return new Customer(name);
    }

    public static void main(String[] args) {
        CustomerService obj = new CustomerService();

        try {
            Customer cus = obj.findByName("");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

## Custom unchecked Exception

Some popular unchecked exception : NullPointerException, IndexOutOfBoundsException, IllegalArgumentException

If the client cannot do anything to recover from the exception, make it an unchecked exception. To create a custom unchecked exception, extends java.lang.RuntimeException

```java
public class ListTooLargeException extends RuntimeException{

    public ListTooLargeException(String message) {
        super(message);
    }
}
```

For unchecked exception, try and catch the exception is optional.

```java
import com.co.alejo.examples.exception.ListTooLargeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerService {

    public void analyze(List<String> data) {

        if (data.size() > 50) {
            //runtime exception
            throw new ListTooLargeException("List can't exceed 50 items!");
        }
        //...
    }

    public static void main(String[] args) {

        CustomerService obj = new CustomerService();

        //create 100 size
        List<String> data = new ArrayList<>(Collections.nCopies(100, "mkyong"));

        obj.analyze(data);
    }
}
```


