package leetCode;

public class Test35 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {2, 4, 5, 6, 7, 8, 9};

        Solution35 s = new Solution35();
        System.out.println(s.searchInsert(nums1, 2));
        System.out.println(s.searchInsert(nums2, 3));
    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low < high) {
            mid = (low + high) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return target > nums[mid] ? (low + 1) : low;
    }
}
