package leetCode;

public class Test704 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {2, 4, 6, 8, 10};

        Solution solution = new Solution();
        System.out.println(solution.search(nums1, 2));
        System.out.println(solution.search(nums2, 3));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int res = -1;

        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                res = mid;
                break;
            }
        }

        return res;
    }
}
