package swordFingerOffer;

/**
 * 搜索与回溯算法
 *
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * */

public class Test12 {
    public static void main(String[] args) {

    }
}

class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();
        boolean[][] flag = new boolean[board.length][board[0].length];  //记录该字母是否被使用过

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, str, flag, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || chars[start] != board[i][j] || visited[i][j])
            return false;

        if (start == chars.length - 1)
            return true;

        visited[i][j] = true;

        boolean ans = false;
        ans = dfs(board, chars, visited, i + 1, j, start + 1)
            || dfs(board, chars, visited, i - 1, j, start + 1)
            || dfs(board, chars, visited, i, j + 1, start + 1)
            || dfs(board, chars, visited, i, j - 1, start + 1);
        visited[i][j] = false;      //回溯

        return ans;
    }
}