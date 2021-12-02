package swordFingerOffer;

/**
 * DFS/BFS
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * */

public class Test54 {
    public static void main(String[] args) {

    }
}

class Solution54 {
    private int res = 0, count = 0;

    public int kthLargest(TreeNode root, int k) {
        inTraversal(root, k);
        return res;
    }

    //遍历顺序为：右中左，遍历出来的值从大到小排列！！！
    private void inTraversal(TreeNode root, int k) {
        if (root.right != null)
            inTraversal(root.right, k);

        if (++count == k) {
            res = root.val;
            return;
        }

        if (root.left != null)
            inTraversal(root.left, k);
    }
}