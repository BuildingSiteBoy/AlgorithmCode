package swordFingerOffer;

/*
* 剑指 Offer 42. 连续子数组的最大和
* 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
* 要求时间复杂度为O(n)。
* */

public class Test42 {
    public static void main(String[] args) {

    }
}

class Solution42 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int num : nums) {
            if (sum <= 0) {
                sum = num;      //如果sum小于零，那么它就是累赘没必要加上
            } else {
                sum += num;     //如果sum大于零，那就要加上
            }

            max = Math.max(sum, max);
        }

        return max;
    }
}
