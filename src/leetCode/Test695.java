package leetCode;

/**
 * DFS/BFS
 * 695. 岛屿的最大面积
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * @author 曾奕*/
public class Test695 {
    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1}, {1,1,0},{1,0,1}};
        int[][] grid2 = {};

        System.out.println(new Solution695().maxAreaOfIsland(grid1));
        System.out.println(new Solution695().maxAreaOfIsland(grid2));
    }
}

class Solution695 {

    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int count = 1;
        //count += dfs(grid, i + 1, j);
        //count += dfs(grid, i - 1, j);
        //count += dfs(grid, i, j + 1);
        //count += dfs(grid, i, j - 1);
        for (int[] d : direction) {
            count += dfs(grid, i + d[0], j + d[1]);
        }

        return count;
    }
}
