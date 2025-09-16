package interfac;

interface Shape {
    public double area();
    public double perimeter();
}
class Circle implements Shape{
    int r;
    Circle(int r){
        this.r=r;
    }

    public double area(){
        return 3.14*r*r;
    }

    public double perimeter(){
        return 2 * 3.14 * r;
    }
}
class Rectangle implements Shape{
    int l=5,b=6;
    public double area(){
       return l*b;
    }
    public double perimeter(){
        return 2 * (l + b);
    }

}
class Test2{
    public static void main(String[] args) {
        Circle c= new Circle(6);
        Rectangle r=new Rectangle();
        System.out.println(c.perimeter());
        System.out.println(r.perimeter());
    }
}
