import java.util.Arrays;
public class Tester {

    public static boolean sorted(int[] original, int[] newdata) {
        Arrays.sort(original);
        return original.equals(newdata);
    }

    public static int[] randomArr() {
        int[] random = new int[(int)(Math.random() *  100)];
        for (int i = 0; i < random.length; i++) {
            random[i] = (int)(Math.random() * 1000 - 500);
        }
        return random;
    }

    public static void main(String[] args) {

    }

}
