package leetCode;

/**
 * 数据结构：树
 * 104. 二叉树的最大深度
 *
 * @author 曾奕
 */
public class Test104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
