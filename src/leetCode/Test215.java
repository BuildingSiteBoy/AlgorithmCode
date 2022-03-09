package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 排序问题
 * 215. 数组中的第K个最大元素
 * @author 曾奕
 */
public class Test215 {
    /**
     * 排序
     * @param nums 数组
     * @param k 第k大
     * @return 第k大的元素
     */
    public int findKthLargest01(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆排序
     * @param nums 数组
     * @param k 第k大
     * @return 第k大的元素
     */
    public int findKthLargest02(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int v : nums) {
             pq.add(v);
             if (pq.size() > k) {
                 pq.poll();
             }
        }
        return pq.peek();
    }

    /**
     * 快速选择排序
     * @param nums 数组
     * @param k 第k大
     * @return 第k大的元素
     */
    public int findKthLargest03(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - l;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < h) {}
            while (nums[--j] > nums[l] && j > l) {}
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
