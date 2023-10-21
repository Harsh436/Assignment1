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
        Triangle tri = new Triangle(pointsTriangle[0], pointsTriangle[1], pointsTriangle[2]);
        double perimeter = tri.calculatePerimeter();
        if (tri.isIsosceles()) {
            System.out.println("Perimeter: " + perimeter + "   The tringle is isosceles");
        } else {
            System.out.println("Perimeter: " + perimeter + "   The tringle is not isosceles");
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

        public double pointsDistance(Point otherValues) {
            double dx = this.x - otherValues.x;
            double dy = this.y - otherValues.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

    }

    static class Triangle {
        private Point[] vertices = new Point[3];

        public Triangle(Point p1, Point p2, Point p3) {
            vertices[0] = p1;
            vertices[1] = p2;
            vertices[2] = p3;
        }

        public double calculatePerimeter() {
            double perimeter = 0;
            for (int i = 0; i < 3; i++) {
                int j = (i + 1) % 3;
                perimeter += vertices[i].pointsDistance(vertices[j]);
            }
            return perimeter;
        }

        public boolean isIsosceles() {
            double triangleSide1 = vertices[0].pointsDistance(vertices[1]);
            double triangleSide2 = vertices[1].pointsDistance(vertices[2]);
            double triangleSide3 = vertices[2].pointsDistance(vertices[0]);

            return triangleSide1 == triangleSide2 || triangleSide2 == triangleSide3 || triangleSide3 == triangleSide1;
        }
    }
}
