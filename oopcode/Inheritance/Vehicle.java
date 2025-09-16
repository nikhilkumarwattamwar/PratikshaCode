package Inheritance;

public class Vehicle {
    private int vehicleprice;
    void drive(){
        System.out.println("driving the vehicle");
    }
    public void setVehiclePrice(int vehicleprice){
        this.vehicleprice=vehicleprice;
    }

    public int getVehicleprice(){
        return vehicleprice;
    }
}
class Car extends Vehicle{
   void drive(){
       System.out.println("driving the car");
   }

    @Override
    public void setVehiclePrice(int vehicleprice) {
        super.setVehiclePrice(vehicleprice);
    }

    public int getVehicleprice(){
       return super.getVehicleprice();
    }

    public static void main(String[] args) {
        Car obj= new Car();
        obj.setVehiclePrice(4500000);
        System.out.println(obj.getVehicleprice());

    }
}