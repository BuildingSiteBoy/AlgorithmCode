package leetCode;

/**
 * 双指针
* 19. 删除链表的倒数第 N 个结点
*   给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
* */

public class Test19 {
    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode876 list = new ListNode876(nums[0]);
        ListNode876 node = list;

        for (int i = 1; i < nums.length ; i++) {
            node.next = new ListNode876(nums[i]);
            node = node.next;
        }
        System.out.println();

        printTest19(list);

        //printTest19(new Solution19_01().removeNthFromEnd(list, 3));
        printTest19(new Solution19_02().removeNthFromEnd(list, 7));
    }

    public static void printTest19(ListNode876 head) {
        ListNode876 node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

//双指针方法
class Solution19_01 {
    public ListNode876 removeNthFromEnd(ListNode876 head, int n) {
        ListNode876 left = head, right = head;

        while (n != 0) {
            right = right.next;
            n--;        //先让right指针先走n步
        }

        if (right == null) {    //当删除第一个结点时，直接返回头节点后一个结点
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return head;
    }
}


//求链表长度
class Solution19_02 {
    public ListNode876 removeNthFromEnd(ListNode876 head, int n) {
        ListNode876 node = head;
        int count = 0;

        while (node.next != null) {
            node = node.next;
            count++;            //计算链表长度
        }

        if (n > count) {
            return head.next;
        }

        node = head;
        for (int i = 0; i < count - n; i++) {
            node = node.next;   //定位
        }

        node.next = node.next.next;
        return head;
    }
}