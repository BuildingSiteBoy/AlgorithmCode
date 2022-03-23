package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 解题思路：回溯算法
 *
 * @author 曾奕*/
public class Test77 {
    public static void main(String[] args) {
        System.out.println(new Solution77().combine(4, 2));
        System.out.println(new Solution77().combine(9, 3));
    }
}

class Solution77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    /**
     * 从集合中搜取元素，start来控制范围缩小
     * @param n
     * @param k
     * @param start
     */
    private void backtracking(int n, int k, int start) {
        //终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        //回溯过程
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
