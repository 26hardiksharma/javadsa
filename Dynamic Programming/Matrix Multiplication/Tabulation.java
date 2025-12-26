public class Tabulation {
    public static int cost(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len < dp.length; len++) {
            for (int i = 1; i <= n-len; i++) {
                int j=i + len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i;k<j;k++) {
                    int c1 = dp[i][k];
                    int c2 = dp[k+1][j];
                    int c3 = arr[i-1]*arr[j]*arr[k];
                    int finalcost = c1+c2+c3;
                    dp[i][j] = Math.min(dp[i][j],finalcost);
                }
            }
        }
        return dp[1][arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        System.out.println(cost(arr));
    }
}
