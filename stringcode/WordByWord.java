public class WordByWord {
    //reverse a string word by word
    public static void main(String[] args) {
        String s= "This is a long string";
        String[] strarr=s.split(" ");
        String rev="";
        for(int i=strarr.length-1;i>=0;i--){
            rev+=strarr[i]+" ";
        }
        System.out.println(rev);
    }
}
