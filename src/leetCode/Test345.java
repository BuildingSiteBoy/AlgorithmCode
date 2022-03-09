package leetCode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 双指针
 * 345. 反转字符串中的元音字符
 * @author 曾奕
 */
public class Test345 {
    public static void main(String[] args) {
        Solution345 s = new Solution345();
        System.out.println(s.reverseVowels("leetCodeooooiiiiuuu"));
    }
}

class Solution345 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O'));

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] res = new char[s.length()];

        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (!vowels.contains(ci)) {
                res[i++] = ci;
            } else if (!vowels.contains(cj)) {
                res[j--] = cj;
            } else {
                res[i++] = cj;
                res[j--] = ci;
            }
        }

        return new String(res);
    }
}
