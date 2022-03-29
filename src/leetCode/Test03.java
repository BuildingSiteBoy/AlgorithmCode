package leetCode;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
* 3. 无重复字符的最长子串
*   给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
*
 * @author 曾奕
 * */
public class Test03 {
    public static void main(String[] args) {
        String s = "abcabcb";
        System.out.println(new Solution03().lengthOfLongestSubstring(s));
        System.out.println(new Solution03_02().lengthOfLongestSubstring(s));
    }
}

class Solution03 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        //map集合用于存储字符上一次出现的位置
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int start = 0;      //记录窗口开始位置
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}

class Solution03_02 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        //index数组用于存储字符上一次出现的位置
        int[] index = new int[128];

        int max = 0;
        int start = 0;      //记录窗口开始位置
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, index[s.charAt(i)]);
            max = Math.max(max, i - start + 1);
            index[s.charAt(i)] = i + 1;
        }

        return max;
    }
}
