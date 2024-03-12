# **Cloneable Interface In Java**

Cloning of objects means making a copy of the objects. Java supports object cloning using the “**Cloneable**” interface. The cloneable interface is a marker interface and is a part of the java.lang package.

When a class implements the Cloneable interface, then it implies that we can clone the objects of this class. The Object class of Java contains the ‘**clone**()’ method. So Cloneable interface implemented by a particular class authorizes the clone () method to make copies of class instances.

If a class does not implement a Cloneable interface and still invokes the clone () method, then the exception **CloneNotSupportedException** is thrown by the Java compiler.

Classes implementing the Cloneable interface should override the clone () method.

***So what is Object Cloning?***

Object cloning is a process using which we create an exact copy of the object using the clone () method of the Object class. For the clone () method to be overridden and invoked, the class needs to implement the Cloneable interface.

**The general syntax of the clone () method is given below:**

***protected** Object clone() **throws** CloneNotSupportedException*

The clone () method creates an exact copy of the object with less processing time than that taken for creating a new object using the new keyword.

**The below Java program demonstrates the use of the clone () method and the Cloneable interface.**

```java
class Student implements Cloneable{  
    int number;  
    String name;  
    
    Student(int number,String name){  
        this.number=number;  
        this.name=name;  
    }  
       
    public Object clone() throws CloneNotSupportedException {     
        return super.clone();  
    }  
}

class Main{
    public static void main(String args[]){  
    try{  
        Student student1 = new Student(101,"Alejo");  
        
        Student student2 = (Student) student1.clone();  //clone the s1 object
   
        System.out.println("Original Student object: " + student11.number + " " + student1.name);  
        System.out.println("Cloned Student object: " + student2.number + " " + student2.name);  
   
    }catch(CloneNotSupportedException c){}  
 }  
}
```

Output:
```
Original Student object: 101 Alejo
Cloned Student object: 101 Alejo
```

In this program, we have a Student class implementing the Cloneable interface. It also overrides the clone () method by calling the super.clone () method. In the main method we create a new Student object and then call the clone () method on this object that returns the new Student object.

## Clone Array In Java

Since Java arrays implement Cloneable interface by default, they need not be explicitly implemented. When the one-dimensional array is cloned, a deep copy of the array is generated. When a 2-dimensional array is cloned, then a shallow copy is made.

Making a shallow copy is the default behavior of the clone () method in Java. But most of the time we desire deep cloning. In deep cloning, we make a copy of the object member by member and create a clone that is independent of the original object. Any changes then made to the clone object will not reflect in the original object.

```java
class Main {     
    public static void main(String args[])   { 
        
        int intArray[] = {2,6,3,7,1,8};          
        int cloneArray[] = intArray.clone(); //invoke clone () method on intArray
                   
        System.out.println("Original intArray:");
        for (int i = 0; i < intArray.length; i++) { 
            System.out.print(intArray[i]+" "); 
        } 
        System.out.println();
         
        System.out.println("Cloned Array:");
        for (int i = 0; i < cloneArray.length; i++) { 
            System.out.print(cloneArray[i]+" "); 
        } 
        System.out.println("\n");         
    } 
}
```

Output
```
Original intArray: 2 6 3 7 1 8
Cloned Array 2 6 3 7 1 8
```

## Clone List In Java

```java
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 
   
class MyList implements Cloneable { 
   
    String name1; 
    String name2; 
       
    MyList(String name1, String name2) 
    { 
        this.name1 = name1; 
        this.name2 = name2; 
    } 
      
    @Override
    public String toString() 
    { 
        return "Hello " + name1 + "," + name2 + "\n" ; 
    } 
   
   // Overriding the clone method 
    @Override
    protected MyList clone() 
    { 
        return new MyList(name1 , name2); 
    } 
} 
   
class Main { 
    public static void main(String[] args) 
    { 
        
        List<MyList> original 
            = Arrays.asList( new MyList("Alejo","Juan"), 
                new MyList("Maria","Alvarez")); 
   
        // Create an empty list 
        List<MyList> cloned_list 
            = new ArrayList<MyList>(); 
   
        // Loop through the list and clone each element 
        for (MyList temp : original) 
            cloned_list.add(temp.clone()); 
        System.out.print(cloned_list); 
    } 
}
```