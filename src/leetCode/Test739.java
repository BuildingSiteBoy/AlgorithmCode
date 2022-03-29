package leetCode;

import java.util.Stack;

/**
 * 739. 每日温度: 数组中元素与下一个比它大的元素之间的距离
 * 在遍历数组时用栈把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，
 * 说明栈顶元素的下一个比它大的数就是当前元素。
 * @author 曾奕
 */
public class Test739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!index.isEmpty() && temperatures[i] > temperatures[index.peek()]) {
                int pre = index.pop();
                dist[pre] = i - pre;
            }
            index.add(i);
        }
        return dist;
    }
}
