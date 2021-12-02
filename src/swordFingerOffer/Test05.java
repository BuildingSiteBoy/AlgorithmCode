package swordFingerOffer;

/**
 * 05.替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * */

public class Test05 {
    public static void main(String[] args) {
        String s = "I love you !!!";
        String str = s.replace(" ", "%20");
        System.out.println(str);

        System.out.println(new Solution05().replaceSpace(s));
    }
}

class Solution05 {
    public String replaceSpace(String s) {
        //return s.replace(" ", "%20");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}