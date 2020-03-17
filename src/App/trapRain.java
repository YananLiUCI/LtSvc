package App;

public class trapRain {
    public int trap(int[] height) {
        if(height == null || height.length <= 1)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                if(height[left] < leftMax) {
                    sum += leftMax - height[left];
                }
                else
                    leftMax = height[left];
                left++;
            }
            else {
                if(height[right] < rightMax) {
                    sum += rightMax - height[right];
                }
                else
                    rightMax = height[right];
                right--;
            }
        }
        return sum;
    }
}
