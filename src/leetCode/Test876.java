package leetCode;

/**
 * 双指针
* 链表的中间结点：
*   给定一个头结点为 head 的非空单链表，返回链表的中间结点。
*   如果有两个中间结点，则返回第二个中间结点。
* */

public class Test876 {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode876 list = new ListNode876(nums[0]);
        ListNode876 node = list;

        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode876(nums[i]);
            node = node.next;
        }

        node = list;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        System.out.println(new Solution876().middleNode(list).val);
        System.out.println(new Solution876_02().middleNode(list).val);
    }
}

class ListNode876 {
    int val;
    ListNode876 next;
    ListNode876() {}
    ListNode876(int val) { this.val = val; }
    ListNode876(int val, ListNode876 next) { this.val = val; this.next = next; }
}

class Solution876 {
    public ListNode876 middleNode(ListNode876 head) {
        if (head == null)
            return null;

        ListNode876 node = head;
        int count = 1;
        while (node.next != null) {
            node = node.next;
            count++;        //求链表总长
        }

        node = head;
        for (int i = 0; i < count / 2; i++) {
            node = node.next;
        }

        return node;
    }
}

class Solution876_02 {
    public ListNode876 middleNode (ListNode876 head) {
        if (head == null)
            return null;

        //快慢双指针
        ListNode876 fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}