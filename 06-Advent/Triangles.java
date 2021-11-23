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
        int[][] nums = new int[3][3]; 
        while (input.hasNextInt()) { 
            for(int i = 0; i < 3; i++) {
              nums[0][i] = input.nextInt();
              nums[1][i] = input.nextInt();
              nums[2][i] = input.nextInt();
            } 
            for(int i = 0; i < 3; i++) { 
              if(isTriangle(nums[i])) { 
                count++;
              }
            }
        }
        System.out.println(count);
    } 
    
}
