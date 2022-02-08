package temp;
/*
Internally, printf() uses the java.util.Formatter class to parse the format string and generate the output.

https://www.educative.io/edpresso/how-to-use-the-printf-function-in-java
Syntax:
System.out.printf(format, arguments);
System.out.printf(locale, format, arguments);

We specify the formatting rules using the format parameter. Rules start with the % character.
Format specifiers include flags, width, precision, and conversion characters in this sequence:

%[flags][width][.precision]conversion-character
- Specifiers in the brackets are optional.


s – formats strings
d – formats decimal integers
f – formats the floating-point numbers
t – formats date/time values
 */

import java.util.*;

public class PrintfTest {
    public static void main (String args[]){
        System.out.println("%[flags][width][.precision]conversion-character\n");
        testDate();
        testString();
    }

    public static void testDate(){
        //Locale if not null the object is formatted according to the norms of the specified region
        Date data = new Date();
        System.out.printf(Locale.FRANCE, "Printing current data and time: %tc", data);
    }
    public  static void testString(){
        String data = "Hello world";
        System.out.printf("Printing in upper case %S%n", data);

        String test ="hello";
        String test1="bye";
        //System.out.printf(format, arguments);
        System.out.printf("%S%n",test); //toUpperCase() = %S
        System.out.printf("%20s%n",test); //width
        System.out.printf("%5.3s%n",test); //%x.ys syntax ; first number x=padding; y=number of chars

    }
}
