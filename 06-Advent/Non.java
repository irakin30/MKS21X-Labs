import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Non{
    public static void main(String[] args) {
        try {
          File data = new File(args[0]);
          Scanner input = new Scanner(data);
          if (args[1].equals("1")) {
              int count = 0;
              while(input.hasNextLine()) {
                  String line = input.nextLine();
                  if (isNice(line)) {
                    count++;
                  }
              }
              System.out.println(count);
            }
        }
        catch (FileNotFoundException e) {
          System.out.println("File Not Found.");
        }
  }

  public static boolean nVowels(String str) {
      int count = 0;
      for(int i = 0; i < str.length(); i++) {
          if ("aeiou".contains("" + str.charAt(i))) {
              count++;
          }
      }
      return count >= 3;
  }

  public static boolean notContain(String str) {
      String[] forbidden = {"ab","cd","pq","xy"};
      for(String s : forbidden) {
          if (str.contains(s)) {
            return false;
          }
      }
      return true;
  }

 public static boolean twice(String str){
      for(int i = 0; i < str.length() - 1; i++){
          if(str.charAt(i) == str.charAt(i + 1)) {
            return true;
          }
      }
      return false;
  }

  public static boolean isNice(String a) {
    return nVowels(a) && notContain(a) && twice(a);
  }

}
