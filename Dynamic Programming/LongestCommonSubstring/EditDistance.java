public class EditDistance {

    public static int editDist(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<dp.length;i++) {
            dp[i][0] = i;
        }

        for(int j = 0;j<dp[0].length;j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int x = dp[i-1][j];
                    int y = dp[i][j-1];
                    int z = dp[i-1][j-1];
                    dp[i][j] = Math.min(x,Math.min(y, z)) + 1;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "Hardik";
        String s2 = "Maybehardik";

        int dist = editDist(s1,s2);
        System.out.println(dist);
    }
}
