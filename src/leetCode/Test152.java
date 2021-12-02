package leetCode;

/**
 * 动态规划
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 解题思路：
 * 求最大值，可看成求被0拆分的各个子数组的最大值；
 * 但一个数组中没有0存在时：
 *      1.负数为偶数个，全部相乘；
 *      2.负数为奇数个，最大值不是在负数的左边就是在右边；
 * */

public class Test152 {
    public static void main(String[] args) {

    }
}

class Solution152 {
    public int maxProduct(int[] nums) {
        int mul = 1;
        int max = nums[0];

        //从左边开始计算
        for (int num : nums) {
            mul *= num;
            if (max < mul)
                max = mul;
            if (num == 0)
                mul = 1;
        }

        mul = 1;
        //从右边开始计算
        for (int i = nums.length - 1; i >= 0; i--) {
            mul *= nums[i];
            if (max < mul)
                max = mul;
            if (nums[i] == 0)
                mul = 1;
        }

        return max;
    }
}