import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the co-ordinates of the triangles");
        Point[] pointsTriangle = new Point[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter first co-ordinate x" + (i + 1) + ": ");
            double x = scan.nextDouble();
            System.out.println("Enter first co-ordinate y" + (i + 1) + ": ");
            double y = scan.nextDouble();
            pointsTriangle[i] = new Point(x, y);
        }
        scan.close();
    }

    static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;

        }

        public double distanceTo(Point otherValues) {
            double dx = this.x - otherValues.x;
            double dy = this.y - otherValues.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

    }
}
