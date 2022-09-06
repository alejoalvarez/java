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
import java.util.regex.Pattern;

public class PatternRegExp {

    public static void main(String[] args) {
        boolean match1 = Pattern.compile("a.e").matcher("ale").matches(); // . represent a single character
        System.out.println(match1);

        boolean match2 = Pattern.matches("Ja..", "Java"); // .. represent 2 characters
        System.out.println(match2);

        boolean match3 = Pattern.matches("Al...", "Alejo"); //... represent 3 characters
        System.out.println(match3);

        String str = "aaa";
        System.out.println("String match method: " + str.matches(".a"));
        System.out.println("Pattern matches method: " + Pattern.matches("a.a", str));
    }
}
```

**Output**
```
true
true
true
String match method: false
Pattern matches method: true
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
package regularexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherRegExp {

    public static void main(String[] args) {

        //Case Sensitive Searching
        Pattern pattern = Pattern.compile("Study");
        Matcher match = pattern.matcher("StudyJavaStudyAlejo");
        System.out.println("Case Sensitive Searching:");
        while (match.find()){     // Printing start and end indexes of the pattern in text
            System.out.println("Pattern found from " + match.start() + " to " + (match.end() - 1) );
        }

        //Case Insensitive Searching
        Pattern pattern1= Pattern.compile("al", Pattern.CASE_INSENSITIVE);
        Matcher match1 = pattern1.matcher("StudyJavaStudyAlejo");
        System.out.println("\nCase InSensitive Searching:");
        while (match1.find()) {     // Printing start and end indexes of the pattern in text
            System.out.println("Pattern found from " + match1.start() + " to " + (match1.end() - 1));
        }

        // Splitting the String
        String text = "Study@Alejo#Example&Of%Java";
        String delimiter = "\\W";
        Pattern pattern2 = Pattern.compile(delimiter, Pattern.CASE_INSENSITIVE);
        String[] result = pattern2.split(text);
        System.out.println("\nSplitting the String around special characters:");
        for (String temp: result) {
            System.out.println(temp);
        }

        // Replacing the String
        System.out.println("\nReplacing the Strings with other String:");
        String regex = "Python";
        String inputString = "StudyAlejo Example2 Tutorial. " + "It is a Example2 Tutorial";
        String replaceString = "Java";
        Pattern pattern3 = Pattern.compile(regex); // get a Pattern object
        Matcher matcher = pattern3.matcher(inputString); // get a matcher object

        System.out.println("Using replaceFirst() Method");
        inputString = matcher.replaceFirst( replaceString);
        System.out.println(inputString);

        System.out.println("\nUsing replaceAll() Method");
        inputString = matcher.replaceAll( replaceString);
        System.out.println(inputString);
    }
}
```

Output

```
Case Sensitive Searching:
Pattern found from 0 to 4
Pattern found from 9 to 13

Case InSensitive Searching:
Pattern found from 14 to 15

Splitting the String around special characters:
Study
Alejo
Example
Of
Java

Replacing the Strings with other String:
Using replaceFirst() Method
StudyAlejo Example2 Tutorial. It is a Example2 Tutorial

Using replaceAll() Method
StudyAlejo Example2 Tutorial. It is a Example2 Tutorial

```

### java.util.PatternSyntaxException class

This class throws an unchecked exception to indicate a syntax error in a regular-expression pattern.

**Methods**

| Method	| Description |
|---|---|
| String getDescription() | It is used to get the description of the error |
| int getIndex() | It is used to get the index of the error |
| String getMessage() | This method gives a multiple-line string, describing the syntax error along with its index. It also gives the erroneous regular-expression pattern and indicates the index or error within the pattern |
| String getPattern() | It is used to get the erroneous regular-expression pattern |



