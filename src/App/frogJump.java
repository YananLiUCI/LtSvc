package App;
import java.util.*;
public class frogJump {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2)
                return false;
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if(step > 0 && map.containsKey(stones[i] + step))
                        map.get(stones[i] + step).add(step);
                }
            }
        }
        int size = map.get(stones[stones.length - 1]).size();
        return size > 0;
    }
    public boolean canCrossII(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        if (stones == null || stones.length == 0) {return false;}
        int n = stones.length;
        if (n == 1) {return true;}
        if (stones[1] != 1) {return false;}
        if (n == 2) {return true;}
        for (int i = 4; i < stones.length; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2)
                return false;
        }
        for(int[] row : memo)
            Arrays.fill(row, -1);
        return memoSearch(memo, 0, 0, stones) == 1;
    }
    private int memoSearch(int[][]memo, int pos, int jump, int[] stones) {
        if(memo[pos][jump] >= 0)
            return memo[pos][jump];
        for (int i = pos + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[pos];
            if (gap >= jump - 1 && gap <= jump + 1) {
                if(memoSearch(memo, i, gap, stones) == 1) {
                    memo[i][gap] = 1;
                    return 1;
                }

            }
        }
        if(pos == stones.length - 1)
            memo[pos][jump] = 1;
        else
            memo[pos][jump] = 0;
        return memo[pos][jump];
    }
}
