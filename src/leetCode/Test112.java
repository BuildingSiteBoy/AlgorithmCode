package leetCode;

/**
 * 数据结构：树
 * 112. 路径总和
 *
 * @author 曾奕
 */
public class Test112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null || root.right == null || root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
