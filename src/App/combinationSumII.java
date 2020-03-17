package App;
import java.util.*;
public class combinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, candidates, 0, target, temp);
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] candidates, int pos, int target, List<Integer> temp)     {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if(i > pos && candidates[i] == candidates[i - 1])
                continue;
            if(target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                dfs(res, candidates, i + 1, target - candidates[i], temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
