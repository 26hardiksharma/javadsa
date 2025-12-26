import java.util.Arrays;

public class Memoization {

    public static int cost(int[] arr,int i,int j,int[][] dp) {
        if(i>=j) return 0;

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k = i;k<j;k++) {
            int cost1 = cost(arr, i, k,dp);
            int cost2 = cost(arr,k+1,j,dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalcost = cost1+cost2+cost3;

            ans = Math.min(ans,finalcost);

        }
        return dp[i][j] = ans;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        int[][] dp = new int[arr.length][arr.length];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        System.out.println(cost(arr,1,arr.length-1,dp));
    }
}
