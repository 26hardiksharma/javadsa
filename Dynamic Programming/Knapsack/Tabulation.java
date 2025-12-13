
import java.util.Arrays;

public class Tabulation {

    public static int knapsack(int[] val,int[] wt,int W) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<W+1;j++) {
                int value = val[i-1];
                int weight = wt[i-1];

                if(weight<=j) {
                    dp[i][j] = Math.max(value + dp[i-1][j-weight],dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];

    }
    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4}; 
        int W = 7;
        System.out.println(knapsack(val, wt, W));
    }
}
