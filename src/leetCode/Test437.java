package leetCode;

/**
 * 数据结构：树
 * 437. 路径总和 III
 * @author 曾奕
 */
public class Test437 {
    public int pathSum(TreeNode root, int targetSum) {
        return root == null ? 0 : pathRoot(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int pathRoot(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res++;
        }
        res += pathRoot(root.left, targetSum - root.val) + pathRoot(root.right, targetSum - root.val);
        return res;
    }
}
