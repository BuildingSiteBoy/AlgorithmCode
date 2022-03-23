package leetCode;

/**
 * 贪心算法/双指针
 * 392. 判断子序列
 * @author 曾奕
 */
public class Test392 {
    public boolean isSubSequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针解法
     * @param s
     * @param t
     * @return
     */
    public boolean isSub(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
