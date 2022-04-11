package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * @author 曾奕
 */
public class Test429 {
    public List<List<Integer>> levelOrder(Node429 root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node429> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Node429 node = queue.poll();
                cur.add(node.val);
                for (Node429 child : node.children) {
                    queue.offer(child);
                }
            }
            res.add(cur);
        }

        return res;
    }
}

class Node429 {
    public int val;
    public List<Node429> children;

    public Node429() {}

    public Node429(int _val) {
        val = _val;
    }

    public Node429(int _val, List<Node429> _children) {
        val = _val;
        children = _children;
    }
};
