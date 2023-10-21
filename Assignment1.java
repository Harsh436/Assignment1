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
        double area = tri.area(pointsTriangle[0], pointsTriangle[1], pointsTriangle[2]);

        if (tri.isIsosceles()) {
            System.out.println("Perimeter: " + perimeter + "   The tringle is isosceles");
        } else {
            System.out.println("Perimeter: " + perimeter + "   The tringle is not isosceles");
        }
        System.out.println("area : " + area);
        System.out.println("Enter first co-ordinate a1");
        double a = scan.nextDouble();
        System.out.println("Enter first co-ordinate b1");
        double b = scan.nextDouble();
        Point checkPoints = new Point(a, b);
        boolean isInside = tri.containsPoint(checkPoints, pointsTriangle[0], pointsTriangle[1], pointsTriangle[2]);
        if (isInside) {
            System.out.println("It is inside the triangle");
        } else {
            System.out.println("It is not inside the triangle");
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
            double distx = this.x - otherValues.x;
            double disty = this.y - otherValues.y;
            return Math.sqrt(distx * distx + disty * disty);
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

        public boolean containsPoint(Point checkPoint, Point p1, Point p2, Point p3) {
            boolean itContains = false;
            double totalPointArea = 0;
            double pointArea1 = area(checkPoint, p1, p2);
            double pointArea2 = area(checkPoint, p3, p2);
            double pointArea3 = area(checkPoint, p1, p3);
            double mainTriangleArea = area(p1, p2, p3);
            totalPointArea = pointArea1 + pointArea2 + pointArea3;
            if (totalPointArea <= mainTriangleArea) {
                itContains = true;
            } else {
                itContains = false;
            }

            return itContains;
        }

        public double area(Point A, Point B, Point C) {
            double area = (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2.0f;
            return Math.abs(area);
        }
    }
}
