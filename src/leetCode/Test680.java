package leetCode;

/**
 * 双指针
 * 680. 回文字符串
 * 可以删除一个字符，判断是否能构成回文字符串
 * @author 曾奕
 */
public class Test680 {
    public static void main(String[] args) {
        Solution680 s = new Solution680();
        System.out.println(s.validPalindrome("abca"));
    }
}

class Solution680 {
    public boolean validPalindrome(String s) {
        int i = -1;
        int j = s.length();

        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
