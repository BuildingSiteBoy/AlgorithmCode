package job;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zZeng
 */
public class Test0416OKYunLian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = "(1+(2*3)+((8)/4))+1";
        System.out.println(new Test0416OKYunLian().maxDepth(str));

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace(",", "");
        paragraph = paragraph.replace(".", "");
        String[] strs = paragraph.split(" ");
        for (String s : strs) {
            System.out.println(s);
        }
    }

    /**
     * 括号的最大嵌套深度
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串 字符串
     * @return int整型
     */
    public int maxDepth (String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                max = Math.max(max, stack.size());
            }
            if (c == ')') {
                stack.pop();
            }
        }
        return max;
    }

    /**
     * 第二题SQL题：成绩第二名
     *  select score as SecondHighestSalary
     * from student
     * order by score
     * limit 1, 1;
     */
}
