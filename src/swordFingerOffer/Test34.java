package swordFingerOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * DFS、回溯算法
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 算法思想：先序遍历 + 回溯算法（路径记录）
 * */

public class Test34 {
    public static void main(String[] args) {

    }
}

class Solution34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        helper(root, target);
        return res;
    }

    private void helper(TreeNode root, int target) {
        if (root == null)
            return;

        path.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<>(path));

        helper(root.left, target);
        helper(root.right, target);

        path.removeLast();      //回溯
    }
}