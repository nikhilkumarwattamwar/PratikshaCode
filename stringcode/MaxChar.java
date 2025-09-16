public class MaxChar {
    public static void main(String[] args) {
        String s="Refrigerator";
        int[] count=new int[256];
        for(char c:s.toCharArray()){
            count[c]+=1;
        }
        int max=0;
        char maxchar=' ';
        for(int i=0;i<count.length;i++){
            if(count[i]>max){
                max=count[i];
                maxchar=(char)i;
            }

        }
        System.out.println(maxchar);
    }
}
