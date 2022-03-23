package leetCode;

/**
 * 数据结构：链表
 * 83. 删除排序链表中的重复元素
 * @author 曾奕
 */
public class Test83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicatesE(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicatesE(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
