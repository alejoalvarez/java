# Regular Expressions

A regular expression is a group of characters that helps in matching the patterns in a String or a set of Strings, using a particular syntax of a pattern. Java provides Regular Expressions that are useful for defining patterns in a String which can ultimately be helpful in performing various operations on String/text like searching, processing, editing, pattern matching, manipulating, email and password validation, etc.

A regular expression is not language-specific but they slightly differ for each language. The regular expression in Java and Perl language are almost similar to each other and are very easy to learn.

A regular expression is also known as Regex in short. In Java, Regular Expressions are provided under the package java.util.regex, which is the part of standard Java (Java SE) since Java 1.4. The Java Regex is an API (Application Programming Interface) used to define a pattern for manipulating or searching Strings.


## Metacharacters of Java Regular Expressions

The Meta characters used in the regular expressions are:

| Meta Character	| Description |
|---|---|
|. | Any character (may or may not match terminator)|
|\d | Any digits – [ 0-9 ]|
|\D	| Any non-digit – [ ^0-9 ] (except 0 – 9)|
|\s	| Any whitespace character – [ \t \n \f \r \x0B ]|
|\S	| Any non-whitespace character – [ ^\s ]
|\w	| Any word character – [ a-z A-Z _0-9 ]
|\W| Any non-word character – [ ^\w ] |
|\b	| A word boundary|
|\B | A non-word boundary|

**Classes in Java Regex:**

| Class	| Description |
|---|---|
| util.regex.Pattern | Used to create or define patterns/regular expressions |
| util.regex.Matcher | Used to interpret the pattern and performs match operations against an input string|
| util.regex.PatternSyntaxException | Used to throw an exception if the syntax of a regular expression is incorrect|

**interface:**

| Interface	| Description |
|---|---|
| MatchResult | Used to find the result of a match operation for a regular expression |

## Classes in Java Regular Expressions

### java.util.Pattern class


The Pattern class is used to define or create regular expressions or patterns. This class is a compiled representation of regular expressions that can be used to define various types of patterns. There is no public constructor in Pattern class. We can use the public static method compile() of this class by passing regular expression as an argument which will create the pattern object after execution.

**Methods**

| Method	| Description |
|---|---|
| static Pattern compile(String regex) | This method compiles the specified regular expression into a pattern |
| static Pattern compile(String regex, int flags) | This method is similar to the above method but takes one more argument called flag and is used to compile the given regular expression into a pattern with the given flags |
| int flags() | This method has no parameters and returns the match flags of a pattern |
| Matcher matcher(CharSequence input) | It creates a matcher that will match the given input against this pattern |
| Matcher matcher(CharSequence input) | It creates a matcher that will match the given input against this pattern |
| static boolean matches(String regex, CharSequence input) | It is used to compile the given regular expression to match the given input String against it |
| String pattern() | This method is used to return the regular expression from which we compiled this pattern |
| static String quote(String s) | It is used to return a literal pattern String for the stated/input String |
| String[ ] split(CharSequence input) | It splits the given input sequence around matches of this pattern |
| String[ ] split(CharSequence input, int limit) |It is used to split the specified input sequence around matches of this pattern within a given limit |

Example
```java
import java.util.regex.*;

public class Main
{
  public static void main(String args[])
  {
    //Using compile() matches() and matcher() methods
    boolean match1=Pattern.compile("a.o").matcher("Alejo").matches();
    // . represents a single character
    System.out.println(match1);
    //Using boolean matches method
    boolean match2 = Pattern.matches("Alejo.", "Al");
    // .. represents 2 characters
    System.out.println(match2);
    // text "Java" match pattern "Ja.."
    System.out.println (Pattern.matches("Ja..", "Java"));
    String str = "aaa";
    System.out.println("Using the String matches method: "+str.matches(".a"));
    System.out.println("Using Pattern matches method: "+Pattern.matches("a.a", str));
  }
}

//RESULT
true
true
true
false
Using the String matches method: true
Using Pattern matches method: true
```

### java.util.Matcher class

The object of Matcher class is an engine which is used to perform match operations of a given regular expression against an input string for multiple times. It finds for multiple occurrences of the regular expressions in the input text/string. Like the Pattern class, Matcher too has no public constructors. You can obtain an object of Matcher class from any object of Pattern class by invoking the matcher() method.

**Methods**

| Method	| Description |
|---|---|
| int start() | It is used to get the start index of the last character which is matched using find() method |
| int end() | It is used to get the end index of the last character which is matched using find() method |
| boolean find() | It is used to find multiple occurrences of the input sequence that matches the pattern |
| boolean find(int start) | It attempts to find the occurrences of the input sequence that matches the pattern, starting at the specified index |
| String group() | This method returns the input subsequence matched by the previous match |
| int groupCount() | It is used to return the total number of matched subsequence in this matcher’s pattern |
| boolean matches() | It attempts to match the entire text against the pattern |
| String replaceFirst(String Replacement) | Replaces the first subsequence of the input sequence that matches the pattern with the specified replacement string |
| String replaceAll(String Replacement) |Replaces every subsequence of the input sequence that matches the pattern with the specified replacement string |



Example

```java
import java.util.regex.*;

public class Main
{
  public static void main(String args[])
  {
    //Case Sensitive Searching
    // Creating a pattern "Study" to be searched
    Pattern pattern = Pattern.compile("Study");

    // Searching above pattern in "StudyJavaStudyAlejo"
    Matcher match = pattern.matcher("StudyJavaStudyAlejo");

    // Printing start and end indexes of the pattern in text
    System.out.println("Case Sensitive Searching:");
    while (match.find())

      System.out.println("Pattern found from " + match.start() +
          " to " + (match.end()-1));

    //Case Insensitive Searching
    Pattern pattern1= Pattern.compile("al*",       Pattern.CASE_INSENSITIVE);
    // Searching above pattern in "StudyJavaStudyAlejo"
    Matcher match1 = pattern1.matcher("StudyJavaStudyAlejo");
    System.out.println("\nCase InSensitive Searching:");
    // Printing start and end indexes of the pattern in text
    while (match1.find())
      System.out.println("Pattern found from " + match1.start() +
          " to " + (match1.end()-1));

    // Splitting the String

    String text = "Study@Alejo#Example&Of%Java";
    String delimiter = "\\W";
    Pattern pattern2 = Pattern.compile(delimiter, Pattern.CASE_INSENSITIVE);

    String[] result = pattern2.split(text);
    System.out.println("\nSplitting the String around special characters:");
    for (String temp: result)
      System.out.println(temp);

    // Replacing the String
    System.out.println("\nReplacing the Strings with other String:");
    String regex = "Python";
    String inputString = "StudyAlejo Example2 Tutorial. " + "It is a Example2 Tutorial";
    String replaceString = "Java";

    // get a Pttern object
    Pattern pattern3 = Pattern.compile(regex);

    // get a matcher object
    Matcher m = pattern3.matcher(inputString);

    System.out.println("Using replaceFirst() Method");
    inputString = m.replaceFirst( replaceString);
    System.out.println(inputString);

    System.out.println("\nUsing replaceAll() Method");
    inputString = m.replaceAll( replaceString);
    System.out.println(inputString);
  }
}

//RESULT

```

### java.util.PatternSyntaxException class

This class throws an unchecked exception to indicate a syntax error in a regular-expression pattern.

**Methods**

| Method	| Description |
|---|---|
| String getDescription() | It is used to get the description of the error |
| int getIndex() | It is used to get the index of the error |
| String getPattern() | It is used to get the erroneous regular-expression pattern |

