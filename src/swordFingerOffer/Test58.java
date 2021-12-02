package swordFingerOffer;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * */

public class Test58 {
    public static void main(String[] args) {
        String s = "abcdefgh";
        String str;

        System.out.println(new Solution58_02_2().reverseLeftWords(s, 3));
        System.out.println(new Solution58_02().reverseLeftWords(s, 3));
    }
}

class Solution58_01 {
    public String reverseWords(String s) {
        //将字符串按空格拆分
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        //从后往前遍历
        for (int i = str.length; i >= 0; i--) {
            //可能会有连续多个空格
            if (str[i].equals(""))
                continue;

            if (i == 0)
                sb.append(str[i]);
            else
                sb.append(str[i]).append(" ");
        }

        return sb.toString();
    }
}

class Solution58_02 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

class Solution58_02_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt((i + n) % s.length()));
        }

        return sb.toString();
    }
}