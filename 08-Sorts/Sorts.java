import java.util.Arrays;
public class Sorts{
    /**Bubble sort of an int array.
    *Upon completion, the elements of the array will be in increasing order.
    *@param data  the elements to be sorted.
    */
    public static void bubbleSort(int[] data){
        int temp;
        for (int i = 0; i < data.length - 1; i++) {
            boolean switched = false;
            for(int j = 0; j < data.length - (i + 1); j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    switched = true;
                }
            }
            if (!switched) {
              return;
            }
        }
      }

      public static void selectionSort(int [] ary) {
          int minIndex = 0;
          while (minIndex < ary.length) {
            int minVal =  ary[minIndex];
            int index = minIndex;
            for (int i = minIndex; i < ary.length; i++) {
                if (ary[i] < minVal) {
                  minVal = ary[i];
                  index = i;
                }
            }
            ary[index] = ary[minIndex];
            ary[minIndex] = minVal;
            minIndex++;
          }
      }

      public static void insertionSort(int[] ary){
          for(int i = 1; i < ary.length; i++) {
              int temp = ary[i]; 
              int j = i;
              while(j >= 0 && temp < ary[j]) {
                  ary[j + 1] = ary[j];
                  j--; 
              } 
              ary[j+1] = temp; 
          }
      }  

}
