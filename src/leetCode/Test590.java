package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 * @author 曾奕
 */
public class Test590 {
    public List<Integer> postorder(Node590 root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node590 root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (Node590 ch : root.children) {
            helper(ch, res);
        }
        res.add(root.val);
    }
}

class Node590 {
    public int val;
    public List<Node590> children;

    public Node590() {}

    public Node590(int _val) {
        val = _val;
    }

    public Node590(int _val, List<Node590> _children) {
        val = _val;
        children = _children;
    }
};
