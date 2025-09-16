public class RevByTwoChar {
    public static void main(String[] args) {
        String s="abcdefghi";
        String str="";

            for(int i=0;i<s.length();i+=2){
                if(i+1<s.length()){
                    str+=""+s.charAt(i+1)+s.charAt(i);
                }else {
                    str+=""+s.charAt(i);
                }
        }
        System.out.println(str);

    }
}
