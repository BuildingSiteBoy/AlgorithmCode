package leetCode;

public class Test189 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1, -100, 3, 99};

        Solution189 s = new Solution189();
        s.rotate(nums1, 3);

        for (int num : nums1) {
            System.out.println(num);
        }
    }
}

class Solution189 {
    public void rotate(int[] nums, int k) {
/*      时间复杂度：O(kn)，超出时间限制
        空间复杂度：O(1);

        k %= nums.length;

        for (int x = 0; x < k; x++) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
*/
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
