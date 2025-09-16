package abstaction;

public class Person {
    private String firstname;
    private String lastname;
    Person(String firstname, String lastname){
        this.firstname= firstname;
        this.lastname= lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
class Employee extends Person{
    private int employeeid;
    private String job;
    Employee (String firstname,String lastname, int employeeid,String job){
        super(firstname,lastname);
        this.employeeid=employeeid;
        this.job=job;
    }
    public String getLastname() {
        return super.getLastname()+" "+job;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public static void main(String[] args) {
        Employee e= new Employee("sam" ,"wick", 45,"coder");
        System.out.println(e.getFirstname()+" "+e.getLastname()+" "+e.getEmployeeid());

    }

}