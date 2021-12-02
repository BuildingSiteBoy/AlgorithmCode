package swordFingerOffer;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * */

public class Test55 {
    public static void main(String[] args) {

    }
}

class Solution55_01 {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}

class Solution55_02 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode tree) {
        if (tree == null)
            return 0;

        return Math.max(dfs(tree.left), dfs(tree.right)) + 1;
    }
}