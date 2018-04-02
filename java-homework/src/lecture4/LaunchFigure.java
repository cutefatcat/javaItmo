package lecture4;

public class LaunchFigure {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(0,0),new Point(5,5));
        System.out.println(circle.calculateSquare() + " " + circle.calculatePerimetr());

        Rectangle rectangle = new Rectangle(new Point(0,0),new Point(0,5), new Point(-3,5), new Point(-3,0));
        System.out.println(rectangle.calculateSquare() + " " + rectangle.calculatePerimetr());

        Triangle triangle = new Triangle(new Point(-2, 2), new Point(0,7), new Point(5,4));
        System.out.println(triangle.calculateSquare() + " " + triangle.calculatePerimetr());
    }
}

/**
 * 2. Создать фигуры: Circle, Rectangle, Triangle, у которых будут координаты.
 * Все фигуры должны иметь методы, которые возвращают площадь и периметр
 * (для окружности - длина окружности).
 */

abstract class Figure{
    protected double calculateSideLenght(Point a, Point b){
        double ab = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        return ab;
    }

    public abstract double calculateSquare();

    public abstract double calculatePerimetr();
}

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Circle extends Figure{
    Point a;
    Point b;
    double r;

    public Circle(Point a, Point b){
        this.a = a;
        this.b = b;

        r = calculateSideLenght(a,b);
    }

    @Override
    public double calculateSquare() {
        double s = Math.PI * r * r;
        return s;
    }

    @Override
    public double calculatePerimetr() {
        double l = Math.PI * 2 * r;
        return l;
    }
}

class Rectangle extends Figure{
    Point a;
    Point b;
    Point c;
    //Point d;

    double ab;
    double bc;

    public Rectangle(Point a, Point b, Point c, Point d){
        this.a = a;
        this.b = b;
        this.c = c;
        //this.d = d;

        ab = calculateSideLenght(a,b);
        bc = calculateSideLenght(b,c);
    }

    @Override
    public double calculateSquare() {
        double s = ab * bc;
        return s;
    }

    @Override
    public double calculatePerimetr(){
        double p = (ab + bc) * 2;
        return p;
    }
}

class Triangle extends Figure{
    Point a;
    Point b;
    Point c;

    double ab;
    double bc;
    double ca;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;

        ab = calculateSideLenght(a,b);
        bc = calculateSideLenght(b,c);
        ca = calculateSideLenght(c,a);
    }

    @Override
    public double calculateSquare() {
        double pp = (ab + bc + ca)/2;
        double s = Math.sqrt(pp * (pp - ab)*(pp - bc)*(pp - ca));
        return s;
    }

    @Override
    public double calculatePerimetr(){
        double p = ab + bc + ca;
        return p;
    }
}
