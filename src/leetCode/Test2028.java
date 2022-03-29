package leetCode;

/**
 * 2028. 找出缺失的观测数据
 * @author 曾奕
 */
public class Test2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int curSum = 0;
        for (int num : rolls) {
            curSum += num;
        }

        int misSum = mean * (n + rolls.length) - curSum;
        if (misSum < n || misSum > 6 * n) {
            return new int[0];
        }
        int x = misSum / n, y = misSum % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = x + (y-- > 0 ? 1 : 0);
        }
        return res;
    }
}
