package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS、动态规划
 * 279. 完全平方数
 *
 * 1. BFS：可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
 * 要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
 *
 * 2. 动态规划：
 *
 * @author 曾奕
 */
public class Test279 {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(cur - s);
                }
            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     * @param n n
     * @return 1. 4. 9. 16. 25. 36....
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
