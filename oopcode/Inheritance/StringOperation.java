package Inheritance;

public class StringOperation {
    String concat(String str1, String str2)
    {
        return str1 + str2;
    }

    String concat(String str1, String str2, String str3)
    {
        return str1 + str2 + str3;
    }

    String concat(int num, String str)
    {
        return num + str;
    }

    public static void main(String[] args)
    {
        StringOperation obj = new StringOperation();
        System.out.println("Concat 1 : " + obj.concat("Hello ", "World"));
        System.out.println("Concat 2 : " + obj.concat("Java", " is", " fun"));
        System.out.println("Concat 3 : " + obj.concat(90, " is answer"));
    }
}
