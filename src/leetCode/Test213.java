package leetCode;

/**
 * 动态规划
 * 打家劫舍2
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * */

public class Test213 {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {0};

        System.out.println(new Solution213().rob(nums1));
        System.out.println(new Solution213().rob(nums2));
        System.out.println(new Solution213().rob(nums3));
    }
}

class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        else if (n == 2)
            return Math.max(nums[0], nums[1]);
        else if (n == 3)
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);

        int[] res1 = new int[n];
        res1[0] = nums[0];
        res1[1] = Math.max(res1[0], nums[1]);
        for (int i = 2; i < n - 1; i++)
            res1[i] = Math.max(res1[i - 1], res1[i - 2] + nums[i]);

        int[] res2 = new int[n];
        res2[1] = nums[1];
        res2[2] = Math.max(res2[1], nums[2]);
        for (int i = 3; i < n; i++)
            res2[i] = Math.max(res2[i - 1], res2[i - 2] + nums[i]);

        return Math.max(res1[n - 2], res2[n - 1]);
    }
}