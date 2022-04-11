package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第 K 小的元素
 * @author 曾奕
 */
public class Test378 {
    /**
     * 二分查找
     * @param matrix 矩阵
     * @param k k
     * @return 第k小的元素
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix.length;
        int l = matrix[0][0], h = matrix[m - 1][n - 1];
        // l <= h : <= <= <= !!!
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    count++;
                }
            }
            if (count < k) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    /**
     * 转换为数组
     * @param matrix 矩阵
     * @param k k
     * @return 第k小的元素
     */
    public int kthSmallestO(int[][] matrix, int k) {
        int m = matrix.length, n = matrix.length;
        int len = n * m;
        int[] nums = new int[len];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[index++] = matrix[i][j];
            }
        }

        Arrays.sort(nums);
        return nums[k - 1];
    }

    /**
     * 堆解法
     * @param matrix 矩阵
     * @param k k
     * @return 第k小的元素
     */
    public int kthSmallestE(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }

        // 小根堆，去掉 k - 1 个堆顶元素，此时堆顶就是第 k 小的元素
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            // 当遍历到最后一行时，没有新元素的添加
            if (t.x == m - 1) {
                continue;
            }
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;

    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.val - o.val;
    }
}
