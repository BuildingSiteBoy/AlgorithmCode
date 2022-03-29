package leetCode;

/**
 * 404. 左叶子之和
 * @author 曾奕
 */
public class Test404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode left) {
        if (left == null) {
            return false;
        }
        return left.left == null && left.right == null;
    }
}
