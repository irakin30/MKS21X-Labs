public class Triangle {
    private Point v1, v2, v3;

    public Triangle(Point a, Point b, Point c) {
        v1 = a;
        v2 = b;
        v3 = c;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        v1 = new Point(x1, y1);
        v2 = new Point(x2, y2);
        v3 = new Point(x3, y3);
    }

    public Point getVertex(int v) {
      // What I would give to use a switch statement here
        if (v == 1) {
            return v1;
        }
        if (v == 2) {
            return v2;
        }
        return v3;
    }

    public void setVertex(int v, Point p) {
      //I would also love to use a switch statement here as well
        if (v == 1) {
            v1 = p;
        }
        if (v == 2) {
            v2 = p;
        }
        v3 = p;
    }

    public String toString() {
        return "{" + v1.toString() + ", " + v2.toString() + ", " + v3.toString() + "}";
    }

    public static boolean closeEnough(double a, double b) {
      if (a == 0.0 || b == 0.0) {
          return a == b;
      }
      return Math.abs(1 - Math.abs(b/a)) <= .00001;
    }

    //for my own convenience

    public double sideLength(int v) {
        if (v == 1) {
            return v1.distanceTo(v2);
        }

        if (v == 2) {
            return v2.distanceTo(v3);
        }

        return v3.distanceTo(v1);
    }

    public double getPerimeter() {
        return sideLength(3) + sideLength(1) + sideLength(2);
    }

    public boolean equals(Triangle z) {
        if (z == null) {
          return false;
        }
        return v1.equals(z.v1) && v2.equals(z.v2) && v3.equals(z.v3);
    }

    public String classify() {
      return "";
    }

    public double area() {
        double s = getPerimeter() / 2;
        return Math.sqrt( s * (s - sideLength(3)) * (s - sideLength(1)) * (s - sideLength(2)));
    }
}
