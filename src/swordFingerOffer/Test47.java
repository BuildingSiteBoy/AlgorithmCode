package swordFingerOffer;

/**
 * 动态规划
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值>0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
 * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，
 * 请计算你最多能拿到多少价值的礼物？
 *
 * 转移方程：f(i, j) = max{f(i - 1, j), f(i, j - 1)} + grid[i][j]
 * */

public class Test47 {
    public static void main(String[] args) {

    }
}

class Solution47 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[n];
    }
}