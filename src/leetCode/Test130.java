package leetCode;

/**
 * DFS
 * 130. 被围绕的区域
 * @author 曾奕
 */
public class Test130 {

    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i , 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        for (int[] d : direction) {
            dfs(board, i + d[0], j + d[1]);
        }
    }
}
