public class Second {
  public double x;
  public Second(){
    x = 9.99;
  }

  public static void main(String[] args) {
    First a = new First();
    System.out.println(a.x);
    System.out.println(a.y);
    Second b = new Second();
    System.out.println(b.x);
  }
}
