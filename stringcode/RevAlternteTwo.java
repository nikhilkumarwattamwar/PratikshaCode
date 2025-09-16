public class RevAlternteTwo {
    //rev alternate two chars in string
    public static void main(String[] args) {
        String s="abcdefghi";
        StringBuilder sb=new StringBuilder();
        boolean reverse=true;
        for(int i=0;i<s.length();i+=2){
            if(i+1<s.length()){
                if(reverse){
                    sb=sb.append(s.charAt(i+1)).append(s.charAt(i));
                }else {
                    sb=sb.append(s.charAt(i)).append(s.charAt(i+1));
                }
            }else {
                sb=sb.append(s.charAt(i));
            }
            reverse=!reverse;
        }
        System.out.println(sb);
    }
}
