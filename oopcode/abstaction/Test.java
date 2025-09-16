package abstaction;

abstract class Vehicle{
    abstract int getNumberofWheels();
    abstract int getNumberofSeats();
}
 class Bus extends  Vehicle{
    int getNumberofWheels(){
        return 4;
    }
    int getNumberofSeats(){
        return 4;
    }
}

class Cycle extends Vehicle{
     int getNumberofWheels(){
         System.out.print("Cycle:weels:");
        return 2;
    }
     int getNumberofSeats(){
        return 1;
    }
    void m(){
        System.out.println("this is void method");
    }
}


public class Test {
    public static void main(String[] args) {
        Cycle c= new Cycle();
        c.m();
        System.out.println(c.getNumberofSeats());
        System.out.println(c.getNumberofWheels());
    }
    }



