public class First {
  public int x,y;
  public First(){
    x = 44;
    y = 99;
  }
  public static void main(String[] args) {
    First a = new First();
    System.out.println(a.x);
    System.out.println(a.y);
    Second b = new Second();
    System.out.println(b.x);
  }
}
