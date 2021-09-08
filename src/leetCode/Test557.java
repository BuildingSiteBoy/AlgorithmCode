package leetCode;

/*
* 反转字符串中的单词
* 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
* */

public class Test557 {
    public static void main(String[] args) {
        String s = "Let`s take LeetCode contest!!!";

        //System.out.println(new Solution557_01().reverseWords(s));
        System.out.println(new Solution557_02().reverseWords(s));
    }
}

class Solution557_01 {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();

        int n = str.length;
        int low = 0, high = 0;

        while (high <= n) {
            if (high == n || str[high] == ' ') {
                reverse(str, low, high - 1);
                low = high + 1;
            }

            high++;
        }

        return new String(str);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char c = s[start];
            s[start++] = s[end];
            s[end--] = c;
        }
    }
}

class Solution557_02 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            if (i == 0) {
                sb.append(new StringBuffer(strings[i]).reverse());
            } else {
                sb.append(" " + new StringBuffer(strings[i]).reverse());
            }
        }

        return sb.toString();
    }
}