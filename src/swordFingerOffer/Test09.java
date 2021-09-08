package swordFingerOffer;

import java.util.Deque;
import java.util.LinkedList;

/*
* 剑指Offer 09.
* 用两个栈实现一个队列。
* 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
* 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
* (若队列中没有元素，deleteHead 操作返回 -1 )
* */

public class Test09 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();

        queue.appendTail(12);
        queue.appendTail(13);
        queue.appendTail(14);

        queue.deleteHead();

        queue.appendTail(15);

        queue.deleteHead();

        System.out.println(queue);
    }
}

class CQueue {
    Deque<Integer> stack1;      //接口代表着双向队列，意思就是可以从队列的两端增加或者删除元素，Deque就是双向Queue的意思
    Deque<Integer> stack2;

    public CQueue () {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        //如果第2个栈是空栈
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            return -1;      //将栈1中元素压入还为0，说明此为空栈
        } else {
            return stack2.pop();
        }
    }

    @Override
    public String toString() {
        return "CQueue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}
