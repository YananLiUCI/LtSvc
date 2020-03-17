package App;

public class matrixMultiplier {

    public int[][] matrixMultiplier(int[][] m, int[][] n) {

        if(m == null || m.length == 0 || m[0].length == 0)
            return null;
        if(n == null ||n.length == 0 || n[0].length == 0)
            return null;

        int[][] result = new int[m.length][n[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < m[0].length; k++) {

                if (m[i][k] != 0) {
                    for (int j = 0; j < n[0].length; j++) {
                        if (n[k][j] != 0)
                            result[i][j] += m[i][k] * n[k][j];
                    }
                }
            }
        }
        return result;
    }
}
