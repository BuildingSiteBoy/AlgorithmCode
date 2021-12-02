package leetCode;

/**
 * 位运算
 * 231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。
 * 如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * */

public class Test231 {
    public static void main(String[] args) {
        System.out.println(new Solution231().isPowerOfTwo(16));
        System.out.println(new Solution231().isPowerOfTwo(8));
    }
}

class Solution231 {
    public boolean isPowerOfTwo(int n) {
        /*if (n == 1 || n == -1)
            return true;

        while (n > 1) {
            n = n >> 1;
            System.out.println(n);
        }

        if (n == 1)
            return false;
        return true;*/

        return n > 0 && (n & n - 1) == 0;
    }
}