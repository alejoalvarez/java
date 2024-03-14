# Java Platform Module System (Project Jigsaw)

It is a new kind of Java programming component that can be used to collect Java code (classes and packages). The main goal of this project is to easily scale down application to small devices. In Java 9, JDK itself has divided into set of modules to make it more lightweight. It also allows us to develop modular applications.

Java Module System is a major change in Java 9 version. Java added this feature to collect Java packages and code into a single unit called module.

## Java 9 Module
Module is a collection of Java programs or softwares. To describe a module, a Java file module-info.java is required. This file also known as module descriptor and defines the following

- Module name
- What does it export
- What does it require

`Module Name`
It is a name of module and should follow the reverse-domain-pattern. Like we name packages, e.g. `com.co.alejo`

## How to create Java module
Creating Java module required the following steps.

- Create a directory structure
- Create a module declarator
- Java source code

## Create a Directory Structure

To create module, it is recommended to follow given directory structure, it is same as reverse-domain-pattern, we do to create packages / project-structure in Java.

The name of the directory containing a module's sources should be equal to the name of the module, e.g. `com.alejo.`

```
src
|___com.alejo
   |__com
   |   |___alejo
   |        |____Hello.java
   |__module-info.java
```

Create a file module-info.java, inside this file, declare a module by using module identifier and provide module name same as the directory name that contains it. In our case, our directory name is com.javatpoint.

```java
module com.alejo{  
  
}  
```

Leave module body empty, if it does not has any module dependency. Save this file inside src/com.alejo with module-info.java name.

## Java Source Code

Now, create a Java file to compile and execute module. In our example, we have a Hello.java file that contains the following code.

```java
class Main{  
    public static void main(String[] args){  
        System.out.println("Hello from the Java module");  
    }  
}
```

Save this file inside src/com.alejo/com/alejo/ with Hello.java name.


## Compile Java Module
To compile the module use the following command.

```sh
javac -d mods --module-source-path src/ --module com.alejo  
```

After compiling, it will create a new directory that contains the following structure.

```
mods/
 |_____com.alejo
    |___com
    |  |____alejo
    |    |___Hello.class
    |___module-info.class
```

Now, we have a compiled module that can be just run.


## Run Module
To run the compiled module, use the following command.

```sh
java --module-path mods/ --module com.javatpoint/com.javatpoint.Hello  
```
Result:
Hello from the Java module

Well, we have successfully created, compiled and executed Java module.

## Look inside compiled Module Descriptor

To see the compiled module descriptor use the following command.

```sh
javap mods/com.javatpoint/module-info.class  
```

This command will show the following code to the console.

```java
Compiled from "module-info.java"  
module com.alejo {  
  requires java.base;  
}  
```
See, we created an empty module but it contains a java.base module. Why? Because all Java modules are linked to java.base module and it is default module.


**List module**
```sh
java --list-modules
```
