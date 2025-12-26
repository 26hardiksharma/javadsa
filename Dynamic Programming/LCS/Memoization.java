import java.util.Arrays;

public class Memoization {
    public static int lcs(String s1,String s2,int n,int m,int[][] dp) {
        if(m == 0 || n == 0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        } 
        if(s1.charAt(n-1)==s2.charAt(m-1)) {
            return dp[n][m] = lcs(s1, s2, n-1, m-1,dp)+1;

        } else {
            int a1 = lcs(s1, s2, n-1, m,dp);
            int a2 = lcs(s1, s2, n, m-1,dp);
            return dp[n][m] = Math.max(a1, a2);
        }
        
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "aceb";

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        int length = lcs(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(length);

    }
}
