package leetCode;

/**
 * 数据结构：链表
 * 725. 分隔链表
 *
 * @author 曾奕
 */
public class Test725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int mod = len % k;
        int size = len / k;
        ListNode[] res = new ListNode[k];
        cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            int nowSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < nowSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
