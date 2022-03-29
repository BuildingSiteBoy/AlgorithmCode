package leetCode;

/**
 * 671. 二叉树中第二小的节点
 * @author 曾奕
 */
public class Test671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }

        int lVal = root.left.val;
        int rVal = root.right.val;
        if (lVal == root.val) {
            lVal = findSecondMinimumValue(root.left);
        }
        if (rVal == root.val) {
            rVal = findSecondMinimumValue(root.right);
        }
        if (lVal != -1 && rVal != -1) {
            return Math.min(lVal, rVal);
        } else if (lVal != -1) {
            return lVal;
        } else {
            return rVal;
        }
    }
}
