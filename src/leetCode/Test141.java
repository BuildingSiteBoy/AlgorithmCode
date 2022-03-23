package leetCode;

import swordFingerOffer.ListNode;

/**
 * 双指针
 * 141. 判断链表是否存在环
 * 一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇
 * @author 曾奕
 */
public class Test141 {
    public static void main(String[] args) {

    }
}

class Solution141 {
    public boolean hasCycle(ListNode141 head) {
        if (head == null) {
            return false;
        }

        ListNode141 l1 = head, l2 = head.next;

        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }

            l1 = l1.next;
            l2 = l2.next.next;
        }

        return false;
    }
}

class ListNode141 {
    ListNode141 node;
    ListNode141 next;
}
