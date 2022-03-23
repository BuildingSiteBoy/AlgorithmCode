package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据结构：链表
 * 234. 回文链表
 *
 * @author 曾奕
 */
public class Test234 {
    public boolean isPalindrome(ListNode head) {
        // 将链表数据复制到数组上
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        // 利用双指针判断是否为回文
        int l = 0, h = nums.size() - 1;
        while (l < h) {
            if (!nums.get(l++).equals(nums.get(h--))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeE(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 偶数结点，让slow指向下一个结点
        if (fast != null) {
            slow = slow.next;
        }
        cut(head, slow);
        return isEqual(head, reverse(slow));
    }

    private void cut(ListNode head, ListNode slow) {
        while (head.next != slow) {
            head = head.next;
        }
        head.next = null;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }
}
