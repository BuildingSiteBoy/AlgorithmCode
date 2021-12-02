package leetCode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 解题思路：
 *  使用头插法来重新建立链表
 * */

public class Test206 {
    public static void main(String[] args) {

    }
}

class Solution206 {
    public ListNode21 reverseList(ListNode21 head) {
        if (head == null)
            return null;

        //ListNode21 res = new ListNode21();    错误：已初始化，会赋值为0
        ListNode21 res = null;

        while (head != null) {
            ListNode21 p = head;
            head = head.next;

            p.next = res;
            res = p;
        }

        return res;
    }
}