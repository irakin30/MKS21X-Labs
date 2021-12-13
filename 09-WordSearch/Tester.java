public class Tester{
  public static void main(String[] args) {
    WordSearch yes = new WordSearch(5, 5);
    yes.addWordHorizontal("Trees",0,0);
    yes.addWordVertical("Win",1,0);
    yes.addWordDiagonal("Tires",0,0); 
    System.out.print(yes);
  }
}
