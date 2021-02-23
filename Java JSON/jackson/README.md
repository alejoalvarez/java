# Parse to JSON

Jackson provide ```writeValue()``` and ```readValue()``` methods to convert Java objects to / from JSON.

**mapper.writeValue** – Java Objects to JSON

```java

ObjectMapper mapper = new ObjectMapper();

// Java object to JSON file
mapper.writeValue(new File("c:\\test\\staff.json"), new Staff());

// Java object to JSON string, default compact-print
String jsonString = mapper.writeValueAsString(new Staff());

// pretty-print
String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Staff());
```
**mapper.readValue** – JSON to Java Objects

```java
ObjectMapper mapper = new ObjectMapper();

//JSON file to Java object
Staff obj = mapper.readValue(new File("c:\\test\\staff.json"), Staff.class);

//JSON URL to Java object
Staff obj = mapper.readValue(new URL("http://some-domains/api/staff.json"), Staff.class);

//JSON string to Java Object
Staff obj = mapper.readValue("{'name' : 'mkyong'}", Staff.class);
```

## Example 1

Java Objects to JSON

```java
public class Staff {

    private String name;
    private int age;
    private String[] position;              //  Array
    private List<String> skills;            //  List
    private Map<String, BigDecimal> salary; //  Map

    // getters , setters, some boring stuff
}
```

```java
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JavaObjectToJSON {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Staff staff = createStaff();

        try {

            // Java objects to JSON file
            mapper.writeValue(new File("c:\\test\\file.json"), staff);

            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(staff);

            System.out.println(jsonString);

            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);

            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Staff createStaff() {

        Staff staff = new Staff();

        staff.setName("alejo");
        staff.setAge(123);
        staff.setPosition(new String[]{"Developer", "Student"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2013", new BigDecimal(130000));
            put("2016", new BigDecimal(160000));
            put("2021", new BigDecimal(210000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node"));
        return staff;
    }
}
```

## JSON to Java Object

```java
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToJavaObject {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            // JSON file to Java object
            Staff staff = mapper.readValue(new File("c:\\test\\staff.json"), Staff.class);

            // JSON string to Java object
            String jsonInString = "{\"name\":\"alejo\",\"age\":123,\"skills\":[\"java\",\"python\"]}";
            Staff staff2 = mapper.readValue(jsonInString, Staff.class);

            // compact print
            System.out.println(staff2);

            // pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

            System.out.println(prettyStaff1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## @JsonProperty - JSON Field Naming

Normal
```java
public class Staff {

    private String name;
    private int age;
}
```

```
Output >>>

{"name":"example1", "age":123}
```

with @JsonProperty we can change the property

```java
public class Staff {

    @JsonProperty("custom_name")
    private String name;
    private int age;
}
```

```
Output >>>

{"custom_name":"example2", "age":123}
```

## @JsonInclude - Ignore null fields

Jackson by default include null fields

```
{
  "name" : "example",
  "age" : 123,
  "position" : null,
  "skills" : null,
  "salary" : null
}
```

### @JsonInclude on class level

```java
import com.fasterxml.jackson.annotation.JsonInclude;
                                        
@JsonInclude(JsonInclude.Include.NON_NULL) 	//  ignore all null fields
public class Staff {

    private String name;
    private int age;
    private String[] position;              
    private List<String> skills;           
    private Map<String, BigDecimal> salary; 
    //...
}
```

### @JsonInclude on fields level.

```java
import com.fasterxml.jackson.annotation.JsonInclude;

public class Staff {

    private String name;
    private int age;
    
    @JsonInclude(JsonInclude.Include.NON_NULL) //ignore null field on this property only
    private String[] position;              
    
    private List<String> skills;           
    
    private Map<String, BigDecimal> salary;
}
```

### JsonInclude globally

```java
ObjectMapper mapper = new ObjectMapper();

// ignore all null fields globally
mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
```

## @JsonView

```java
public class CompanyViews {

    public static class Normal{};

    public static class Manager extends Normal{};
}
```

Normal view only displays name and age, Manager view is able to display all.

```java
import com.fasterxml.jackson.annotation.JsonView;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Staff {

    @JsonView(CompanyViews.Normal.class)
    private String name;

    @JsonView(CompanyViews.Normal.class)
    private int age;

    @JsonView(CompanyViews.Manager.class)
    private String[] position;

    @JsonView(CompanyViews.Manager.class)
    private List<String> skills;

    @JsonView(CompanyViews.Manager.class)
    private Map<String, BigDecimal> salary;
}
```

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JacksonExample {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Staff staff = createStaff();

        try {

            // to enable pretty print
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // normal
            String normalView = mapper
                .writerWithView(CompanyViews.Normal.class)
                .writeValueAsString(staff);

            System.out.format("Normal views\n%s\n", normalView);

            // manager
            String managerView = mapper
                .writerWithView(CompanyViews.Manager.class)
                .writeValueAsString(staff);

            System.out.format("Manager views\n%s\n", managerView);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Staff createStaff() {

        Staff staff = new Staff();

        staff.setName("alejo");
        staff.setAge(123);
        staff.setPosition(new String[]{"Developer", "Student"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2013", new BigDecimal(130000));
            put("2016", new BigDecimal(160000));
            put("2021", new BigDecimal(210000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node"));

        return staff;
    }
}
```

```
Output >>>

Normal views
{
  "name" : "alejo",
  "age" : 123
}

Manager views
{
  "name" : "alejo",
  "age" : 123,
  "position" : [ "Developer", "Student" ],
  "skills" : [ "java", "python", "node" ],
  "salary" : {
    "2013" : 130000,
    "2016" : 160000,
    "2021" : 210000
  }
}
```

## @JsonIgnore and @JsonIngnoreProperties

By default, Jackson includes all the fields, even static or transient fields.


* @JsonIgnore to ignore fields on field level.

```java
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Staff {

    private String name;
    private int age;
    private String[] position;
    
    @JsonIgnore
    private List<String> skills;
    
    @JsonIgnore
    private Map<String, BigDecimal> salary;
}
```

```
Output >>>

{
  "name" : "alejo",
  "age" : 28,
  "position" : [ "Developer", "Student" ]
}
```

* @JsonIgnoreProperties to ignore fields on class level.

```java
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"salary", "position"})
public class Staff {

    private String name;
    private int age;
    private String[] position;
    private List<String> skills;
    private Map<String, BigDecimal> salary;
}
```

```
Output >>>

{
  "name" : "alejo",
  "age" : 123,
  "skills" : [ "java", "python", "node" ]
}
```

### Convert JSON array String to List

```java
    String json = "[{\"name\":\"alejo\", \"age\":123}, {\"name\":\"alejo2\", \"age\":123}]";

    List<Staff> list = Arrays.asList(mapper.readValue(json, Staff[].class));
    
    // or like this:
    // List<Staff> list = mapper.readValue(json, new TypeReference<List<Staff>>(){});
```


### Convert JSON string to Map 

```java
String json = "{\"name\":\"alejo\", \"age\":\"123\"}";
            
    Map<String, String> map = mapper.readValue(json, Map.class);
    
    // or like this:
    //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});

    map.forEach((k, v) -> System.out.format("[key]:%s \t[value]:%s\n", k, v));
```

```
Output >>>

[key]:name 	[value]:alejo
[key]:age 	[value]:123
```