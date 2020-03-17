package App;

public class stoneGame {
    public boolean stoneGame(int[] values) {
        int n = values.length;
        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = values[i];
        }

        for (int k = 2; k <= n; k++) {// k is the distance between pile i, j
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                dp[i][j] = Math.max(values[i] - dp[i + 1][j], values[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }
}
