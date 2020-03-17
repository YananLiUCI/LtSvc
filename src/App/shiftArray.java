package App;

public class shiftArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return ;
        int shift = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, shift - 1);
        reverse(nums, shift, nums.length - 1);

    }
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
