
public class Main {

    public static void findSubsets(String s,String ans,int i) {
        //base case
        if(i==s.length()) {

            if(ans.length() == 0) {
                System.out.println("Φ");
            } else 
                System.out.println(ans);
            return;
        }
        //recursion
        // Yes

        findSubsets(s, ans+s.charAt(i), i+1);

        //No
        findSubsets(s, ans, i+1);



    }
    public static void main(String[] args) {
        String s = "abc";
        findSubsets(s, "", 0);
    }    
}
