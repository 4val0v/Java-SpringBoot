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


// Strings: commonly used methods

// Length
public class StringDemo {
    public static void main(String[] args) {
       String ninja = "Coding Dojo";
       int length = ninja.length();
       System.out.println( "Length is : " + length ); // 11
    }
}

// Concatenate
String string1 = "My name is ";
String string2 = "Michael";
String string3 = string1.concat(string2);
System.out.println(string3);
// will output My name is Michael
// you can also use the + sign:
"Welcome," + " ninja"; // displays "Welcome, ninja"

// Format (another way to concat strings)
String ninja = String.format("Hi %s, you owe me $%.2f", "Jack", 25.);
System.out.println(ninja); // prints "Hi Jack, you owe me $25.00"
// %s is expecting a string
// %.2f is expecting a float data type. The value 2 will place two values to right of the decimal point

// IndexOf: Searches left-to-right inside the given string for a "target" string. The indexOf() method returns the index number where the target string is first found, or -1 if the target is not found
String ninja = "Welcome to Coding Dojo!";
int a = ninja.indexOf("Coding"); // a is 11
int b = ninja.indexOf("co"); // b is 3
int c = ninja.indexOf("pizza"); // c is -1, "pizza" is not found


// Conditionals

// IF
if(defenderGuarding == true) {
    System.out.println("Pass The Ball");
} else if(closeToBasket == true) {
    System.out.println("Shoot The Ball");
} else {
    System.out.println("Dribble The Ball");
}


// Methods
// In Java, functions are always "methods"

// Method declaration:
public void fooBar(int someNumber, String someString) {

public // is the access level (for now, use this always)
void // is the return type
fooBar // is the name
int someNumber // a parameter variable
String someString // another parameter variable

// Method signature
fooBar(int, String) // a "signature" includes name and parameter type

// Overloading methods
// With a method signature, we can call two methods the same name
public String fizzBuzz(int number) {
public String fizzBuzz(String number, int numberTwo) {
// we might have the following two methods in the same class
// which code would be invoked when we call the fizzBuzz method? It depends on the argument type and the method signature! Due to Java's type system, if we try to call fizzBuzz with a string and int, it will know that we are trying to invoke the fizzBuzz method with the signature fizzBuzz(String, int).


// Arrays
// In Java, LENGTH has a fixed size after initialization

// Declaration, initialization, and adding in separate steps
int[] myArray;
myArray = new int[5];    // Initialization (5 is length)
myArray[0] = 4;
myArray[1] = 8;
myArray[2] = 8;
myArray[3] = 5;
myArray[4] = 9;

// All at once; length determined by number of elements
int[] myArray = {4, 8, 8, 5, 9};


// ArrayList
// When you want a resizable array, use the ArrayList class
import java.util.ArrayList;
ArrayList<Integer> myArray = new ArrayList<Integer>();
// <Integer> tells our ArrayList the data types it can hold

// Basic ArrayList methods
myArray.add(10);
int num = myArray.get(0); // get the int at this index
myArray.size(); // size of the array ('size' for ArrayList)


// While loop
int i = 0;
while(i < 7)
{
    System.out.println("foo");
    i++;
}

// For loop
for (int i = 0; i < 7; i++){
    System.out.println("bar");
}

// Looping over an ArrayList
for (int i = 0; i < dynamicArray.size(); i++){
    String name = dynamicArray.get(i);
    System.out.println("hello " + name);
    // other operations using name
}

// Enhanced For loop over an ArrayList
for (String name : dynamicArray){ // element container : collection
    System.out.println("hello " + name);
}


// HashMap (key-value pairs)

// Importing and creating
import java.util.HashMap;
HashMap<String, String> userMap = new HashMap<>();

// Storing
userMap.put("nninja@codingdojo.com", "Nancy Ninja");
userMap.put("ssamurai@codingdojo.com", "Sam Samurai");

// Getting
String name = userMap.get("nninja@codingdojo.com");

// Printing keys and values

for(String key : trackList.keySet()) {
    System.out.println(key + " : " + trackList.get(key));
}


// Try/Catch
// In exceptional situations, use a contingency plan

class DeliverMessage{
    public static void main(String[] args){
        UnreliableFriend friend = new UnreliableFriend();
        try{
            friend.deliverMessage();
            System.out.println("The message was delivered!");
        } catch (OutOfGasException e){
            System.out.println("Hey, uh, so, I ran out of gas..");
            // back-up plan here.
        }
    }
}


// OOP

public class Greeting {

    // In this example, a private method is created to determine the logic that will be run in the other two public methods.
    private String createGreeting(String toBeGreeted){
        return "Hello " + toBeGreeted;
    }
    public String greet(){
        return createGreeting("World");
    }
    public String greet(String firstName, String lastName){
        return createGreeting(firstName + " " + lastName)
    }
    // Without the private method, we would need to duplicate instructions in the public methods. What if we want to change the greeting from "Hello" to "What's up"? We can efficiently do so by just changing the private method.
}


// Structures of Methods:

// Modifiers:
private // only the class in which it is declared can see and access this method
protected // subclasses can use this method
public // every class has access to this method

// Return type: String, int, double, boolean, void, etc.

// Method name (usually as verbs)

// Parameter list

// Method body (what goes inside the curly braces)

// Method type:
static // defines method as class method that can be invoked without creating an object
// if it makes sense to call a certain method even if the object has not yet been constructed, then it should be static.


// Types of variables:
// Member variables: object attributes or fields
// Local variables: variables in method/code blocks
// Parameter variables (those declared in the method)


// Getters and Setters
class Vehicle {
    private int numberOfWheels;
    private String color;
    public int getNumberOfWheels() { // getter
        return numberOfWheels;
    }
    public void setNumberOfWheels(int number) { // setter
        numberOfWheels = number;
    }
}

class VehicleTest {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle();

        bike.setNumberOfWheels(2); // invoke set method
        bike.setColor("red");
        int bikeWheels = bike.getNumberOfWheels();
        String bikeColor = bike.getColor(); // invoke get

        System.out.println("Bike object - Wheels: " + bikeWheels + ", Color: " + bikeColor);
    }
}


// Object Superclass
// https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html
// Since all objects are descendants of the Object class, we can use all the methods inherited from the Object class
// Some methods include:
.getClass() // returns a Class object that represents the object's current class; you can build off this by using the following methods:
    .getSimpleName() // 
    .getSuperclass() //
    .getInterfaces() //
.equals() // used for comparing two objects and returns bool
.toString() // returns a string representation; can override this


class Person {
    private int age;
    private String name;

    public Person(int ageParam, String nameParam) {
        this.age = ageParam;
        this.name = nameParam;
    }

    public void objectMethods(Person anotherObject) {
        System.out.println("Class name: " + this.getClass().getSimpleName());
        System.out.println("toString: " + this.toString());
        System.out.println("Equals: " + this.equals(anotherObject));
    }
}


// Superclass, subclass, extending

// Human is an extension of the Mammal class:
public class Human extends Mammal{    
} // Human is a subtype of its superclass, Mammal
// However, no easy access to private member variables

class Mammal{
    private boolean sleeping = false;
    public void regulateTemperature() {
        System.out.println("My temperature is just right now.");
    }
    public void startSleeping() {
        sleeping = true;
        System.out.println("ZzZz");
    }
    public boolean isSleeping(){
        return sleeping;
    }
}

class Human extends Mammal {
    public void goToWork(){
        System.out.println("I'm going to work, something only humans can do.");
    }
    public void startSleeping() {
        System.out.println("Toss and turn");
        // Overrides the Mammal method
        super.startSleeping();
        // Invokes the Mammal method
    }
}

class HumanTest { // Human takes on Mammal attributes
    public static void main(String args[]) {
        Human h = new Human();
        h.regulateTemperature();
        h.startSleeping();
        h.goToWork(); // Human uses own method
        boolean sleeping = h.isSleeping();
        if (sleeping){
            System.out.println("The human is sleeping!");
        }
    }
}


// Interfaces
// Allow classes to share functionality without having the same parent class
// Are not instantiated like classes
// Cannot contain instance fields (only static , final fields)
// Can extend other interfaces, and can be implemented by multiple classes

// Interface methods:
default // methods that are pre-implemented in the class that implements it
static // interface member methods, called on the interface (not the class)
abstract // methods declared without implementation (requires logic in class)

// Interface variable: implicitly stated (see 'myConstant' below)

public interface OperateBicycle {

    // constant that is implicitly public, static, and final
    double myConstant = 3.0; // an attribute to be inherited by classes
    
    // default method that does not need implementation
    default void sayHello() {
        System.out.println("Hello everybody");
    }
    
    // when implemented, implements on interface level
    static void staticMethod() {
        System.out.println("Hello from the static method of the interface");
    }

    // abstract methods that are declared without implementation;
    void speedUp(int increment); // implicit, so no need to mention;
    void applyBrakes(int decrement); // lets objects change a member var (e.g. speed);
}

// How to implement interfaces:
class Bicycle implements OperateBicycle { // 'implements' keyword    
    private int speed;

    public Bicycle() {
        speed = 0; // at instantiation, speed will be 0
    }

    // a static method that calls on the interface static method
    public static void staticMethod() {
        OperateBicycle.staticMethod();
    }

    // implementing speedUp
    public void speedUp(int increment) {
        speed += increment;
    }

    // implementing applyBrakes
    public void applyBrakes(int decrement) {
        speed -= decrement;
    }

    public int getSpeed() {
        return speed;
    }
}


// Abstract classes

// Like interfaces, cannot be instantiated and methods may not be implemented
// But they are used so that classes can inherit same characteristics and methods without needing to have an actual parent class that can get instantiated
// Abstract classes should not be instantiated (i.e. mammal). If something is a mammal, it is also either a human or some animal. "Mammal" is itself an abstract categorization.

public abstract class AbstractClass {
    public void randomMethod() {
        System.out.println("This is a random method that is implemented in this class");
    }
    // abstract method
    public abstract void abstractMethod();
}

public class SubClassOne extends AbstractClass{
    // we must implement the abstract method otherwise we will get an error.
    // it must be implemented because it extends from AbstractClass
    public void abstractMethod() {
        System.out.println("This is our method from subclass one");
    }
}

public class SubClassTwo extends AbstractClass{
    // we must also implement the abstract method otherwise we will get an error.
    public void abstractMethod() {
        System.out.println("This is our method from subclass two");
    }
}


// Abstract class that implements an interface

public interface InterfaceDemo {
    void methodOne(); // abstract methods
    void methodTwo();
}

public abstract class AbstractDemo implements InterfaceDemo {
    public void methodOne() { // abstract methods created
        System.out.println("Hello from the abstract demo");
    }
}

public class ClassDemo extends AbstractDemo {
    public void methodTwo() {
        System.out.println("Hello from the class demo");
    }
}

class AbstractTester {
    public static void main(String[] args) {
        ClassDemo c = new ClassDemo();
        c.methodOne(); // abstract methods implemented
        c.methodTwo();
    }
}


// Abstract vs Interfaces
// Both can be used by classes to inherit various fields/methods
// Interfaces rigidly require classes to use their abstract methods
// Abstract classes, on the other hand, leave that optional

// Interfaces are used when:
// - unrelated classes must implement various fields/methods
// - to specify the behavior of a particular data type for multiple classes
// - to take advantage of multiple inheritances of type

public interface Driveable { // normally interfaces are adjectives
    boolean hasWheels = True; // a final, static constant
    int getWheelAmt(); // same
    void setWheelAmt(int wheelAmt); // abstract method that must be implemented
    double getSpeed(); // same
    void setSpeed(double speed); // same
}

public class Vehicle implements Drivable {

    // you must define everything set in your interface
    int wheelAmt = 2;
    double speed = 0;

    // plus any additional features
    int acceleration = 0;i
    
    // must implement every abstract method inside of interface
    public int getWheelAmt() {
        return this.wheelAmt;
    }
    public void setWheelAmt(int amt) {
        wheelAmt = amt;
    }
    public double setSpeed() {
        return this.speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Vehicle(int wheels, double speed) {
        this.wheelAmt = wheels;
        this.speed = speed;
    }

}

// Abstract classes are used when:
// - related classes need to inherit various methods or fields
// - related classes require access modifiers other than public
// - to declare non-static or non-final fields (that can be modified by methods)

