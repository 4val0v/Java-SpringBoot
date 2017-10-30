
public class StringManipulatorTest {
    
    public static void main(String[] args) {
    
        StringManipulator manipulator = new StringManipulator();

        String tac = manipulator.trimAndConcat("  Hello  ","  World  ");
        Integer gion = manipulator.getIndexOrNull("Hello","l");
        Integer gion2 = manipulator.getIndexOrNull("Hello","z");
        Integer gion3 = manipulator.getIndexOrNull("Hello","lo");
        Integer gion4 = manipulator.getIndexOrNull("Hello","World");
        String css = manipulator.concatSubstring("Hello", 1, 2, "world");

        System.out.println(tac);
        System.out.println(gion);
        System.out.println(gion2);
        System.out.println(gion3);
        System.out.println(gion4);
        System.out.println(css);
    }
}