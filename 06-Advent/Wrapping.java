import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wrapping {
    public static void main(String[] args) {
        try {
            File data = new File(args[0]);
            Scanner input = new Scanner(data);
            int total = 0;
            if (args[1].equals("1")) {
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    int[] dimensions = getDimensions(line);
                    total += surfaceArea(dimensions[0], dimensions[1], dimensions[2]);
                }
            }
            else {
                while(input.hasNextLine()) {
                  String line = input.nextLine();
                  int[] dimensions = getDimensions(line);
                  total += ribbonNeeded(dimensions[0], dimensions[1], dimensions[2]);
                }
            }
            input.close();
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        }
    }

    public static int getPerimeter(int a, int b) {
        return 2 * (a + b);
    }

    public static int ribbonNeeded(int x, int y, int z) {
        int min = getPerimeter(x, y);
        if (min > getPerimeter(y, z)) {
            min = getPerimeter(y, z);
        }
        if (min > getPerimeter(x, z)) {
            min = getPerimeter(x, z);
        }
        return (x * y * z) + min ;
    }

    public static int surfaceArea(int x, int y, int z) {
        int slack = x * y;
        if (slack > (y * z)) {
            slack = y * z;
        }
        if (slack > x * z) {
            slack = x * z;
        }
        return (2 * ((x * y) + (y * z) + (x * z))) + slack;
    }

    public static int[] getDimensions(String line) {
        int[] dimensions = new int[3];
        dimensions[0] = Integer.parseInt(line.substring(0, line.indexOf("x")));
        dimensions[1] = Integer.parseInt(line.substring(line.indexOf("x") + 1, line.lastIndexOf("x")));
        dimensions[2] = Integer.parseInt(line.substring(line.lastIndexOf("x") + 1));
        return dimensions;
    }

}
