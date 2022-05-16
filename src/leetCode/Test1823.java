package leetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1823. 找出游戏的获胜者
 * @author 曾奕
 */
public class Test1823 {
    public int findTheWinner(int n, int k) {
        int[] nums = new int[n];

        int i = 0;
        int temp = n;
        while (temp > 1) {
            int count = 0;
            while (count < k) {
                if (nums[i] == 0) {
                    count++;
                }
                if (count == k) {
                    break;
                }
                i = (i + 1) % n;
            }
            temp--;
            nums[i] = -1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == 0) {
                res = j + 1;
                break;
            }
        }

        return res;
    }

    /**
     * 模拟 + 队列
     * @param n
     * @param k
     * @return
     */
    public int findTheWinnerA(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    /**
     * 数学 + 递归
     * @param n
     * @param k
     * @return
     */
    public int findTheWinnerB(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinnerB(n - 1, k) - 1) % n + 1;
    }

    /**
     * 数学 + 迭代
     * @param n
     * @param k
     * @return
     */
    public int findTheWinnerC(int n, int k) {
        int winner = 1;
        for (int i = 2; i <= n; i++) {
            winner = (k + winner - 1) % i + 1;
        }
        return winner;
    }
}
