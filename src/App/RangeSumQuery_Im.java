package App;

public class RangeSumQuery_Im {
    private int[][] dp;
    public void NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i + 1][j + 1] = matrix[i][j] + dp[i][j + 1] + dp[i + 1][j] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(dp == null || dp.length == 0 || dp[0] == null || dp[0].length == 0)
            return 0;
        return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];
    }
    public int avgRegion(int row1, int col1, int row2, int col2) {
        if(dp == null || dp.length == 0 || dp[0] == null || dp[0].length == 0)
            return 0;
        int count = (row2 - row1 + 1) * (col2 - col1 + 1);
        int avg = sumRegion(row1, col1, row2, col2) / count;
        return avg;
    }
}
