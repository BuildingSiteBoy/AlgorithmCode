package leetCode;

/**
 * 动态规划、贪心算法
 * 1567. 乘积为正数的最长子数组长度
 *
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * 请你返回乘积为正数的最长子数组长度。
 *
 * 解题思路：强的离谱！！！
 *  当 n == 0 时：正数与负数的个数为零；
 *  当 n > 0 时：正数+1，若负数>0，则负数+1；
 *  当 n < 0 时：正负号颠倒，即正负数个数互换，负数+1，若正数>0，则正数+1.
 * */

public class Test1567 {
    public static void main(String[] args) {
        int[] nums1 = {1, -1, 1, 0, 1, -1, 1, -2, -1, -5};
        int[] nums2 = {-1, 2};
        int[] nums3 = {1000000000, 1000000000};

        System.out.println(new Solution1567().getMaxLen(nums1));
        System.out.println(new Solution1567().getMaxLen(nums2));
        System.out.println(new Solution1567().getMaxLen(nums3));

    }
}

class Solution1567 {
    public int getMaxLen(int[] nums) {
        int res = 0;
        int zs = 0, fs = 0;

        for (int n : nums) {
            if (n == 0) {
                zs = 0;
                fs = 0;
            } else if (n > 0) {
                zs++;
                if (fs > 0)
                    fs++;
                res = Math.max(res, zs);
            } else {
                int temp = zs;
                zs = fs;
                fs = temp;

                fs++;
                if (zs > 0)
                    zs++;

                res = Math.max(res, zs);
            }
        }

        return res;
    }
}
/*
class Solution1567 {
    public int getMaxLen(int[] nums) {
        int len = 0;
        int max = 0;
        long mul = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                len = 0;
                mul = 1;
            } else {
                if (mul > 100000000 || mul < -100000000)
                    mul /= 100000000;
                if (nums[i] > 100000000 || nums[i] < -100000000)
                    nums[i] /= 100000000;

                mul *=nums[i];
                len++;
                if (nums[i] > 0)
                    max = Math.max(1, max);
                if (mul > 0) {
                    max = Math.max(max, len);
                }
            }
        }

        return max;
    }
}*/
