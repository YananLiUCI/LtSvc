package App;
import java.util.*;
public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, candidates, target, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(target < candidates[i]) continue;
            temp.add(candidates[i]);
            dfs(res, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
