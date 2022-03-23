package leetCode;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 找到最大的三个数或者最小的两个数与最大的数之积
 *
 * @author 曾奕
 */
public class Test628 {
    public int maximumProduct(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[l - 1], nums[l - 1] * nums[l - 2] * nums[l - 3]);
    }

    public int maximumProductE(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1, max3 = max1;
        int min1 = Integer.MAX_VALUE, min2 = min1;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        return Math.max(max1 * min1 * min2, max1 * max2 * max3);
    }
}
