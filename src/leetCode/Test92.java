package leetCode;

import swordFingerOffer.ListNode;

/**
 * 92. 反转链表 II
 * @author 曾奕
 */
public class Test92 {
    public ListNode92 reverseBetween(ListNode92 head, int left, int right) {
        ListNode92 dummyNode = new ListNode92(-1);
        dummyNode.next = head;

        ListNode92 pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode92 rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode92 leftNode = pre.next;
        ListNode92 curr = rightNode.next;
        pre.next = null;
        rightNode.next = null;

        reverseList(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseList(ListNode92 head) {
        ListNode92 pre = null;
        ListNode92 cur = head;

        while (cur != null) {
            ListNode92 next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}

class ListNode92 {
    int val;
    ListNode92 next;
    ListNode92() {}
    ListNode92(int val) { this.val = val; }
    ListNode92(int val, ListNode92 next) { this.val = val; this.next = next; }
}
