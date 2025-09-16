public class Occurrence {
    public static void main(String[] args) {
        String s="Hello String";
        int[] count=new int[256];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
            count[s.charAt(i)]+=1;
            }
        }
        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                System.out.println(((char)i +" = "+count[i]));
            }
        }
    }
}
