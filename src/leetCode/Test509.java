package leetCode;

/*
* 斐波那契数：通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
* 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
* */

public class Test509 {
    public static void main(String[] args) {
        System.out.println(new Solution509_01().fib(10));
        System.out.println(new Solution509_02().fib(10));
    }
}

//递归方法
class Solution509_01 {
    public int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }
}

//替换法：动态规划
class Solution509_02 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int x = 0, y = 1, z = 1, i = 2;
        while (i <= n) {
            z = x + y;
            x = y;
            y = z;
            i++;
        }

        return z;
    }
}