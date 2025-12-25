import java.util.Arrays;

public class LongestIncreasingSubsequece {
    public static int lis(int[] arr) {
        int[] a2 = new int[arr.length];
        for(int i = 0;i<arr.length;i++) {
            a2[i] = arr[i];
        }
        Arrays.sort(a2);
        int[][] dp = new int[a2.length+1][a2.length+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if(arr[i-1] == a2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[a2.length][a2.length];


    }
    public static void main(String[] args) {
        int[] arr = {50,3,10,7,40,80};

        int length = lis(arr);
        System.out.println(length);
    }
}
