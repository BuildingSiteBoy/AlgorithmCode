package leetCode;

/**
 * 821. 字符的最短距离
 * 问题可以转换成，对 s 的每个下标 i，求
 *      s[i] 到其左侧最近的字符 c 的距离
 *      s[i] 到其右侧最近的字符 c 的距离
 *
 *
 * @author 曾奕
 */
public class Test821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];

        // 从左至右遍历
        for (int i = 0, index = -n; i < n; i++) {
            if (s.charAt(i) == c) {
                index = i;
            }
            res[i] = i - index;
        }

        // 从右至左遍历
        for (int i = n - 1, index = 2 * n; i >= 0; i--) {
            if (s.charAt(i) == c) {
                index = i;
            }
            res[i] = Math.min(res[i], index - i);
        }

        return res;
    }
}
