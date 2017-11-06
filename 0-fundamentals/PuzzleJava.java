import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;


public class PuzzleJava {
    
    public ArrayList printSum() {
        int[] array = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        double sum = 0;
        for (int element : array) {
            sum += element;
            if (element > 10) {
                arraylist.add(element);
            }
        }
        System.out.println(sum);
        return arraylist;
    }

    public ArrayList listNames() {
        String[] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> longnames = new ArrayList<String>();
        Collections.shuffle(Arrays.asList(names));
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
            if (names[i].length() > 5) {
                longnames.add(names[i]);
            }
        }
        System.out.println(longnames);
        return longnames;
    }

    public void alphabetShuffle() {
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Collections.shuffle(Arrays.asList(alphabet));
        System.out.println(alphabet[25]);
        System.out.println(alphabet[0]);
        String[] vowels = {"a","e","i","o","u"};
        for (String vowel : vowels) {
            if (alphabet[0] == vowel){
                System.out.println("It's a vowel!");
            }
        }
    }

    public int[] randomArray() {
        int[] randomarray;
        randomarray = new int[10];
        randomarray[0] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[1] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[2] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[3] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[4] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[5] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[6] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[7] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[8] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[9] = 55 + (int)(Math.random() * ((100 - 55) + 1));

        for (int number : randomarray) {
            System.out.println(number);
        }
        return randomarray;
    }

    public int[] randomSortedArray() {
        int[] randomarray;
        randomarray = new int[10];
        randomarray[0] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[1] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[2] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[3] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[4] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[5] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[6] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[7] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[8] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        randomarray[9] = 55 + (int)(Math.random() * ((100 - 55) + 1));
        Arrays.sort(randomarray);
        for (int number : randomarray) {
            System.out.println(number);
        }
        return randomarray;
    }

    public String randomString() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String randomstring = "";
        for (int i = 0; i < 5; i++) {
            randomstring += alphabet.charAt(random.nextInt(alphabet.length()));
        }
        System.out.println(randomstring);
        return randomstring;
    }

    public ArrayList randomStringsArray() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> randomstrings = new ArrayList<String>();
        int n = 1;
        while (n < 6) {
            String randomstring = "";
            for (int i = 0; i < 5; i++) {
                randomstring += alphabet.charAt(random.nextInt(alphabet.length()));
            }
            randomstrings.add(randomstring);
            n++;
        }
        return randomstrings;
    }

    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();
        puzzle.printSum();
        puzzle.listNames();
        puzzle.alphabetShuffle();
        puzzle.randomArray();
        puzzle.randomSortedArray();
        puzzle.randomString();
        puzzle.randomStringsArray();
    }
}