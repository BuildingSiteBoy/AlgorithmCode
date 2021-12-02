package swordFingerOffer;

import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 剑指 Offer 32. 从上到下打印二叉树
 *  1、
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  2、
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  3、
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * */

public class Test32 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[] res1 = new Solution32_01().levelOrder(root);
        for (int n : res1) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println(new Solution32_03().levelOrder(root));
    }
}

class Solution32_01 {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];

        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //层序遍历，开始遍历
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

        //return list.stream().mapToInt(Integer::intValue).toArray();
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;
    }
}

//利用队列来进行BFS
class Solution32_02 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();

            //开始遍历
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                //获取子结点的值
                TreeNode node = queue.poll();
                temp.add(node.val);

                //获取该结点的左右子结点
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            res.add(temp);
        }

        return res;
    }
}

class Solution32_03 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (root != null)
            stack1.push(root);

        boolean flag = true;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) {
                ArrayList<Integer> temp = new ArrayList<>();

                int l = stack1.size();
                for (int i = 0; i < l; i++) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);

                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }

                flag = false;
                res.add(temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();

                int l = stack2.size();
                for (int i = 0; i < l; i++) {
                    TreeNode node = stack2.pop();
                    temp.add(node.val);

                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                }

                flag = true;
                res.add(temp);
            }
        }

        return res;
    }
}

//test03：递归方法
class Solution32_03_02 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper (TreeNode root, int level) {
        if (root == null)
            return;

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}