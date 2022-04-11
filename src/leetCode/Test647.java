package leetCode;

/**
 * 647. 回文子串
 * 回文子字符串个数
 * @author 曾奕
 */
public class Test647 {
    private int res = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 统计奇数个字符回文
            helper(s, i, i);
            // 统计偶数个字符的回文
            helper(s, i, i + 1);
        }
        return res;
    }

    private void helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
    }
}
