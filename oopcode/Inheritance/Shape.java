package Inheritance;

abstract public class Shape {
    abstract void draw();
    abstract double calculateArea();
}

class Circle extends Shape{
    private int radius;
    final double PI=3.14;
    @Override
    void draw() {
        System.out.println("drawing a circle");
    }

    public Circle(int radius){
        this.radius=radius;
    }
    public int getRadius(){
        return radius;
    }

    @Override
    double calculateArea() {
        return PI*radius*radius;
    }
}

class Cylinder extends Circle{
    private int height;
    @Override
    void draw() {
        System.out.println("drawing a cylinder");
    }
    public Cylinder(int radius,int height){
        super(radius);
        this.height=height;
    }
    public int getRadius(){
        return super.getRadius();
    }

    @Override
    double calculateArea() {
        double circleArea = super.calculateArea();
        double sideArea = 2 * PI * getRadius() * height;
        return 2 * circleArea + sideArea;
    }

    public static void main(String[] args) {
        Cylinder obj=new Cylinder(5,6);
        obj.draw();
        System.out.println(obj.calculateArea());
        Circle obj2=new Cylinder(8,4);
        System.out.println(obj2.calculateArea());
    }
}