package leetCode;

/**
 * 357. 统计各位数字都不同的数字个数
 * 排列组合
 * n == 0; res = 1; n == 1; res = 10;
 * n == 2; 十位有1 ~ 9（9种情况），而个位有除去十位有的0 ~ 9（9种情况），再加上n == 1的 10种情况；
 * n == 3, 4, 5,,, 以此类推
 * @author 曾奕
 */
public class Test357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        // res用于记录结果，cur用于记录现在n有多少种情况
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}
