package swordFingerOffer;

/*
* 反转链表
* 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
* */

public class Test24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(13);
        ListNode node = listNode;
        int[] arr = new int[]{14, 15, 16, 17, 18, 19, 20};
        for (int i = 0; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }

        ListNode list = listNode;
        while (list.next != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }

        System.out.println();
        System.out.println("---------------");

        ListNode res = new Solution24().reverseList(listNode);
        while (res.next != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}

class Solution24 {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode node = head;
        ListNode beforeNode;

        while (node != null) {
            beforeNode = node;
            node = node.next;
            beforeNode.next = res;
            res = beforeNode;
        }

        return res;
    }
}
