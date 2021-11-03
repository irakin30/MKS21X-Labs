import java.lang.Math;

public class TestCases {
    /* more methods can go here */
    public static double distance(Point First, Point Second) {
        return Math.sqrt(((Second.getX() - First.getX()) * (Second.getX() - First.getX()))
                + ((Second.getY() - First.getY()) * (Second.getY() - First.getY())));
    }

    public static void main(String[] args) {
        Point P1 = new Point(1, 1);
        Point P2 = new Point(3, 2);
        Point P3 = new Point(5, 10);
        Point P4 = new Point(8, 4);
        Point P5 = new Point(0, 0);
        Point P6 = new Point(-5, -5);
        Point P7 = new Point(0.00001, 99.99999);
        Point P8 = new Point(0.00000999999, 100.0);

        System.out.println(distance(P1, P2)); // call1
        System.out.println(Point.distance(P1, P2)); // call 2
        System.out.println(P1.distanceTo(P2)); // call 3
        // This one is IMPLIED strongly. You cannot tell by the calling style alone,
        // but you can make an educated guess.
        // should be 1.414214
        System.out.println(distance(P3, P4)); // call1
        System.out.println(Point.distance(P3, P4)); // call 2
        System.out.println(P3.distanceTo(P4)); // call 3
        // should be 8.602325
        System.out.println(distance(P5, P6)); // call1
        System.out.println(Point.distance(P5, P6)); // call 2
        System.out.println(P5.distanceTo(P6)); // call 3
        // should be 7.071068
        System.out.println(P1.toString());

        Point P9 = new Point(-2, 3);
        Point P10 = new Point(-5, -4);
        Point P11 = new Point(2, -1);
        Point P12 = new Point(0, 5);
        Point P13 = new Point(2, 0);
        Point P14 = new Point(-2, 0);
        Triangle T1 = new Triangle(P1, P2, P3);
        Triangle T2 = new Triangle(P1, P2, P3);
        Triangle T3 = new Triangle(P1, P10, P3);
        Triangle T4 = new Triangle(P2, P3, P4);
        Triangle T5 = new Triangle(0.0, 2.0, 3.0, 0.0, 2.0, 4.0);
        System.out.println(T1.getVertex(2));
        System.out.println(T1.toString());
        System.out.println(T1.getPerimeter());

        System.out.println(Point.closeEnough(100.0, 99.99999));
        System.out.println(Point.closeEnough(200.0, 99.99999));
        System.out.println(Point.closeEnough(0.00001, 0.00000999999));
        System.out.println(Point.closeEnough(0.0, .000000001));

        System.out.println(P7.equals(P8));
        System.out.println(P1.equals(P2));
        System.out.println(T1.equals(T2));
        System.out.println(T3.classify());
        System.out.println(T3.area());
        System.out.println(T1);
    }
}

