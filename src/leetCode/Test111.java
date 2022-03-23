package leetCode;

/**
 * 数据结构：树
 * 111. 二叉树的最小深度
 * @author 曾奕
 */
public class Test111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.right);
        int r = minDepth(root.left);
        if (l == 0 || r == 0) {
            return l + r + 1;
        }
        return Math.min(l, r) + 1;
    }
}
