package App;

public class findMedianSortedArray {
    // time complexity O(logk) k = (m + n) / 2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if(length % 2 == 1)
            return (double) findKth(nums1, 0, nums2, 0, length / 2 + 1);
        else
            return (findKth(nums1, 0, nums2, 0, length / 2)
                    + findKth(nums1, 0, nums2, 0, length / 2 + 1)) / 2.0;

    }
    private int findKth(int[] nums1, int startA, int[] nums2, int startB, int k) {
        if(startA == nums1.length) return nums2[startB + k - 1];
        if(startB == nums2.length) return nums1[startA + k - 1];
        if(k == 1)
            return Math.min(nums1[startA], nums2[startB]);
        int keyA = (startA + k / 2 - 1 < nums1.length) ?
                nums1[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int keyB = (startB + k / 2 - 1 < nums2.length) ?
                nums2[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if(keyA > keyB) {
            return findKth(nums1, startA, nums2, startB + k / 2, k - k / 2);
        }
        else
            return findKth(nums1, startA + k / 2, nums2, startB, k - k / 2);
    }
}
