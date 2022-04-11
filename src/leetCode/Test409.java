package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 409. 最长回文串
 * 使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
 * 因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。
 * @author 曾奕
 */
public class Test409 {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int res = 0;
        for (int n : count) {
            // 统计偶数个数字
            res += (n / 2) * 2;
        }
        if (res < s.length()) {
            // 条件满足说明又多余的字符，可添加到回文的正中间
            res++;
        }
        return res;
    }
}
