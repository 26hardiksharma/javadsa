public class Main {

    public static void allPermutations(String s,String ans) {
        if(s.length() == 0) {
            System.out.println(ans);
            return;

        }
        
        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            String newString = s.substring(0, i)+s.substring(i+1);
            allPermutations(newString, ans+ch);
        }


    }
    public static void main(String[] args) {
        String s = "abc";
        allPermutations(s, "");
    }    
}
