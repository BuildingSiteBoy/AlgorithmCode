package leetCode;

import java.util.Arrays;

/**
 * 169. 多数元素
 * @author 曾奕
 */
public class Test169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElementE(int[] nums) {
        int cnt = 0, majority = nums[0];
        for (int num : nums) {
            majority = (cnt == 0) ? num : majority;
            cnt = (majority == num) ? cnt + 1 : cnt - 1;
        }
        return majority;
    }
}
