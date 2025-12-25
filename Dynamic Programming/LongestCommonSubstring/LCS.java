public class LCS {

    public static int lcs(String s1,String s2) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i =1 ;i<dp.length;i++) {
            for(int j = 1;j<dp[i].length;j++) {
                if(s1.charAt(i-1)== s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;

                } else {
                    dp[i][j]= 0;
                    
                }
                if(max<dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;

    }
    public static void main(String[] args) {
        String s1 = "ABCDE";
        String s2 = "ABECG";

        int length = lcs(s1, s2);
        System.out.println(length);
        
    }
}
