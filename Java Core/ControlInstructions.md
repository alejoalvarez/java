## Control instructions

**Conditional instructions:**

- if 
Syntax
```java 
    if (condition) //code block; 
```

- if/else 
Syntax
```java
    ìf (condition) {
        // code block, if the condition is true;
    } else {
        // code block, if the condition is false;
    }
```

- else if
Syntax
```java
    if (condition1) {
    // block of code to be executed if condition1 is true
    } else if (condition2) {
    // block of code to be executed if the condition1 is false and condition2 is true
    } else {
    // block of code to be executed if the condition1 is false and condition2 is false
}

- Ternary operator
Syntax
```java
variable = 	condition ? expressionTrue: expressionFalse
```


**Loops**

In programming languages, loops are used to execute a set of instructions/functions repeatedly when some conditions become true. There are three types of loops in Java.


- while
The while loop loops through a block of code as long as a specified condition is true:

Sintax
```java
    while (condition) {
    // code block to be executed
    }

    // Infinitive loop
    while (true) {
    // code block to be executed
    }
```
- do
The do/while loop is a variant of the while loop. This loop will execute the code block once, before checking if the condition is true, then it will repeat the loop as long as the condition is true

Syntax
```java
    do {
    // code block to be executed
    }   
    while (condition);

    //Infinitive loop
    do {
    // code block to be executed
    }   
    while (true);


```
- for
When you know exactly how many times you want to loop through a block of code, use the for loop instead of a while loop:

Syntax
```java
    for (instruction1 ; limit; instruction2){
        instructions;
    }

    // infinitive loop
    for(;;){  
    //code to be executed  
    }
```

- for-each
There is also a "for-each" loop, which is used exclusively to loop through elements in an array:

Syntax
```java
    for (type variableName : arrayName) {
    // code block to be executed
    }
```
example 
```java
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    for (String i : cars) {
    System.out.println(i);
    }
```

**Selection**

Use the switch statement to select one of many code blocks to be executed.

- switch/case
```java
    switch (expression){

    case x: 
        // code block
        break;
    case y:
        // code block
        break;
    default:
        // code block
}
```

This is how it works:

The ```switch``` expression is evaluated once.
The value of the expression is compared with the values of each case.
If there is a match, the associated block of code is executed.
The ```break``` and ```default``` keywords are optional

```break```: When Java reaches a break keyword, it breaks out of the switch block.
- This will stop the execution of more code and case testing inside the block
- When a match is found, and the job is done, it's time for a break. There is no need for more testing.

```default```: The default keyword specifies some code to run if there is no case match
Note that if the default statement is used as the last statement in a switch block, it does not need a break.
