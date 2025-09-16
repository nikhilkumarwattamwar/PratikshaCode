public class PreserveSpace {
    public static void main(String[] args) {
        String s = "this is a string";
        char[] strarray=s.toCharArray();
        char[] result=new char[strarray.length];
        for(int i=0;i< strarray.length;i++){
            if(strarray[i]==' '){
                result[i]=' ';
            }
        }
        int j= result.length-1;
        for(int i=0;i< strarray.length;i++){
            if(strarray[i]!=' '){
                if(result[j]==' '){
                    j--;
                }
                result[j]=strarray[i];
                j--;
            }
        }
        System.out.println(String.valueOf(result));
    }
}
