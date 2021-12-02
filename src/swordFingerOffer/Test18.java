package swordFingerOffer;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * */

public class Test18 {
    public static void main(String[] args) {

    }
}

class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;

        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                break;
            }
            pre = node;
            node = node.next;
        }

        return head;
    }
}