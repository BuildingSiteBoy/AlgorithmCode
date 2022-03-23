package leetCode;

/**
 * 数据结构：树
 * 226. 翻转二叉树
 * @author 曾奕
 */
public class Test226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
