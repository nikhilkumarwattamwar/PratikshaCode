package Inheritance;

public class Configuration {
    int a=10;
    static int config;
    static {
        config=1000;
    }

    public static void main(String[] args) {
        System.out.println(config);
        B obj= new B();

        System.out.println(obj.a);
        Configuration obj1= new B();
        System.out.println(obj1.a);
    }
}
class B extends Configuration{
    int a=20;
}
