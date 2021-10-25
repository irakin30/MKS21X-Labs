public class Demo{
  public static int distance(Point a, Point b) {
    double xDistance = (a.getX() - b.getX()) * (a.getX() - b.getX());
    double yDistance = (a.getY() - b.getY()) * (a.getY() - b.getY());
    return Math.abs(Math.sqrt(yDistance + xDistance));
  }

  public static void main(String[]args){
    Point P1 = new Point(1,1);
    Point P2 = new Point(2,2);

    System.out.println(distance(P1,P2));
    System.out.println(Point.distance(P1,P2));
    System.out.println(P1.distanceTo(P2)); 
  }
 }
