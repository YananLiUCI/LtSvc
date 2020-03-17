package App;
import java.util.*;
public class slidingWindowMedian {
    Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<Integer>();
    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] res = new double[nums.length - k + 1];
        for(int i  =0; i < k; i++) {
            addToHeap(nums[i]);
        }
        res[0] = getMedian(k) ;
        for (int i = k; i < nums.length; i++) {

            addToHeap(nums[i]);
            int num = nums[i - k];
            removeFromHeap(num);
            res[i - k + 1] = getMedian(k) ;

        }

        return res;
    }
    private void addToHeap(int num) {

        if(maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        }
        else
            minHeap.offer(num);
        while(Math.abs(maxHeap.size() - minHeap.size()) > 1){
            if(maxHeap.size() > minHeap.size()){
                minHeap.offer(maxHeap.poll());
            } else {
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    private void removeFromHeap(int num) {
        if(minHeap.isEmpty() || num < minHeap.peek())
            maxHeap.remove(num);
        else
            minHeap.remove(num);
        while(Math.abs(maxHeap.size() - minHeap.size()) > 1){
            if(maxHeap.size() > minHeap.size()){
                minHeap.offer(maxHeap.poll());
            } else {
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    private double getMedian(int k) {
        if(k % 2 == 0)
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0 ;
        else {
            if(minHeap.size() < maxHeap.size()) {
                return (double)maxHeap.peek();
            }
            else
                return (double)minHeap.peek();
        }
    }
}
