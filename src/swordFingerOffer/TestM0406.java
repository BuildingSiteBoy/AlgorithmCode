package swordFingerOffer;

import java.util.Stack;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）
 * @author 曾奕
 */
public class TestM0406 {
    /**
     * 递归解法
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode res = inorderSuccessor(root.left, p);
        return res == null? root : res;
    }

    /**
     * 利用栈实现中序遍历
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessorA(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }
}
