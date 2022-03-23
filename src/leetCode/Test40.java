package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法：Backtracking
 * 40. 组合总和 II
 *
 * @author 曾奕
 */
public class Test40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), res, new boolean[candidates.length], 0, target, candidates);
        return res;
    }

    private void backtracking(ArrayList<Integer> temps, List<List<Integer>> res, boolean[] visited, int start, int target, final int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(temps));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                temps.add(candidates[i]);
                visited[i] = true;
                backtracking(temps, res, visited, i + 1, target - candidates[i], candidates);
                temps.remove(temps.size() - 1);
                visited[i] = false;
            }
        }
    }
}
