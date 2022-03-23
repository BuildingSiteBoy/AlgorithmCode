package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：Backtracking
 * 216. 组合总和 III
 *
 * @author 曾奕
 */
public class Test216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(k, n, 1, path,res);
        return res;
    }

    private void backtracking(int k, int n, int start, List<Integer> path, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtracking(k - 1, n - i, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
