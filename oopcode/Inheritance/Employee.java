package Inheritance;

public class Employee {
   private String name;
   private String address;
   private String jobtitle;
    private int salary;
    public Employee(String name, String address, String jobtitle, int salary){
        this.name=name;
        this.address= address;
        this.salary=salary;
        this.jobtitle=jobtitle;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public double getSalary() {
        return salary;
    }

    public double calculateBonus(){
        return getSalary();
    }
}

class Manager extends Employee{
    private int teammebers;
    Manager(String name, String address, String jobtitle, int salary,int teammebers){
        super(name,address,jobtitle,salary);
        this.teammebers=teammebers;
    }

    public int getTeammebers() {
        return teammebers;
    }

    @Override
    public double calculateBonus() {
       return getSalary()*0.20;
    }

    public static void main(String[] args) {
        Manager m= new Manager("sam","wen","manager",140000,7);
        System.out.println(m.getName());

    }
}

