package App;
import java.util.*;
public class parlindromePartition {

    public int palindromePartition(String s, int k) {
        int size = s.length();
        int[][] strDiff = new int[size][size];
        char[] chs = s.toCharArray();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int diff = getDistance(chs, i, j);
                strDiff[i][j] = diff;
            }
        }
        int[][] dp = new int[size][k];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i < size; i++) {
            int segment = 1;
            // 分为一个字符串
            dp[i][0] = Math.min(dp[i][0], strDiff[0][i]);
            for (; segment < k ; segment++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j][segment-1] != Integer.MAX_VALUE) {
                        dp[i][segment] = Math.min(dp[i][segment],
                                dp[j][segment-1] + strDiff[j+1][i]);
                    }
                }
            }
        }
        return dp[size - 1][k - 1];
    }

    private int getDistance(char[] chars, int start, int end) {


        int count = 0;
        while(start <= end) {
            if(chars[start]!= chars[end]){
                count++;
            }
            start++;
            end--;
        }

        return count;
    }
}
