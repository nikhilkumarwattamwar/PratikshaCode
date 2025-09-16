package abstaction;

abstract public class Shape {
    abstract double area();
    String color;
    public Shape(String color){
        this.color=color;
    }
}
class Circle extends Shape{
    int r;
    Circle(int r){
        super("black");
        this.r=r;
    }
     double area(){
         return 3.14*r*r;
    }

}

class Rectangle extends Shape{
    int l,b;
    Rectangle(int l,int b){
        super("white");
        this.l=l;
        this.b=b;
    }
    double area(){
        return l*b;
    }
}

class Test1{
    public static void main(String[] args) {
        Circle c = new Circle(5);
        Rectangle r= new Rectangle(5,6);
        System.out.println("Area of the circle is "+c.area());
        System.out.println("area of the rectangle is "+r.area());
        System.out.println("area of the rectangle is "+r.color);

    }
}