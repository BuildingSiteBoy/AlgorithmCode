package swordFingerOffer;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * */

public class Test22 {
    public static void main(String[] args) {

    }
}

class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode right = head;
        ListNode left = head;

        while (k > 0) {
            right= right.next;
            k--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        return left;
    }
}