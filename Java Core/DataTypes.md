## Data Types

- Primitive Type
They have no methods
They are not objects
They do not need an invocation to be created
short, int, char, boolean

- Object Type
Commonly called wrapper
With methods
They need an invocation to be created
Types of the standard library - String, it is for text chain others are (Scanner, TreeSet, ArrayList ...)
User-defined types, example (Car, Bus, People etc)
Array types - vector or matrix type elements, they are special objects that lack methods
Wrapper types, the same as primitive types but as objects (Byte, Short, Integer etc.)

Note: ```The difference between int and Integer is that Integer being a wrapper allows null```

<p align="center">
<img height="250" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/primitiveType.jpeg">
</p>

<p align="center">
<img height="250" src="https://github.com/alejoalvarez/Images/blob/trunk/Java/objectType.jpeg">
</p>

**Type casting**

Type casting is when you assign a value of one primitive data type to another type.

In Java, there are two types of casting:

Widening Casting (automatically) - converting a smaller type to a larger type size
byte -> short -> char -> int -> long -> float -> double

Narrowing Casting (manually) - converting a larger type to a smaller size type
double -> float -> long -> int -> char -> short -> byte