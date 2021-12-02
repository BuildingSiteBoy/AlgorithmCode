package swordFingerOffer;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 在字符串 s 中找出第一个只出现一次的字符。
 如果没有，返回一个单空格。 s 只包含小写字母。
 * */

public class Test50 {
    public static void main(String[] args) {
        String s = "abaccdeff";

        System.out.println(new Solution50_01().firstUniqChar(s));
        System.out.println(new Solution50_02().firstUniqChar(s));
    }
}

class Solution50_01 {
    public char firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //字母出现且之后没有再出现，返回该字母
            if (s.indexOf(c) == i && s.indexOf(c, i + 1) == -1)
                return s.charAt(i);
        }

        return ' ';
    }
}

class Solution50_02 {
    public char firstUniqChar(String s) {
        if (s.equals(""))
            return ' ';

        //数组用于存储字母出现的次数
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a']++;
        }

        //遍历数组，输出第一个出现次数为1的字母
        for (int i = 0; i < s.length(); i++) {
            if (index[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }

        return ' ';
    }
}