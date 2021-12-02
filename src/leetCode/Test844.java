package leetCode;

import java.util.Stack;

/**
 * 双指针
 * 844. 比较含退格的字符串
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * */

public class Test844 {
    public static void main(String[] args) {
        System.out.println(new Solution844_01().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new Solution844_02().backspaceCompare("ab#c", "ad#c"));
    }
}

class Solution844_01 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> tt = new Stack<>();

        createSta(ss, s);
        createSta(tt, t);

        while (!ss.isEmpty() && !tt.isEmpty()){
            if (ss.peek() != tt.peek())
                return false;

            ss.pop();
            tt.pop();
        }

        return ss.isEmpty() && tt.isEmpty();
    }

    private void createSta(Stack<Character> stack, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
    }
}

class Solution844_02 {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int pi = 0, pj = 0;

        while (i >= 0 || j >= 0) {
            //清楚s退格
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    pi++;
                    i--;
                } else if (pi > 0) {
                    pi--;
                    i--;
                } else {
                    break;
                }
            }

            //清楚t退格
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    pj++;
                    j--;
                } else if (pj > 0) {
                    pj--;
                    j--;
                } else {
                    break;
                }
            }

            //退格完成后，判断两字符是否相等
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >=0 || j >= 0) {
                    return false;
                }
            }

            i--;
            j--;
        }

        return true;
    }

    //退格操作
}