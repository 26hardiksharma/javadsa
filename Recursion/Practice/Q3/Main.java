import java.util.concurrent.SubmissionPublisher;

public class Main {
    public static int printSubstrings(String str,int si,int ei) {

        if(si>=str.length()) {
            return 0;
        }

        if(ei>=str.length()) {
            return printSubstrings(str, si+1, si+1);
            
        }


        int res = 0;
        String substr = str.substring(si, ei+1);
        if(substr.charAt(0) == substr.charAt(substr.length()-1)) {
            res=1;
        }
        return res+printSubstrings(str, si, ei+1);
        

    }   
    
    public static void main(String[] args) {
        System.out.println(printSubstrings("abcba", 0, 0));
    } 
}
