package leetCode;

public class Test141 {
    public static void main(String[] args) {

    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode l1 = head, l2 = head.next;

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

class ListNode {
    ListNode node;
    ListNode next;
}