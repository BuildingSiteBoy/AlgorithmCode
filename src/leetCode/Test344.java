package leetCode;

//反转字符串

public class Test344 {
    public static void main(String[] args) {
        char[] s = {'z', 'e', 'n', 'g'};
        new Solution344().reverseString(s);
        System.out.println(s);
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }
    }
}
