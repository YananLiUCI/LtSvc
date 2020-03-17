package App;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            Arrays.fill(res, -1);
            if(nums == null || nums.length < 2) {
                return res;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = target - nums[i];
                if(map.containsKey(num)) {
                    res[0] = map.get(num);
                    res[1] = i;
                    return res;
                }
                else {
                    map.put(num, i);
                }
            }

            return res;
    }
}
