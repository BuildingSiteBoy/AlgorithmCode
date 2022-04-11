package leetCode;

/**
 * 667. 优美的排列 II
 * 数组相邻差值的个数
 * @author 曾奕
 */
public class Test667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1, val = k; i <= k; i++, val--) {
            res[i] = i % 2 == 1 ? res[i - 1] + val : res[i - 1] - val;
        }
        for (int i = k + 1; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
