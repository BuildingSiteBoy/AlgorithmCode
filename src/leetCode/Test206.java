package leetCode;

/**
 * 数据结构：链表
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 解题思路：
 *  使用头插法来重新建立链表
 *
 * @author 曾奕
 * */
public class Test206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        //ListNode res = new ListNode();    错误：已初始化，会赋值为0
        ListNode res = null;

        while (head != null) {
            ListNode p = head;
            head = head.next;

            p.next = res;
            res = p;
        }

        return res;
    }

    public ListNode reverseListE(ListNode head) {
          if (head == null || head.next == null) {
              return head;
          }
          ListNode next = head.next;
          ListNode newHead = reverseList(next);
          next.next = head;
          head.next = null;
          return newHead;
    }
}
