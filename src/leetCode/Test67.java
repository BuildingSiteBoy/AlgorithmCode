package leetCode;

/*
* 67.二进制求和
* 给你两个二进制字符串，返回它们的和（用二进制表示）。
* */

public class Test67 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(new Solution67().addBinary(a, b));
    }
}

class Solution67 {
    public String addBinary(String a, String b) {
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                c += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                c += b.charAt(j--) - '0';
            }
            //System.out.println(c);

            sb.append(c % 2);
            c /= 2;
        }

        return c == 1 ? "1" + sb.reverse().toString() : sb.reverse().toString();
    }
}