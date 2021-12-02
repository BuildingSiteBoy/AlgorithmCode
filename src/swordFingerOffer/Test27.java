package swordFingerOffer;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * */

public class Test27 {
    public static void main(String[] args) {

    }
}

//递归
class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
}