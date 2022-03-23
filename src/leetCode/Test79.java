package leetCode;

/**
 * 回溯算法：Backtracking
 * 79. 单词搜索
 * @author 曾奕
 */
public class Test79 {
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (backtracking(0, r, c, hasVisited, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtracking(int len, int r, int c, boolean[][] visited, final char[][] board, final String word) {
        if (len == word.length()) {
            return true;
        }
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(len) || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;

        for (int[] d : direction) {
            if (backtracking(len + 1, r + d[0], c + d[1], visited, board, word)) {
                return true;
            }
        }

        visited[r][c] = false;
        return false;
    }
}
