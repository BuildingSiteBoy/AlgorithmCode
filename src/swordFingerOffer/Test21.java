package swordFingerOffer;

/**
 * 双指针
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * */

public class Test21 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] res = new Solution21().exchange(nums);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}

class Solution21 {
    public int[] exchange(int[] nums) {
        if (nums.length < 2)
            return nums;

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] % 2 == 0 && nums[j] % 2 == 1) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = temp;
            } else if (nums[i] % 2 == 1) {
                i++;
            } else if (nums[j] % 2 == 0) {
                j--;
            } else {
                i++;
                j--;
            }
        }

        return nums;
    }
}