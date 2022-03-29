package leetCode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * @author 曾奕
 */
public class Test20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cur = stack.pop();
                boolean f1 = c == ')' && cur != '(';
                boolean f2 = c == ']' && cur != '[';
                boolean f3 = c == '}' && cur != '{';
                if (f1 || f2 || f3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
