package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 * 417. 太平洋大西洋水流问题
 * 左边和上边是太平洋，右边和下边是大西洋，内部的数字代表海拔，海拔高的地方的水能够流到低的地方，
 * 求解水能够流到太平洋和大西洋的所有位置
 *
 * @author 曾奕
 */
public class Test417 {
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return res;
        }

        m = heights.length;
        n = heights[0].length;
        matrix = heights;
        boolean[][] canP = new boolean[m][n];
        boolean[][] canA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canP);
            dfs(i, n - 1, canA);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canP);
            dfs(m - 1, i, canA);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canP[i][j] && canA[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] can) {
        if (can[i][j]) {
            return;
        }
        can[i][j] = true;
        for (int[] d : direction) {
            int nextR = i + d[0];
            int nextL = j + d[1];
            if (nextR < 0 || nextR >= m || nextL < 0 || nextL >= n
                    || matrix[i][j] > matrix[nextR][nextL]) {
                continue;
            }
            dfs(nextR, nextL, can);
        }
    }
}
