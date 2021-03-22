## Operators
Operators are used to perform operations on variables and values.

**Arithmetic**
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

**Assignment**
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

**Relationals / Comparison**
Comparison operators are used to compare two values:

|Operator|Name|Example|
|---|---|---|
|==|Equal to| x == y|
|!=|Distinct| x != y|
|>|Greater than| x > y|
|<|Less than| x < y|
|>=|Greater than or equal to| x >= y|
|<=|Less than or equal to| x <= y|

**instanceOf**
<object> instanceof <class> determines if an object belongs to a class

example
```java
    if (professor instanceOff InternalProfessor){
        // code block
    }else
    {
        code block
}
```

**Logicals**
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

**Bit level**
>>, <<, >>>, &, |, ^, ~