package leetCode;

import java.util.Arrays;

/**
 * 动态规划
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * */

public class Test740 {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 2};
        int[] nums2 = {2, 2, 2, 2, 3, 3, 3, 4};

        System.out.println(new Solution740().deleteAndEarn(nums1));
        System.out.println(new Solution740().deleteAndEarn(nums2));
    }
}

class Solution740 {
    public int deleteAndEarn(int[] nums) {
        //将该数组相同点数相加，转换为打家劫舍问题
        int[] temp = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] += nums[i];
        }

        int[] res = new int[10001];

        res[0] = 0;
        res[1] = temp[1];
        for (int i = 2; i < 10001; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + temp[i]);
        }

        return res[10000];
    }
}