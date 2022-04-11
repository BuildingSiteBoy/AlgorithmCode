package leetCode;

/**
 * 566. 重塑矩阵
 * @author 曾奕
 */
public class Test566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = mat[index / n][index % n];
                index++;
            }
        }

        return res;
    }
}
