public class SecondMaxChar {
    public static void main(String[] args) {
        String s="Meghalaya";
        int[] count=new int[256];
        for(char c:s.toCharArray()){
            count[c]+=1;
        }
        int max=0;
        char maxchar=' ';
        int second=0;
        char secChar=' ';
        for(int i=0;i<count.length;i++){
            if(count[i]>max){
               max= count[i];
               maxchar=(char)i ;
            }
            if(count[i]>second && count[i]<max){
                second=count[i];
                secChar=(char)i;
            }
        }
        System.out.println("max char is : "+maxchar);

        System.out.println("Second max char is : "+secChar);

    }
}
