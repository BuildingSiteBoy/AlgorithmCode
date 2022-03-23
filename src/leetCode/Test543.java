package leetCode;

/**
 * 数据结构：树
 * 543. 二叉树的直径
 *
 * @author 曾奕
 */
public class Test543 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        max = Math.max(max, lDepth + rDepth);
        return Math.max(lDepth, rDepth) + 1;
    }
}
