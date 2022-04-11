package job;

import java.util.Scanner;

/**
 * 第N位数字
 *
 * 存在无限正整数序列 1,2,3,4,5,6,7,8,9,10,11...，将其中数字按位拆分（例如43拆分为4,3，123拆分为1,2,3）后形成新的数列p。求数列p中第n位数字。
 *
 * 注意：n 是正数且在 32 位整数范围内。
 *
 * 输入：输入数字n
 * 输出：输出序列p中第n位数字
 * @author zZeng
 */
public class Test0409AiShu {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = new Solution().findNdigit(_n);
        System.out.println(String.valueOf(res));

    }
}

class Solution {
    public int findNdigit(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if (sb.length() > n + 1) {
                System.out.println(sb.length());
                break;
            }
            sb.append(i);
        }
        return sb.charAt(n) - '0';
    }
}
