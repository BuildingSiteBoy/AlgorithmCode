package leetCode;

/**
 * 479. 最大回文数乘积
 * @author 曾奕
 */
public class Test479 {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        int max = (int) Math.pow(10, n) - 1;
        int res = 0;
        for (int i = max; res == 0; i--) {
            long p = i;
            for (int x = i; x > 0; x /= 10) {
                // 翻转左半部分到其自身末尾，构造回文数p
                p = p * 10 + x % 10;
            }
            for (long x = max; x * x >= p; x--) {
                // 判断是否能分解成两个n位的整数
                if (p % x == 0) {
                    res = (int) (p % 1337);
                    break;
                }
            }
        }
        return res;
    }
}
