package leetCode;

/**
 * 动态规划
 * 53. 最大子序和
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * */

public class Test53 {
    public static void main(String[] args) {

    }
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];

            if (sum > max)
                max = sum;

            //或者为以下内容：（但是下者消耗的内存更大）
            //sum = Math.max(nums[i], sum + nums[i]);
            //max = Math.max(max, sum);
        }

        return max;
    }
}