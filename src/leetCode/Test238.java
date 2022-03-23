package leetCode;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * @author 曾奕
 */
public class Test238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int [n];
        Arrays.fill(res, 1);

        // 从左至右乘
        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            res[i] *= left;
        }

        // 从右至左乘
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }

        return res;
    }
}
