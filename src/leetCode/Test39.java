package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：Backtracking
 * 39. 组合总和
 *
 * @author 曾奕
 */
public class Test39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(new ArrayList<>(), res, 0, target, candidates);
        return res;
    }

    private void backtracking(ArrayList<Integer> temps, List<List<Integer>> res, int start, int target, int[] candidates) {
        if (target == 0) {
            // res.add(temps);
            res.add(new ArrayList<>(temps));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                temps.add(candidates[i]);
                backtracking(temps, res, i, target - candidates[i], candidates);
                temps.remove(temps.size() - 1);
            }
        }
    }
}
