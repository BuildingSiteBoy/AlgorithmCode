package leetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 循环数组中比当前元素大的下一个元素
 * @author 曾奕
 */
public class Test503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                next[pre.pop()] = num;
            }
            if (i < n) {
                pre.push(i);
            }
        }
        return next;
    }
}
