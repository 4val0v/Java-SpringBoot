
public class FizzBuzzTest {
    
    public static void main(String[] args) {
    
        FizzBuzz fb = new FizzBuzz();
        String fizzbuzz = fb.fizzBuzz(15);
        String fizz = fb.fizzBuzz(3);
        String buzz = fb.fizzBuzz(5);
        String notfizzbuzz = fb.fizzBuzz(16);
        System.out.println(fizzbuzz);
        System.out.println(fizz);
        System.out.println(buzz);
        System.out.println(notfizzbuzz);
    }
}