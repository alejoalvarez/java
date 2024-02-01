# Operators
Operators are used to perform operations on variables and values.

## Arithmetic
Arithmetic operators are used to perform common mathematical operations.

|Operator|Name|Description|Example|
|---|---|---|---|
|+|Addition|Adds two values|x + y|
|-|Substraction|subtracts two values|x - y|
|*|Multiplication|Multiplies two values|x * y|
|/|Division|Divide one vlue from another value|x / y|
|%|Modulus|Returns the division remainder|x % y|
|++|Increment|Increases the value of a variable by 1|++x|
|--|Decrement|Decreases the value of a variable by 1|--x|
|++|Increment|Increases the value of a variable by 1|x++|
|--|Decrement|Decreases the value of a variable by 1|x--|

## Assignment
Assignment operators are used to assign values to variables.

|Operator|Example|Equals|
|---|---|---|
|=|x=5|x=5|
|+=|x+=5|x= x + 5|
|-=|x-=5|x= x - 5|
|*=|x*=5|x= x * 5|
|/=|x/=5|x= x / 5|
|%=|x%=5|x= x % 5|
|&=|x&=5|x= x & 5|

## Relationals / Comparison
Comparison operators are used to compare two values:

|Operator|Name|Example|
|---|---|---|
|==|Equal to| x == y|
|!=|Distinct| x != y|
|>|Greater than| x > y|
|<|Less than| x < y|
|>=|Greater than or equal to| x >= y|
|<=|Less than or equal to| x <= y|

## instanceOf
<object> instanceOf <class> determines if an object belongs to a class

```java
    if (professor instanceOff InternalProfessor){
        // code block
    }else{
        // code block
    }
```

## Logicals
Logical operators are used to determine the logic between variables or values:

|Operator|Name|Description|Example|
|---|---|---|---|
|&&|AND - Logical and| Returns true if both statements are true| 	x < 5 &&  x < 10 |
|```|||```|OR -  Logical or| 	Returns true if one of the statements is true|x < 5 ```||``` x < 4|
|!| NOT - Logical not| 	Reverse the result, returns false if the result is true |!(x < 5 && x < 10)|

&& y || perform lazy operations 
- Op1 && Op2 => if Op1 is false Op2 is not evaluated
- Op1 || Op2 => if Op1 is false Op2 is not evaluated
& y | the two operators are always evaluated

example

```java
    (x > y) ?  x : y  /// x is IF, y is ELSE
```

## Bit level
```
>>, <<, >>>, &, |, ^, ~
```


## Examples

Unary operator (++, --)

```java
class Example{  
    public static void main(String args[]){  
        int x=15;  
        System.out.println(x++); //15 (16)  
        System.out.println(++x); //17  
        System.out.println(x--); //17 (16)  
        System.out.println(--x); //15

        int a = 10;  
        int b = 10;  
        System.out.println(a++ + ++a); //10+12=22  
        System.out.println(b++ + b++); //10+11=21    
    }
}
```

### Unary operator (~, !)

```java
class Example{  
    public static void main(String args[]){  
        int a = 10;  
        int b = -10;  
        boolean c = true;  
        boolean d = false;  
        System.out.println(~a); //-11 (minus of total positive value which starts from 0)  
        System.out.println(~b); //9 (positive of total minus, positive starts from 0)  
        System.out.println(!c);//false (opposite of boolean value)  
        System.out.println(!d);//true  
    }
}  
```

### Left shift operator
The Java left shift operator << is used to shift all of the bits in a value to the left side of a specified number of times.

```java
class Example{  
    public static void main(String args[]){  
        System.out.println(10<<2);//10*2^2=10*4=40  
        System.out.println(10<<3);//10*2^3=10*8=80  
        System.out.println(20<<2);//20*2^2=20*4=80  
        System.out.println(15<<4);//15*2^4=15*16=240  
    }
}  
```

### Right shift operator
The Java right shift operator >> is used to move left operands value to right by the number of bits specified by the right operand.

```java
class Example{  
    public static void main(String args[]){  
        System.out.println(10>>2);//10/2^2=10/4=2  
        System.out.println(20>>2);//20/2^2=20/4=5  
        System.out.println(20>>3);//20/2^3=20/8=2  
    }
}
```

### Comparison left and rigth shift

```java
class Example{  
public static void main(String args[]){  
    //For positive number, >> and >>> works same  
    System.out.println(20>>2);  //5
    System.out.println(20>>>2);  //5
    //For negative number, >>> changes parity bit (MSB) to 0  
    System.out.println(-20>>2);  // -5
    System.out.println(-20>>>2);  // 1073741819
}
}
```

### AND Operator (Logical && and Bitwise &)

The logical && operator doesn't check second condition if first condition is false. It checks second condition only if first one is true.

The bitwise & operator always checks both conditions whether first condition is true or false.

```java
class Example{  
    public static void main(String args[]){  
        int a=10;  
        int b=5;  
        int c=20;  
        System.out.println(a<b&&a<c);//false && true = false  
        System.out.println(a<b&a<c);//false & true = false  
    }
}  
```

### AND Operator (Logical && vs Bitwise & )

```java
class OperatorExample{  
    public static void main(String args[]){  
        int a=10;  
        int b=5;  
        int c=20;  
        System.out.println(a<b&&a++<c);//false && true = false  
        System.out.println(a);//10 because second condition is not checked  
        System.out.println(a<b&a++<c);//false && true = false  
        System.out.println(a);//11 because second condition is checked  
    }
} 
```

### OR Operator (Logical || and Bitwise | )
The logical || operator doesn't check second condition if first condition is true. It checks second condition only if first one is false.

The bitwise | operator always checks both conditions whether first condition is true or false.

```java
class OperatorExample{  
    public static void main(String args[]){  
        int a=10;  
        int b=5;  
        int c=20;  
        System.out.println(a>b||a<c);//true || true = true  
        System.out.println(a>b|a<c);//true | true = true  
        //|| vs |  
        System.out.println(a>b||a++<c);//true || true = true  
        System.out.println(a);//10 because second condition is not checked  
        System.out.println(a>b|a++<c);//true | true = true  
        System.out.println(a);//11 because second condition is checked  
    }
}  
```