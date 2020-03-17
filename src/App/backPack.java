package App;

public class backPack {
    public int backPack(int m, int[] A) {
        // write your code here
        int[] dp = new int[m + 1];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }

        return dp[m];
    }
}
