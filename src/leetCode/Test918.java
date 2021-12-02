package leetCode;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

/**
 * 918. 环形子数组的最大和
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 *
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。
 * （形式上，当0 <= i < A.length 时 C[i] = A[i]，
 * 且当 i >= 0 时 C[i+A.length] = C[i]）
 *
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。
 * （形式上，对于子数组 C[i], C[i+1], ..., C[j]，
 * 不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 * */

public class Test918 {
    public static void main(String[] args) {
        int[] nums = {-2, -3, -1};
        int[] nums1 = {-2};

        System.out.println(new Solution918().maxSubarraySumCircular(nums));
        System.out.println(new Solution918().maxSubarraySumCircular(nums1));
    }
}

//解题思路：最大子序和+最小子序和
class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int temp = nums[0], sum = nums[0];
        int max = nums[0], min = 0;

        //最大子序和
        for (int i = 1; i < nums.length; i++) {
            if (temp < 0)
                temp = nums[i];
            else
                temp = temp + nums[i];

            if (temp > max)
                max = temp;

            sum +=nums[i];
        }

        //最小子序和：需要掐头去尾
        temp = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (temp > 0)
                temp = nums[i];
            else
                temp = temp + nums[i];

            if (temp < min)
                min = temp;
        }

        if (max > sum - min)
            return max;
        else
            return sum - min;
    }
}

class Solution918_Simple {
    public int maxSubarraySumCircular(int[] nums) {
        int temp = nums[0], sum = nums[0], max = nums[0];
        int min = 0;

        //最大子序和
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i] + Math.max(0, temp);
            max = Math.max(temp, max);
            sum += nums[i];
        }

        //最小子序和
        temp = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            temp = nums[i] + Math.min(0, temp);
            min = Math.min(temp, min);
        }

        return Math.max(max, sum - min);
    }
}