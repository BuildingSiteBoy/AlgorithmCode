package leetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 * 使用队列解题：初始条件从队首到队尾的时间值是单调递增的
 * @author 曾奕
 */
public class Test933 {
}

class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
