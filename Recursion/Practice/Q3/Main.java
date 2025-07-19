
public class Main {
    public static int countValidSubstrings(String str,int si,int ei) {

        if(si>=str.length()) {
            return 0;
        }

        if(ei>=str.length()) {
            return countValidSubstrings(str, si+1, si+1);
            
        }


        int res = 0;
        String substr = str.substring(si, ei+1);
        if(substr.charAt(0) == substr.charAt(substr.length()-1)) {
            res=1;
        }
        return res+countValidSubstrings(str, si, ei+1);
        

    }   
    
    public static void main(String[] args) {
        System.out.println(countValidSubstrings("abcba", 0, 0));
    } 
}
