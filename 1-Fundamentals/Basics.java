import java.util.ArrayList;
import java.util.Arrays;


public class Basics {
    
    public void printTo255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }

    public void printOddsTo255() {
        for (int i = 1; i <= 255; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    public void printSum() {
        double sum = 0;
        for (int i = 0; i <= 255; i++) {
            sum += i;
            System.out.println("New Number: " + i + " Sum: " + sum);
        }
    }

    public void iterateThruArray(int[] array) {
        for (Object element : array) {
            System.out.println(element);
        }
    }

    public void findMax(int[] array) {
        int max = -2147483648;
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        System.out.println(max);
    }

    public void getAverage(int[] array) {
        double sum = 0;
        for (int element : array) {
            sum += element;
        }
        System.out.println(sum / array.length);
    }

    public void oddArray() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 == 1) {
                array.add(i);
            }
        }
        System.out.println(array);
    }

    public void greaterThanY(int[] array, int y) {
        for (int element : array) {
            if (element > y) {
                System.out.println(element);
            }
        }
    }

    public void squareValues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }
        System.out.println(array);
    }

    public void elimNegatives(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }
        System.out.println(array);
    }

    public void maxMinAvg(int[] array) {
        int max = -2147483648;
        int min = -2147483648;
        double sum = 0;
        for (int element : array) {
            if (element > max) {
                max = element;
            }
            if (element < min) {
                min = element;
            }
            sum += element;
        }
        double avg = sum / array.length;
        Object[] newarray = {max, min, avg};
        System.out.println(newarray);
    }

    public void shiftArrValues(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[array.length-1] = 0;
        System.out.println(array);
    }

    public static void main(String[] args) {
        Basics basics = new Basics();

        int[] iterate = {1,3,5,7,9,13};
        int[] findmax = {-3, -5, -7};
        int[] getavg = {2, 10, 3};
        int[] greater = {1, 3, 5, 7};
        int[] notsquared = {1, 5, 10, -2};
        int[] negs = {1, 5, 10, -2};
        int[] mma = {1, 5, 10, -2};
        int[] shift = {1, 5, 10, 7, -2};

        basics.printTo255();
        basics.printOddsTo255();
        basics.printSum();
        basics.iterateThruArray(iterate);
        basics.findMax(findmax);
        basics.getAverage(getavg);
        basics.oddArray();
        basics.greaterThanY(greater, 3);
        basics.squareValues(notsquared);
        basics.elimNegatives(negs);
        basics.maxMinAvg(mma);
        basics.shiftArrValues(shift);
    }
}