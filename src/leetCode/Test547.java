package leetCode;

/**
 * DFS
 * 547. 省份数量
 *
 * @author 曾奕
 */
public class Test547 {
    private int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int res = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(isConnected, i, hasVisited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (isConnected[i][k] == 1 && !hasVisited[k]) {
                dfs(isConnected, k, hasVisited);
            }
        }
    }
}
