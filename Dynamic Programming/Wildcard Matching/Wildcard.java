public class Wildcard {
    public static boolean matches(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int j = 1;j<dp[0].length;j++) {
            if(s2.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            } else {
                dp[0][j] = false;
            }
        }

        for(int i = 1;i<dp.length;i++) {
            for(int j = 1;j<dp[0].length;j++) {
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);

                if(c1 == c2 || c2 == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(c2 == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "baaabab";
        String s2 = "*****ba*****ab";

        boolean matched = matches(s1, s2);
        System.out.println(matched);
    }
}
