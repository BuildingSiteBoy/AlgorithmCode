package swordFingerOffer;

/*
* 复杂链表的复制
* 请实现 copyRandomList 函数，复制一个复杂链表。
* 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
* 还有一个 random 指针指向链表中的任意节点或者 null。
* */

import java.util.HashMap;
import java.util.Map;

public class Test35 {
    public static void main(String[] args) {

    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

//哈希表存储原结点和可令结点的映射关系，通过映射关系处理克隆结点的random指针；
// 时间空间复杂度均为O(n);
class Solution35_01 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node node = head;
        Map<Node, Node> map = new HashMap<>();

        //使用hashMap存储旧结点和新结点的映射关系
        while (node != null) {
            Node clone = new Node(node.val, null, null);
            map.put(node, clone);
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}

//原地处理，将克隆结点放在原结点后面，在原链表上处理克隆结点的random指针，最后分离两个链表；
//时间复杂度O(n)，空间复杂度O(1);
class Solution35_2 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        //处理next指针
        Node node = head;
        while (node != null) {
            Node clone = new Node(node.val, node.next, null);
            Node temp = node.next;
            node.next = clone;
            clone.next = temp;
            node = node.next.next;
        }

        //处理random指针
        node = head;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }

        //分离为两个链表
        node = head;
        Node newNode = head.next;
        while (node.next != null) {
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }

        return newNode;
    }
}