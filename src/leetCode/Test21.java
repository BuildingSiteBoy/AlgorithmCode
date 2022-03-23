package leetCode;

/**
 * 数据结构：链表
 * 递归、回溯
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author 曾奕
 * */
public class Test21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode res = new ListNode(0);
        ListNode cur = res;

        //不能用：||，会出现空指针异常
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return res.next;
    }

    public ListNode mergeTwoListsE(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // 递归
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsE(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsE(l1, l2.next);
            return l2;
        }
    }
}
