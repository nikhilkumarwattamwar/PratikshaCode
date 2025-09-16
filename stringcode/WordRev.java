public class WordRev {
    public static void main(String[] args) {
        String s="this is string";
        String[] strArr=s.split(" ");

       for(int i=0;i<strArr.length;i++){
           String words=strArr[i];
           String revwords="";

           for(int j=words.length()-1;j>=0;j--){
               revwords+=words.charAt(j);
           }
           System.out.print(revwords+" ");
       }

    }
}
