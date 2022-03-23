package leetCode;

import java.util.Arrays;

/**
 * 相遇问题
 * 462. 最少移动次数使数组元素相等 II
 *
 * 每次可以对一个数组元素加一或者减一，求最小的改变次数。
 * 这是个典型的相遇问题，移动距离最小的方式是所有元素都移动到中位数。理由如下：
 * 设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。要使 a 和 b 相等，它们总共移动的次数为 b - a，这个值
 * 等于 (b - m) + (m - a)，也就是把这两个数移动到中位数的移动次数。
 * 设数组长度为 N，则可以找到 N/2 对 a 和 b 的组合，使它们都移动到 m 的位置。
 *
 * @author 曾奕
 */
public class Test462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
    }

    public int minMoves2E(int[] nums) {
        int move = 0;
        int median = findKthSmallest(nums, nums.length / 2);
        for (int num : nums) {
            move += Math.abs(num - median);
        }
        return move;
    }

    private int findKthSmallest(int[] nums, int i) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == i) {
                break;
            }
            if (j < i) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[i];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (nums[i++] < nums[l] && i < h);
            while (nums[--j] > nums[l] && j > l);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
