package leetCode;

/**
 * 530. 二叉搜索树的最小绝对差
 * 利用二叉查找树的中序遍历为有序的性质，计算中序遍历中临近的两个节点之差的绝对值，取最小值。
 * @author 曾奕
 */
public class Test530 {
    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        inOrder(root.right);
    }
}
