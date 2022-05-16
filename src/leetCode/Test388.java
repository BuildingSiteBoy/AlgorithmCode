package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 388. 文件的最长绝对路径
 * @author 曾奕
 */
public class Test388 {
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (pos < n) {
            // 检测深度
            int depth = 1;
            while(pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }

            // 检测长度
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }

            // 跳过换行符
            pos++;

            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                res = Math.max(res, len);
            } else {
                stack.push(len);
            }
        }

        return res;
    }
}
