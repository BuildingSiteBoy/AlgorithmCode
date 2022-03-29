package leetCode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 如果根结点的值比两个值都大，则结果在左子树；
 * 如果根节点的值比两个值都小，则结果在右子树
 * @author 曾奕
 */
public class Test235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
