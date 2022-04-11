package leetCode;

/**
 * 696. 计数二进制子串
 * 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
 * @author 曾奕
 */
public class Test696 {
    public int countBinarySubstrings(String s) {
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}
