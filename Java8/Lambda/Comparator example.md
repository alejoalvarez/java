# Java 8 Lambda: Comparator example #

<center>
<img src="https://alejoalvarez.github.io/Images/Java-Lambda/lambda1.png"></center>

In this example, we will show you how to use java 8 Lambda expression to write a **Comparator** to sort a list.

Classic **Comparator** example.

```java
 Comparator<Developer> byName = new Comparator<Developer>() {
        @Override
        public int compare(Developer o1, Developer o2) {
            return o1.getName().compareTo(o2.getName());
        }
};
```

Lambda expression equivalent.

```java
Comparator<Developer> byName = 
        (Developer o1, Developer o2)->o1.getName().compareTo(o2.getName());
```

## 1. Sort without lambda

Example to compare the **Developer** objects using their age. Normally, you use **Collections.sort** and pass an anonymous **Comparator** class like this:

```java
TestSorting.java

package com.alejo.lambda1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSorting {

    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }
        
        //sort by age
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    
        System.out.println("After Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("alejo", new BigDecimal("70000"), 33));
        result.add(new Developer("maria", new BigDecimal("80000"), 20));
        result.add(new Developer("juan", new BigDecimal("100000"), 10));
        result.add(new Developer("laura", new BigDecimal("170000"), 55));
        
        return result;
    }
}
```

```
Output >>>>>>

Before Sort
Developer [name=alejo, salary=70000, age=33]
Developer [name=maria, salary=80000, age=20]
Developer [name=juan, salary=100000, age=10]
Developer [name=laura, salary=170000, age=55]

After Sort
Developer [name=juan, salary=100000, age=10]
Developer [name=maria, salary=80000, age=20]
Developer [name=alejo, salary=70000, age=33]
Developer [name=laura, salary=170000, age=55]
```

When the sorting requirement is changed, you just pass in another new anonymos **Comparator** class:

```java
//sort by age
    Collections.sort(listDevs, new Comparator<Developer>() {
        @Override
        public int compare(Developer o1, Developer o2) {
            return o1.getAge() - o2.getAge();
        }
    });
    
    //sort by name	
    Collections.sort(listDevs, new Comparator<Developer>() {
        @Override
        public int compare(Developer o1, Developer o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });
                
    //sort by salary
    Collections.sort(listDevs, new Comparator<Developer>() {
        @Override
        public int compare(Developer o1, Developer o2) {
            return o1.getSalary().compareTo(o2.getSalary());
        }
    });
```

It works, but, do you think it is a bit weird to create a class just beacause you want to change a single line of code? 

## 2 Sort with Lambda

In Java 8, the **List** interface is supports the **sort** method directly, no need to use **Collection.sort** anumore.

```java
//List.sort() since Java 8
listDevs.sort(new Comparator<Developer>() {
    @Override
    public int compare(Developer o1, Developer o2) {
        return o2.getAge() - o1.getAge();
    }
});

```

Lambda expression example:

```java
TestSorting.java

package com.alejo.lambda1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestSorting {

    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();
        
        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }
        
        System.out.println("After Sort");
        
        //lambda here!
        listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());
    
        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer)->System.out.println(developer));
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("alejo", new BigDecimal("70000"), 33));
        result.add(new Developer("maria", new BigDecimal("80000"), 20));
        result.add(new Developer("juan", new BigDecimal("100000"), 10));
        result.add(new Developer("laura", new BigDecimal("170000"), 55));
        
        return result;

    }
    
}

```

```
Output >>>>

Before Sort
Developer [name=alejo, salary=70000, age=33]
Developer [name=maria, salary=80000, age=20]
Developer [name=juan, salary=100000, age=10]
Developer [name=laura, salary=170000, age=55]

After Sort
Developer [name=juan, salary=100000, age=10]
Developer [name=maria, salary=80000, age=20]
Developer [name=alejo, salary=70000, age=33]
Developer [name=laura, salary=170000, age=55]
```

## 3. More Lambda Examples

### Sort by age
```java
//sort by age
    Collections.sort(listDevs, new Comparator<Developer>() {
        @Override
        public int compare(Developer o1, Developer o2) {
            return o1.getAge() - o2.getAge();
        }
    });
    
    //lambda
    listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());
    
    //lambda, valid, parameter type is optional
    listDevs.sort((o1, o2)->o1.getAge()-o2.getAge());
```

###  Sort by name

```java
//sort by name
    Collections.sort(listDevs, new Comparator<Developer>() {
        @Override
        public int compare(Developer o1, Developer o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });
        
    //lambda
    listDevs.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));		
    
    //lambda
    listDevs.sort((o1, o2)->o1.getName().compareTo(o2.getName()));
```

### Sort by salary

```java
//sort by salary
    Collections.sort(listDevs, new Comparator<Developer>() {
        @Override
        public int compare(Developer o1, Developer o2) {
            return o1.getSalary().compareTo(o2.getSalary());
        }
    });				

    //lambda
    listDevs.sort((Developer o1, Developer o2)->o1.getSalary().compareTo(o2.getSalary()));
    
    //lambda
    listDevs.sort((o1, o2)->o1.getSalary().compareTo(o2.getSalary()));
```

