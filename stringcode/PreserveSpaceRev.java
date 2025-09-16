public class PreserveSpaceRev {
    public static void main(String[] args) {
        String s="This is String";
        String[] strarr=s.split(" ");
        StringBuilder rev= new StringBuilder();
        for(int i=strarr.length-1;i>=0;i--){
            rev.append(strarr[i]);
        }
        System.out.println(rev);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
               rev.insert(i,' ');
            }
        }
        System.out.println(rev);

    }
}
