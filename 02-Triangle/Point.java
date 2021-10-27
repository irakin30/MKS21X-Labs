public class Point{
  private double x,y;
  public Point(double X, double Y){
    x=X;
    y=Y;
  }

  public Point(Point p){
    x= p.x;
    y= p.y;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

  public static double distance(Point a, Point b) {
    return Math.sqrt(Math.pow(a.x - b.x, 2.0) + Math.pow(a.y - b.y, 2.0));
  }

  public double distanceTo(Point b) {
    return Math.sqrt(Math.pow(x - b.x, 2.0) + Math.pow(y - b.y, 2.0));
  }

  public static boolean closeEnough(double a, double b) {
    if (a == 0.0 || b == 0.0) {
        return a == b;
    }
    return Math.abs(1 - Math.abs(b/a)) <= .00001;
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public boolean equals(Point z) {
    return (closeEnough(x, z.x)) && (closeEnough(y, z.y));
  }
}
