package App;
import java.util.*;
public class slidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1 ) {
                res[index++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
