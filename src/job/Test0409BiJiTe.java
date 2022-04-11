package job;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zZeng
 */
public class Test0409BiJiTe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 接受换行符
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            if (isGood(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isGood(String str) {
        if (str == null) {
            return true;
        }
        if (str.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
