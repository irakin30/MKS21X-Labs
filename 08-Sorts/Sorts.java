import java.util.Arrays;
public class Sorts{
    public static void main(String[] args) {
        int[] test = {5,1,-12,-5,12,0};
        System.out.println(Arrays.toString(test));
        bubbleSort(test);
        System.out.println(Arrays.toString(test));
    }
    /**Bubble sort of an int array.
    *Upon completion, the elements of the array will be in increasing order.
    *@param data  the elements to be sorted.
    */
    public static void bubbleSort(int[] data){
        int temp;
        for (int i = 0; i < data.length - 1; i++) {
            for(int j = 0; j < data.length - (i + 1); j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }



}
