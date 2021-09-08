package leetCode;

/*
* 泰波那契序列 Tn 定义如下：
* T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
* 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
* */
public class Test1137 {
    public static void main(String[] args) {
        System.out.println(new Solution137().tribonacci(25));
        System.out.println(new Solution137_02().tribonacci(25));
    }
}

//动态规划
class Solution137 {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;

        int w = 0, x = 1, y = 1, z = 2, i = 3;

        while (i <= n) {
            z = w + x + y;
            w = x;
            x = y;
            y = z;
            i++;
        }

        return z;
    }
}

//递归算法
class Solution137_02 {
    public int tribonacci(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n == 0 ? 0 : 1;
        }

        return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
    }
}