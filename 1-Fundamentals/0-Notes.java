
// This file won't compile... just for notes. //

// Structure of Java functions

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

HelloWorld // is a class, and also the filename;
main // is a method, the main method for an executable Java file (e.g. init)

// Class names are written in PascalCase
// Method names are lowerCamelCase, and usually verbs

public // is an access modifier. public means it's accessible from any other class or method in our project

static // means the method belongs to and is called from the class rather than from an instance of the class

void // indicates this method (the main() method) doesn't return anything

// 

public class Variables {
    public static void main(String args[]){

        int ourInt; // we can declare a variable without setting its value

        ourInt = 400; // we can assign a value to the variable later in our code

        double pi = 3.14159265; // we can also declare and assign on the same line

        boolean bool = true;

        char singleCharacter = 'A';
        
        String multipleCharacters = "ABC";
        
    }
}

