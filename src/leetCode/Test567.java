package leetCode;

import java.util.Arrays;

/**
 * 滑动窗口、双指针
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
* */
public class Test567 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aadsfasdfasdfadadbca";

        System.out.println(new Solution567_01().checkInclusion(s1, s2));
        System.out.println(new Solution567_02().checkInclusion(s1, s2));
    }
}

//滑动窗口
class Solution567_01 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m)
            return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++arr1[s1.charAt(i) - 'a'];
            ++arr2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(arr1, arr2))
            return true;

        for (int i = n; i < m; i++) {
            //从第n个字符开始逐一往后检查
            ++arr2[s2.charAt(i) - 'a'];
            --arr2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(arr1, arr2))
                return true;
        }

        return false;
    }
}

//双指针
class Solution567_02 {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n)
            return false;

        int[] arr = new int[26];
        for (int i = 0; i < m; i++)
            arr[s1.charAt(i) - 'a']--;

        int start = 0;
        for (int i = 0; i < n; i++) {
            int x = s2.charAt(i) - 'a';
            arr[x]++;
            while (arr[x] > 0) {    //有一个元素不符合就将开始的指针移到现在的位置
                arr[s2.charAt(start) - 'a']--;
                start++;
            }
            if (i - start + 1 == m)
                return true;
        }

        return false;
    }
}