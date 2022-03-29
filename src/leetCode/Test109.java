package leetCode;

/**
 * 109. 有序链表转换二叉搜索树
 * @author 曾奕
 */
public class Test109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode preMid(ListNode head) {
        ListNode pre = head, aft = head.next;
        ListNode res = head;
        while (aft != null && aft.next != null) {
            res = pre;
            pre = pre.next;
            aft = aft.next.next;
        }
        return res;
    }
}
