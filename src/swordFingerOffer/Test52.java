package swordFingerOffer;

/**
 * 双指针
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * */

public class Test52 {
    public static void main(String[] args) {

    }
}

class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }

        return l1;
    }
}