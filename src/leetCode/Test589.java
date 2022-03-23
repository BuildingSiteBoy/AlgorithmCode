package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * @author 曾奕
 */
public class Test589 {
    public List<Integer> preorder(Node589 root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node589 root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node589 ch : root.children) {
            helper(ch, res);
        }
    }
}

class Node589 {
    public int val;
    public List<Node589> children;

    public Node589() {}

    public Node589(int _val) {
        val = _val;
    }

    public Node589(int _val, List<Node589> _children) {
        val = _val;
        children = _children;
    }
};
