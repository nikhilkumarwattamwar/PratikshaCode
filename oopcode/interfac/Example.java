package interfac;

public class Example {
    public static void main(String[] args) {
        D d=  new D();
        d.m1();
    }
}
interface A{
    public void m1();
}
interface B extends A{
    public void m2();
}
abstract class C implements A{
    abstract void m3();
}
class D extends C implements B{
    public void m1(){
        System.out.println("Interface A method");
    }

    public void m2(){
        System.out.println("Interface B method");
    }

    void m3(){
        System.out.println("Abstract B method");
    }
}