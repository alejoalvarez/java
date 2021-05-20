# Gson - parse to Json

It is a Java API developed by google that is used to convert Java objects to JSON (serialization) and JSON to Java objects (deserialization)

This library structures the JSON as follows:

**JsonElement**: This class represents an object in the JSON that can be one of the following 4 types:
- **JsonObject**: This class represents an object in the JSON, that is, a set of key-value pairs where the keys are strings and the values are another type of JsonElement
- **JsonArray**: This class represents an array in the JSON, an array is a list of JsonElement each of which can be a different type. This is an ordered list, so the order in which the items are added is preserved
- **JsonPrimitive**: This class represents a primitive data type or simple data object (String, Integer, Double, etc.)
JsonNull: Represents a null object
   
<p align="center">
<img height="270" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/gson.png">
</p>

[See an example](https://github.com/alejoalvarez/Java-Exercises/blob/main/Exercise-JSON/Gson/exercise3.md)

Gson provide simple **toJson()** and **fromJson()** methods to convert Java objects to / from JSON.

```toJson()``` – Java object to JSON

```java
Gson gson = new Gson();

// 1. Java object to JSON file
gson.toJson(obj, new FileWriter("C:\\fileName.json"));

// 2. Java object to JSON string
String json = gson.toJson(obj);
```

```fromJson()``` – JSON to Java object

```java
Gson gson = new Gson();
    
// 1. JSON file to Java object
Object object = gson.fromJson(new FileReader("C:\\fileName.json"), Object.class);

// 2. JSON string to Java object
String json = "{'name' : 'alejo'}";
Object object = gson.fromJson(json, Staff.class);
```

Java Object

```java

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Staff {

    private String name;
    private int age;
    private String[] position;              // array
    private List<String> skills;            // list
    private Map<String, BigDecimal> salary; // map

    //getters and setters
}
```

## Java Objects to JSON

In Gson, we can use **gson.toJson()** to convert Java objects to JSON.

```java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GsonExample1 {

    public static void main(String[] args) {

        // pretty print
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Staff staff = createStaffObject();

        // Java objects to String
        String json = gson.toJson(staff);

        //System.out.println(json);

        // Java objects to File
        try (FileWriter writer = new FileWriter("c:\\test\\staff.json")) {
            gson.toJson(staff, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Staff createStaffObject() {

        Staff staff = new Staff();

        staff.setName("alejo");
        staff.setAge(123);
        staff.setPosition(new String[]{"Developer", "Student"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2013", new BigDecimal(13000));
            put("2016", new BigDecimal(16000));
            put("2021", new BigDecimal(21000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node"));

        return staff;
    }
}
```

```json
Output>>>
---------
{
  "name": "alejo",
  "age": 123,
  "position": [
    "Developer",
    "Student"
  ],
  "skills": [
    "java",
    "python",
    "node"
  ],
  "salary": {
    "2013": 13000,
    "2016": 16000,
    "2021": 21000
  }
}
```

## JSON to Java Objects

In Gson, we can use **gson.fromJson** to convert JSON back to Java objects.

```java
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GsonExample2 {

    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("c:\\test\\staff.json")) {

            // Convert JSON File to Java Object
            Staff staff = gson.fromJson(reader, Staff.class);
            
            // print staff 
            System.out.println(staff);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
```java
Output >>>
---------
Staff{name='alejo', age=123, position=[Developer, Student], skills=[java, python, node], salary={2021=21000, 2016=16000, 2013=13000}}
```

## Exclude fields

In Gson, there are many ways to exclude certain fields.

By default, **transient** and **static** fields will be excluded. We can override the default by excludeFieldsWithModifiers

If we want to exclude static fields only.

```java
import java.lang.reflect.Modifier;

    Gson gson = new GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.STATIC)
            .create();

```
If we want to exclude transient and static fields, default.

```java
import java.lang.reflect.Modifier;

    Gson gson = new GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT)
            .create();
```
In this configuration, static and transient fields will be included.

```java
  Gson gson = new GsonBuilder()
            .excludeFieldsWithModifiers()
            .create();
```

Exclude fields by **@Expose**

The @Expose define which fields to be excluded from serialization and deserialization to JSON. To use @Expose, we need to create Gson object like this:

```java
Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
```

If .excludeFieldsWithoutExposeAnnotation() mode is enabled, all fields without @Expose will be excluded. For example,

```java
import com.google.gson.annotations.Expose;

public class Staff {

    @Expose(serialize = true, deserialize = true)
    private String name;
    @Expose
    private int age;
    @Expose(serialize = false, deserialize = true)
    
    private String[] position;              
    private List<String> skills;            
    private Map<String, BigDecimal> salary;
}
```
If convert above Java object to JSON, the output will be like this

```java
{
  "name": "alejo",
  "age": 123
}
```

Exclude fields by ExclusionStrategies, annotation, type, field name and etc. Gson is flexible.

A custom annotation @ExcludeField

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExcludeField {
}
```

A ExclusionStrategy to define what fields should be excluded or skipped.

```java
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CustomExclusionStrategy implements ExclusionStrategy {

    private final Class<?> typeToSkip;

    public CustomExclusionStrategy(Class<?> typeToSkip) {
        this.typeToSkip = typeToSkip;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {

        // if field name 'salary`, skip
        if ("salary".equals(f.getName())) {
            return true;
        }

        // if found @ExcludeField, skip
        if (f.getAnnotation(ExcludeField.class) != null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz == typeToSkip);
    }
}
```

Review the staff object again.

```java
public class Staff {

    private String name;
    private int age;
    @ExcludeField
    private String[] position;
    private List<String> skills;
    private Map<String, BigDecimal> salary;
}
```

Enable the ExclusionStrategy mode.

```java
Gson gson = new GsonBuilder()
        .setExclusionStrategies(new CustomExclusionStrategy(List.class)) // exclude all List fields.
        .create();
```

Output, this example, field name salary, @ExcludeField fields and List type fields will be excluded.

```
{"name":"alejo","age":123}
```

## Null Object support

null object fields are ignored.


```java
import com.google.gson.Gson;

public class GsonExample5 {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Staff staff = createStaffObject();
        
        String json = gson.toJson(staff);

        System.out.println(json);
    }

    private static Staff createStaffObject() {

        Staff staff = new Staff();

        staff.setName("alejo");
        staff.setAge(123);
   
        return staff;
    }
}
```

```
Output >>>>
----------

{"name":"alejo","age":123}
```

To display the null value.

```java
    Gson gson = new GsonBuilder().serializeNulls().create();
```

```java
{"name":"alejo","age":123,"position":null,"skills":null,"salary":null}

```
