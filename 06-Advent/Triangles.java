import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) {
          try {
              File data = new File(args[0]);
              Scanner input = new Scanner(data);
              if (Integer.parseInt(args[1]) == 1) {
                  byRow(input);
              }
              else {
                byColumn(input);
              }
              input.close();
          }
          catch (FileNotFoundException e) {
              //maybe throw an exception lol
          }
    }

    public static boolean isTriangle(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        return (a + b > c) && (b + c > a) && (a + c > b);
    }

    public static void byRow(Scanner input) {
        int[] nums = new int[3];
        int count = 0;
        while(input.hasNextInt()) {
            for (int i = 0; i < 3; i++) {
                nums[i] = input.nextInt();
            }
            if (isTriangle(nums)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void byColumn(Scanner input) {
        int count = 0;
        int i = 0;
        int[] a = new int[3];
        int[] b = new int[3];
        int[] c = new int[3];
        while(input.hasNextInt) {
             if (int i > 2) {
               i = 0;
               if (isTriangle[a]) {
                 count++;
               }
               if (isTriangle[b]) {
                 count++;
               }
               if (isTriangle[c]) {
                 count++;
               }
             }
             a[i] = input.nextInt();
             b[i] = input.nextInt();
             c[i] = input.nextInt();
        }
        System.out.println(count);
    }
}
