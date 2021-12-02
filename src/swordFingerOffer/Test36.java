package swordFingerOffer;

/**
 * DFS
 * 剑指Offer36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * */

public class Test36 {
    public static void main(String[] args) {

    }
}

class Node36 {
    public int val;
    public Node36 left;
    public Node36 right;

    public Node36() {}

    public Node36(int _val) {
        val = _val;
    }

    public Node36(int _val,Node36 _left,Node36 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class Solution36 {
    Node36 pre, head;

    public Node36 treeToDoublyList(Node36 root) {
        if (root == null)
            return null;

        dfs(root);

        //处理头尾结点
        head.left = pre;
        pre.right = head;

        return head;

    }

    private void dfs(Node36 root) {
        if (root == null)
            return;

        dfs(root.left);

        if (pre != null)
            pre.right = root;
        else
            head = root;

        root.left = pre;
        pre = root;

        dfs(root.right);
    }
}