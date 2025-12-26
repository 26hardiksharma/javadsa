
import java.util.Arrays;

public class TargetSumSubset {

    public static boolean subset(int[] val,int target) {
        int n = val.length;
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i = 0;i<n+1;i++) {
            dp[i][0] = true;
        }
        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<target+1;j++) {
                if(val[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-val[i-1]];
                } else {
                    dp[i][j]  = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
    public static void main(String[] args) {
        int[] num = {4,2,7,1,3};
        int target = 17;
        System.out.println(subset(num, target));
    }
}
