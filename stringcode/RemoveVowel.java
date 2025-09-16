public class RemoveVowel {
    public static void main(String[] args) {
        String s="hello world";
        String vowel="aeiouAEIOU";
        String newstr="";
        for(char c:s.toCharArray()){
            if(vowel.indexOf(c)==-1){
                newstr+=c;
            }
        }
        System.out.println(newstr);

        System.out.println("--X--");

        String s1="Project";
        String str="";
        for(int i=0;i<s1.length();i++){
            char c=Character.toLowerCase(s1.charAt(i));
            if(c!='a'&& c!='e'&& c!='i'&& c!='o'&& c!='u'){
                str+=c;
            }
        }
        System.out.println(str);
        System.out.println("--X--");

        String s2="money";
        String str1=s2.replaceAll("[aeiouAEIOU]","");
        System.out.println(str1);

    }
}
