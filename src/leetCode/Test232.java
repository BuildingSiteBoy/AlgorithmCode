package leetCode;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 232. Implement Queue using Stacks (Easy)
 * @author 曾奕
 */
public class Test232 {

}

class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    private void inToOut() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public int pop() {
        inToOut();
        return out.pop();
    }

    public int peek() {
        inToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
