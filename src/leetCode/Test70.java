package leetCode;

/**
 * 动态规划
* 爬楼梯
* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
* 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
* */
public class Test70 {
    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(10));
        System.out.println(new Solution70_01().climbStairs(10));

    }
}

//递归方法
class Solution70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

//动态规划
class Solution70_01 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n == 1 ? 1 : 2;
        }

        int x = 1, y = 2, z = 3, i = 3;
        while (i <= n) {
            z = x + y;
            x = y;
            y = z;
            i++;
        }

        return z;
    }
}