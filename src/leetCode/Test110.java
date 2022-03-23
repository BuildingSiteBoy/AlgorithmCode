package leetCode;

/**
 * 数据结构：树
 * 110. 平衡二叉树
 *
 * @author 曾奕
 */
public class Test110 {
    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return res;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) {
            res = false;
            return 0;
        }
        return 1 + Math.max(l, r);
    }
}
