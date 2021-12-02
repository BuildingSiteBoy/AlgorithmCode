package swordFingerOffer;

import java.beans.Visibility;

/**
 * DFS/BFS
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 *
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？

 * */

public class Test13 {
    public static void main(String[] args) {
        System.out.println(new Solution13().movingCount(2, 3, 1));
        System.out.println(new Solution13_02().movingCount(2, 3, 1));

        System.out.println("35 * 37 = " + 35 * 37);
        System.out.println(new Solution13().movingCount(35, 37, 18));
        System.out.println(new Solution13_02().movingCount(35, 37, 18));

        System.out.println(new Solution13().movingCount(16, 8, 4));
        System.out.println(new Solution13_02().movingCount(16, 8, 4));
    }
}

class Solution13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];       //记录该位置是否被访问过
        return dfs(0, 0, m, n, k, flag);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] flag) {
        if (i < 0 || i >= m || j < 0 || j >= n
                || (i / 10 + i % 10 + j / 10 + j % 10) > k || flag[i][j])
            return 0;

        flag[i][j] = true;

        return dfs(i + 1, j, m, n, k, flag) + dfs(i - 1, j, m, n, k, flag)
                + dfs(i, j + 1, m, n, k, flag) + dfs(i, j - 1, m, n, k, flag) + 1;
    }
}

//错误解法: 有些格子过去不，会使一些格子无法被统计
class Solution13_02 {
    public int movingCount(int m, int n, int k) {
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i/10 + i%10 + j/10 + j%10) <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}