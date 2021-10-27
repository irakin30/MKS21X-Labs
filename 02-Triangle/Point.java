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
  public static int distance(Point a, Point b) {
    return Math.abs(Math.sqrt((b.x - a.x) * (b.x - a.x)  + (b.y - a.y) * (b.y - a.y)));
  }
  public int distanceTo(Point b) {
    return Math.abs(Math.sqrt((x - b.x) * (x - b.x) + (y - b.y) * (y - b.y)));
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
