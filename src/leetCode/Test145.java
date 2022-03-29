package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
 * 可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
 *
 * @author 曾奕
 */
public class Test145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            res.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postorderTraversalE(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postDfs(root, res);
        return res;
    }

    private void postDfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postDfs(root.left, res);
        postDfs(root.right, res);
        res.add(root.val);
    }
}
