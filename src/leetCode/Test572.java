package leetCode;

/**
 * 数据结构：树
 * 572. 另一棵树的子树
 * @author 曾奕
 */
public class Test572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSubtreeRoot(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSubtreeRoot(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isSubtreeRoot(root.left, subRoot.left) && isSubtreeRoot(root.right, subRoot.right);
    }
}
