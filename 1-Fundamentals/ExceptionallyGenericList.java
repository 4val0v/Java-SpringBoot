
import java.util.ArrayList;

public class ExceptionallyGenericList {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        // for (int i = 0; i < myList.size(); i++) {
        //     try {
        //         Integer value = (Integer) myList.get(i);
        //     } catch (ClassCastException e) {
        //         System.out.println("Error on index " + i);
        //     }
        // }
    }
}