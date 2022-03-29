package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues (Easy)
 * @author 曾奕
 */
public class Test225 {
}

class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int count = queue.size();
        while (count-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
