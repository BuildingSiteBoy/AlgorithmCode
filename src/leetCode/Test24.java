package leetCode;

/**
 * 数据结构：链表
 * 24. 两两交换链表中的节点
 *
 * @author 曾奕
 */
public class Test24 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode aft = l2.next;
            l1.next = aft;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return node.next;
    }
}
