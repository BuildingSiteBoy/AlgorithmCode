package leetCode;

/**
 * 位运算
 * 191.位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * */

public class Test191 {
    public static void main(String[] args) {
        System.out.println(new Solution191().hammingWeight(11));
        System.out.println(new Solution191().hammingWeight(32));
        System.out.println(new Solution191().hammingWeight(3));

        System.out.println(2 >> 1);
        System.out.println(1 >> 1);
    }
}

class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

/*        while (n > 0) {
            if (n % 2 == 1)
                count++;
            n = n >> 1;
        }*/

        for (int i = 1; i <= 32; i++) {
            count += n & 1;
            n >>= 1;
        }

        return count;
    }
}