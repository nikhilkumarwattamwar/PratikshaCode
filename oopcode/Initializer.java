import java.util.Scanner;

public class Initializer {
    int num1,num2;

    static int sum(){
        int a=5,b=4;
        return a+b;
    }
    static int sum(int a, int b){
        return a+b;
    }
    static int add(int x,int y){
        Initializer i= new Initializer();
        i.num1=x;
        i.num2=y;
        return i.num1+i.num2;
    }

    public static void main(String[] args) {
        Initializer i= new Initializer();
        int c= Initializer.sum();
        int d= Initializer.sum(11,55);
        System.out.println(c);
        System.out.println(d);
        System.out.println("Enter the number:");
        Scanner sc= new Scanner(System.in);
        int z=Initializer.add(5,6);
        System.out.println(z);
    }
}
