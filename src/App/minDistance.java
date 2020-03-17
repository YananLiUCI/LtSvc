package App;

public class minDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= m; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    // 注意这步考虑 dp[i - 1][j - 1]同时再考虑
                    // min(dp[i - 1][j], dp[i][j - 1]) + 1 也合乎逻辑，一样可以 AC
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j],
                                    dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }

}
