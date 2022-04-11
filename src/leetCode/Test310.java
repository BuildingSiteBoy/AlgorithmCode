package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 310. 最小高度树
 * 解题思路：构建图，循环遍历图，找出叶子节点。去除叶子节点。知道图中节点只剩下2个或1个。返回剩下的节点。
 *
 * @author 曾奕
 */
public class Test310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 用于存储结果
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        // 建立各个节点的出入度表
        int[] degree = new int[n];
        // 建立图关系，在每个节点的list中存储相连节点
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        // 建立队列
        Queue<Integer> queue = new LinkedList<>();
        // 把所有度为1的节点（叶子节点）加入队列
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        // 剔除叶子节点，直到图中只剩下一到两个节点
        while (!queue.isEmpty()) {
            res.clear();
            // 取最开始的队列长度，不能放在for判断条件内，因为队列长度是会变的
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                for (int num : map.get(cur)) {
                    degree[num]--;
                    if (degree[num] == 1) {
                        queue.offer(num);
                    }
                }
            }
        }

        return res;
    }
}
