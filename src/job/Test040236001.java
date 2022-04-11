package job;

import java.util.Scanner;

/**
 * 合法名字
 *
 * 现在的调查问卷越来越多了，所以出现了很多人恶意刷问卷的情况，已知某问卷需要填写名字，如果名字仅由大小写英文字母组成且长度不超过10，则我们认为这个名字是真实有效的，否则就判定为恶意填写问卷。
 *
 * 请你判断出由多少有效问卷（只要名字是真实有效的，就认为问卷有效）。
 *
 * 输入第一行包含一个正整数n，表示收到的问卷数量。(1<=n<=2000)
 *
 * 接下来有n行，每行有一个由大小写英文字母，数字，下划线组成的字符串，分别表示一份问卷的名字，字符串长度不超过100。
 *
 * 输出只有一个整数，表示有效问卷数量。
 * @author zZeng
 */
public class Test040236001 {
    public static void main(String[] args) {
        // 记录结果
        int res = 0;

        Scanner in = new Scanner(System.in);
        // 输入数据
        int n = in.nextInt();
        // 接收换行符
        in.nextLine();
        for (int i = 0; i < n; i++) {
            if (isName(in.nextLine())) {
                res++;
            }
        }

        System.out.println(res);
    }

    private static boolean isName(String str) {
        if (str.length() < 1 || str.length() > 10) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
