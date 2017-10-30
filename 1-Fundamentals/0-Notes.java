import java.math.BigInteger; // Some Object types must be imported
import java.util.ArrayList;

// This file won't compile... just for notes. //



// Structure of Java functions

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World"); // print line; semi-colons required!!!
    }
}

HelloWorld // is a class, and also the filename;
main // is a method, the main method for an executable Java file (e.g. init)

// Class names are written in PascalCase
// Method names are lowerCamelCase, and usually verbs

public // is an access modifier. public means it's accessible from any other class or method in our project

static // means the method belongs to and is invoked from the class rather than from an instance of the class

void // indicates this method (the main() method) doesn't need to return anything



// Examples of Variables

public class Variables {
    public static void main(String args[]){

        int ourInt; // we can declare a variable without setting its value

        ourInt = 400; // we can assign a value to the variable later in our code

        double pi = 3.14159265; // we can also declare and assign on the same line

        boolean hasChoices = true;

        char singleCharacter = 'A'; // chars require single quotes
        
        String multipleCharacters = "ABC"; // Strings require double quotes

        public static BigInteger
        
    }
}


// Primitive Data Types

int // holds integers, from around negative to positive 2 billion
long // for larger integers (than 2 billion!)
boolean // true or false
double // like floating point numbers... but better than float
// an example is price.. 59.99
char // char data type used to store a single char like '$' or 'A'


// Object types: notice these are capitalized... they are classes
// most of these need to be imported

String // represents a sequence of characters
BigInteger // represents an integer that can be any size at all
ArrayList // resizable array
HashMap // key value pairs (dicts)


// Type Casting
// When you specify a variable type, its type is an attribute of it
// But casting allows flexibility
// To cast down from bigger to smaller range, be aware of memory allocation

// Type	        Size in Bytes       Range
byte	        // 1 byte	        -128 to 127
short    	    // 2 bytes	        -32,768 to 32,767
int      	    // 4 bytes	        -2,147,483,648 to 2,147,483, 647
long	        // 8 bytes	        -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float       	// 4 bytes	        approximately ±3.40282347E+38F
double   	    // 8 bytes	        approximately ±1.79769313486231570E+308
char	        // 2 bytes	        0 to 65,536
boolean  	    // n/a	            true of false

// Explicit Casting: Declaring the type we want to convert to
class Casting {
    public static void main(String[] args) {
        
        // declaring a double, 'd'
        double d = 35.25;
        
        // casting down the double, 'd', into a int ('i')
        int i = (int) d; // creates an integer from the double, 'd'
        System.out.println(i); // output will be 35

        // if instead of i, we used a byte, and 'd' = 130, what would happen?
        d = 130;
        byte b = (byte) d; // this would not run since it is out of range!

    }
}

// Implicit Casting: Depending on context, Java will cast types for us
class Casting {
    public static void main(String[] args) {
        int i = 35;

        // casting integer into a float:
        float f = i; // no need to specify 'float' with 'i'

        // casting float into a string to concat
        System.out.println("The number is: " + f); // Java allows this
    }
}


// Importing
// When importing from outside of the current folder, need explicit import
// When importing from the same folder, no need to explicitly import

import java.util.Date;
java.util // is a package
Date // is a class

// Here we initialize a class
public class ImportDemo {
    public String getCurrentDate() { // no main method b/c we'll execute elsewhere
        // here, 'String' refers to what running the method should return
        
        // Use the date class to init a new date var
        Date today = new Date(); // to initialize an object, use 'new'
        return "Current date is: " + today;
    }
}

// In another file, ImportDemoTest.java, we can import and test our ImportDemo class
// Notice the constructor, main, is included here... only this file needs to be run
// It is a good practice to separate class info from testing/running info
// This allows us to modularize our code and reuse it across multiple programs
public class ImportDemoTest {
    public static void main(String[] args) {
        ImportDemo iD = new ImportDemo(); // iD is a new instance of ImportDemo
        String currentDate = iD.getCurrentDate(); // imported method invoked on iD object
        System.out.println(currentDate); // printing the current date
    }
}


