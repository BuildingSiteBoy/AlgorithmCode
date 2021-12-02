package leetCode;

//Test116: 完美二叉树
public class TreeNode116 {
    int val;
    TreeNode116 left;
    TreeNode116 right;
    TreeNode116 next;

    public TreeNode116() {
    }

    public TreeNode116(int val) {
        this.val = val;
    }

    public TreeNode116(int val, TreeNode116 left,
                       TreeNode116 right, TreeNode116 next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
