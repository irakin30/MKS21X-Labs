import java.util.Arrays; 

public class NotMine { 
    public static void bubbleSort(int[] data) {
        int placeHolder = 0;
        int size = data.length;

        // runs loops for amount of digits
        for (int b = 0; b < size; b++) {
            for (int c = 1; c < size - b; c++) {

                // if there is a value that is greater behind
                if (data[c - 1] > data[c]) {

                    placeHolder = data[c - 1]; // store prev value temporarily
                    data[c - 1] = data[c]; // classic triple swap
                    data[c] = placeHolder; // classic triple swap
                }

            }
        }
    }

    // sort number two
    /*
     * Selection sort
     */
    public static void selectionSort(int[] data) {
        int minimum;
        int placeHolder;
        int start;
        int size = data.length;

        for (int c = 0; c < size; c++) {
            start = c;
            minimum = data[c];

            // other loop to see where to and check if number less
            int j = c;
            while (j < size) {
                if (data[j] < minimum) {
                    start = j;
                    minimum = data[j];
                }
                j++;
            }

            // hold value and swap others
            placeHolder = data[c];
            data[c] = minimum;
            data[start] = placeHolder;
        }
    }

    // sort number three
    public static void insertionSort(int[] data) {
        // temp vals
        int index = 0;
        int current = 0;
        int size = data.length;

        for (int b = 1; b < size; b++) {
            index = b - 1;
            current = data[b];

            // problem: index goes out of bound when approaches zero
            // needs 2 conditions

            while ((index >= 0) && (data[index] > current)) {
                data[index + 1] = data[index];
                // decrement index
                index--;
            }
            // swaps
            data[index + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] test1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] sort1 = test1;
        Arrays.sort(sort1);
        insertionSort(test1);
        System.out.println("1" + sort1.equals(test1));
        int[] test2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] sort2 = test2;
        Arrays.sort(sort2);
        insertionSort(test2);
        System.out.println("2" + sort2.equals(test2));
        int[] test3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] sort3 = test3;
        Arrays.sort(sort3);
        insertionSort(test3);
        System.out.println("3" + sort3.equals(test3));
        int[] test4 = new int[25];
        for (int x = 0; x < 25; x++) {
            test4[x] = (int) (Math.random() * 1000) - 500;
        }
        int[] sort4 = test4;
        Arrays.sort(sort4);
        insertionSort(test4);
        System.out.println("4" + sort4.equals(test4));
        int[] test5 = { 0 };
        int[] sort5 = test5;
        Arrays.sort(sort5);
        insertionSort(test5);
        System.out.println("5" + sort5.equals(test5));
        int[] test6 = {};
        int[] sort6 = test6;
        Arrays.sort(sort6);
        insertionSort(test6);
        System.out.println("6" + sort6.equals(test6));
        int[] test7 = { 0, 2, 4, 6, 8, 0, 2, 4, 6, 8 };
        int[] sort7 = test7;
        Arrays.sort(sort7);
        insertionSort(test7);
        System.out.println("7" + sort7.equals(test7));
    }

}
