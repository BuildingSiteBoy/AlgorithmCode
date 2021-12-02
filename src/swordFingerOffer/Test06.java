package swordFingerOffer;

/*
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Test06 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(12);
        ListNode node = listNode;
        int[] arr = new int[]{13, 14, 15, 16, 17, 18, 19, 20};
        for (int i = 0; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }

        int[] nums = new Solution06().reversePrint(listNode);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

class Solution06 {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; i--, node = node.next) {
            nums[i] = node.val;
        }

        return nums;
    }
}