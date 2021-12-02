package leetCode;

/**
 * 递归、回溯
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * */

public class Test21 {
    public static void main(String[] args) {

    }
}

class ListNode21 {
    int val;
    ListNode21 next;
    ListNode21() {
    }
    ListNode21(int val) {
        this.val = val;
    }
    ListNode21(int val, ListNode21 next) {
        this.val = val; this.next = next;
    }
}

class Solution21 {
    public ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode21 res = new ListNode21(0);
        ListNode21 cur = res;

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

        if (l1 == null)
            cur.next = l2;
        else
            cur.next = l1;

        return res.next;
    }
}