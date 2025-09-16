package encapsulation;

public class Student {
    private String name;
    private int rollno;
    private static String sub;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setRollno(int rollno){
        this.rollno=rollno;
    }
    public int getRollno(){
        return rollno;
    }

    public static void setSub(String sub){
        sub= sub;
    }
    public static String getSub(){
        return sub;
    }
}
class Test{
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Pratiksha");
        System.out.println("name is :"+s.getName());
        s.setRollno(56);
        System.out.println("roll no is :"+s.getRollno());
        Student.setSub("History");
        Student.getSub();

    }
}