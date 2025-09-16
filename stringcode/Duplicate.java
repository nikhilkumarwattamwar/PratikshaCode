public class Duplicate {
    public static void main(String[] args) {
        String s="Occurrences";
        int[] count =new int[256];
        for(char c:s.toCharArray()){
            count[c]+=1;
        }

        for(int i=0;i< count.length;i++){
            if(count[i]>1){
                System.out.println((char)i+"=="+count[i]);
            }
        }

    }
}
