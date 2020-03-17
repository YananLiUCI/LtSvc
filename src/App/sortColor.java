package App;

public class sortColor {
    public void sortColors(int[] nums) {
        int pivot = 1;
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while(i <= right) {
            if(nums[i] < pivot) {
                swap(nums, i, left);
                i++;
                left++;
            }
            else if (nums[i] > pivot){
                swap(nums, i, right);
                right--;
            }
            else
                i++;
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
