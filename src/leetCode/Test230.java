package leetCode;

/**
 * 230. Kth Smallest Element in a BST (Medium)
 * @author 曾奕
 */
public class Test230 {
    private int count = 0;
    private int val;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
            return;
        }
        inOrder(root.right, k);
    }

    public int kthSmallestE(TreeNode root, int k) {
        int leftCount = count(root.left);
        if (leftCount == k - 1) {
            return root.val;
        }
        if (leftCount > k - 1) {
            return kthSmallestE(root.left, k);
        }
        return kthSmallestE(root.right, k - leftCount - 1);
    }

    private int count(TreeNode left) {
        if (left == null) {
            return 0;
        }
        return 1 + count(left.left) + count(left.right);
    }
}
