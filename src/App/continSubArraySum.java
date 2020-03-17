package App;
import java.util.*;
public class continSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int running_sum = 0;
        for(int i = 0; i < nums.length; i++) {
            running_sum += nums[i];
            if(k != 0)
                running_sum = running_sum % k;
            Integer previous = map.get(running_sum);
            if(previous != null) {
                if(i - previous > 1)
                    return true;
            }
            else {
                map.put(running_sum, i);
            }
        }

        return false;
    }
}
