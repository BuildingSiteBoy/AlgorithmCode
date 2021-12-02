package swordFingerOffer;

import java.util.Arrays;

/**
 * 排序
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 *
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * */

public class Test61 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 0, 7, 3};

        System.out.println(new Solution61().isStraight(nums));
    }
}

class Solution61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 1; i < 5; i++) {
            if (nums[i - 1] == 0)
                continue;

            if (nums[i - 1] == nums[i])
                return false;

            sum += nums[i] - nums[i - 1];
        }

        return sum < 5;     //若为顺子，排序后前后数字差的和 < 5 (0除外)
    }
}