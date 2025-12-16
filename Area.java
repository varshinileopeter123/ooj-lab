abstract class Shape {
    int a, b;
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int l, int w) {
        a = l;
        b = w;
    }

    void printArea() {
        System.out.println("Area of Rectangle = " + (a * b));
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        a = base;
        b = height;
    }

    void printArea() {
        System.out.println("Area of Triangle = " + (0.5 * a * b));
    }
}

class Circle extends Shape {
    Circle(int r) {
        a = r;
    }

    void printArea() {
        System.out.println("Area of Circle = " + (3.14 * a * a));
    }
}

public class ShapeMain {
    public static void main(String[] args) {
        Shape s;

        s = new Rectangle(10, 5);
        s.printArea();

        s = new Triangle(8, 6);
        s.printArea();

        s = new Circle(7);
        s.printArea();
    }
}
