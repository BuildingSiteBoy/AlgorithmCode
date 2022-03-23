package leetCode;

/**
 * 数据结构：树
 * 101. 对称二叉树
 * @author 曾奕
 */
public class Test101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
}
