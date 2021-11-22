import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) {
          try {
              File data = new File("data.txt");
              Scanner input = new Scanner(data);
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
          catch (FileNotFoundException e) {
          }
    }

    public static boolean isTriangle(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        return (a + b > c) && (b + c > a) && (a + c > b);
    }
}
