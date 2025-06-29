public class Main {

    public static boolean checkPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() -1;
        while(startIndex<=endIndex) {
            if(s.charAt(startIndex++)!= s.charAt(endIndex--)) return false;

        }
        return true;
    }
    public static void main(String[] args) {
        String s = "noon";
        System.out.println(checkPalindrome(s));
    }    
}
