package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 数据结构：链表
 * 160. 相交链表
 * @author 曾奕
 */
public class Test160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA, lb = headB;
        while (la != lb) {
            la = (la == null) ? headB : la.next;
            lb = (lb == null) ? headA : lb.next;
        }
        return la;
    }

    public ListNode getIntersectionNodeE(ListNode headA, ListNode headB) {
        // 用哈希集合存储链表节点
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp !=  null) {
            visited.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
