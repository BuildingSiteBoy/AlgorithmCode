package leetCode;

/**
 * 337. 打家劫舍 III
 * @author 曾奕
 */
public class Test337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res1 = root.val;
        if (root.left != null) {
            res1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            res1 += rob(root.right.left) + rob(root.right.right);
        }
        int res2 = rob(root.left) + rob(root.right);
        return Math.max(res1, res2);
    }
}
