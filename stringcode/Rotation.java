public class Rotation {
    public static void main(String[] args) {
        String s1="JavaStringRotation";
        String s2="StringRotationJava";
        String s=s1+s1;
        if(s.indexOf(s2)==-1){
            System.out.println("String is not rotational");
        }else {
            System.out.println("String is rotational");
        }


    }
}
