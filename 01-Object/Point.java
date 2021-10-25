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
    return Math.abs(Math.sqrt((b.x - a.x) * (b.x - a.x)  + (b.y - a.y) (b.y - a.y)));
  }
  public int distanceTo(Point b) {
    return Math.abs(Math.sqrt((x - b.x) * (x - b.x) + (y - b.y) * (y - b.y));
  }
}
