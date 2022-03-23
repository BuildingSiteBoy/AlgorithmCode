package leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 数据结构：链表
 * 445. 两数相加 II
 * @author 曾奕
 */
public class Test445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            ListNode node = new ListNode(cur % 10);
            node.next = res;
            res = node;
        }
        return res;
    }
}
