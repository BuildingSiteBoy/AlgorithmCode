package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS/BFS
 * 542.01矩阵
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，
 * 其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 * */

public class Test542 {
    public static void main(String[] args) {
        int[][] mat1 = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] mat2 = {{0,0,0},{0,1,0},{1,1,1}};

        //int[][] res1 = new Solution542_01().updateMatrix(mat2);
        int[][] res1 = new Solution542_02().updateMatrix(mat2);
        for (int[] res : res1) {
            for (int n : res) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}

//DFS
class Solution542_01 {
    private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //如果0在附件，则保留元素值1，不在附近则初始化一个较大的值
                if (mat[i][j] == 1
                        && !((i > 0 && mat[i - 1][j] == 0)
                        || (i < row - 1 && mat[i + 1][j] == 0)
                        || (j >0 && mat[i][j - 1] == 0)
                        || (j < col - 1 && mat[i][j + 1] == 0))) {
                    mat[i][j] = row + col;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //当元素值为1，作为DFS的起点
                if (mat[i][j] == 1)
                    dfs(mat, i, j);
            }
        }

        return mat;
    }

    private void dfs(int[][] mat, int i, int j) {
        //DFS:搜索上下左右四个方向
        for (int[] v : vector) {
            int row = i + v[0], col = j + v[1];
            if (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length
                && mat[row][col] > mat[i][j] + 1) {
                mat[row][col] = mat[i][j] + 1;
                dfs(mat, row, col);
            }
        }
    }
}

//BFS
class Solution542_02 {
    private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    //将所有0元素作为BFS第一层
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = row + col;      //取一个较大值
                }
            }
        }

        //BFS
        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            //搜索上下左右四个方向
            for (int[] v : vector) {
                int r = u[0] + v[0], c = u[1] + v[1];
                if (r >= 0 && r < row && c >= 0 && c < col
                    && mat[r][c] > mat[u[0]][u[1]] + 1) {
                    mat[r][c] = mat[u[0]][u[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}