//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Reverse {
    public static void main(String[] args) {

        String s= "this is a string";
        String rev="";
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                rev+=s.charAt(i);
            }
        }
        System.out.println(rev);


    }
    }
