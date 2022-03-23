package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：Backtracking
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * @author 曾奕
 */
public class Test17 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void doCombination(StringBuilder pre, List<String> combinations, final String digits) {
        if (pre.length() == digits.length()) {
            combinations.add(pre.toString());
            return;
        }
        int curDigit = digits.charAt(pre.length()) - '0';
        String letters = KEYS[curDigit];
        for (char c : letters.toCharArray()) {
            // 回溯算法：添加
            pre.append(c);
            doCombination(pre, combinations, digits);
            // 回溯算法：删除
            pre.deleteCharAt(pre.length() - 1);
        }
    }
}
