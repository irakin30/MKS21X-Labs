import java.util.Scanner;
public class GraphicsDriver {
    //Colors and Stuff 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
   
    /*
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m"; 
    public static final String ANSI_UP = "\u001B[A"; 
    */ 

    public static void clear() { 
        //Basically clear the screen, but it still has scroll functionality for the history.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 

    public static void refresh(Damageable a, Damageable b) {
        clear(); 
        System.out.println(ANSI_GREEN + a.getName() + " : " + a.getHP() + ANSI_RESET);
        System.out.println(ANSI_RED + b.getName() + " : " + b.getHP() + ANSI_RESET);
        System.out.print('\n');   
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        Warrior a = new Warrior("Magnus"); 
        Warrior b = new Warrior("Lester");   
        for(int i = 0; i < 100; i++) {
            refresh(a, b); 
            a.attack(b);
            b.attack(a);
            input.nextLine();
        } 
        input.close();
    }
}
