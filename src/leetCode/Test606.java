package leetCode;

/**
 * 606. 根据二叉树创建字符串
 * @author 曾奕
 */
public class Test606 {
    public String tree2str(TreeNode606 root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuilder()
                    .append(root.val)
                    .append("(")
                    .append(tree2str(root.left))
                    .append(")")
                    .toString();
        }
        return new StringBuilder()
                .append(root.val)
                .append("(")
                .append(tree2str(root.left))
                .append(")(")
                .append(tree2str(root.right))
                .append(")")
                .toString();
    }
}

class TreeNode606 {
    int val;
    TreeNode606 left;
    TreeNode606 right;
    TreeNode606 next;

    public TreeNode606() {
    }

    public TreeNode606(int val) {
        this.val = val;
    }

    public TreeNode606(int val, TreeNode606 left,
                       TreeNode606 right, TreeNode606 next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
