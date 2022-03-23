package leetCode;

/**
 * 数据结构：链表
 * @author zZeng
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
