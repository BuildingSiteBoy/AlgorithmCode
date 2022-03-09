package leetCode;

import java.util.List;

/**
 * 双指针
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 d，找出并返回 d中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *  如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 * @author 曾奕
 */
public class Test524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String target : dictionary) {
            int m = longestWord.length(), n = target.length();
            if (m > n || (m == n && longestWord.compareTo(target) < 0)) {
                continue;
            }

            if (isValid(s, target)) {
                longestWord = target;
            }
        }

        return longestWord;
    }

    private boolean isValid(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == target.length();
    }
}
