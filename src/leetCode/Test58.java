package leetCode;

/*
* 最后一个单词的长度
* */

public class Test58 {
    public static void main(String[] args) {
        String s = "wo shi ni baba";

        System.out.println(new Solution58().lengthOfLastWord(s));
    }
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                length++;
            else
                break;
        }

        return length;
    }
}