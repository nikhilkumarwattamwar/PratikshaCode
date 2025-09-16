public class RemoveDuplicate {
    public static void main(String[] args) {
        String s="Occurrences";
        String newstr="";
        int[] count=new int[256];
        for(char c:s.toCharArray()){
            count[c]++;
        }
        for(int i =0;i<s.length();i++){
            char c=s.charAt(i);
            if(count[c]==1){
                newstr+=c;
            }
        }
        System.out.println(newstr);
    }
}
