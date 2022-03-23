package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 * 47. 全排列 II
 * @author 曾奕*/
public class Test47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList, permutes, hasVisited, nums);
        return permutes;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] hasVisited, int[] nums) {
        if (permuteList.size() == nums.length) {
            permutes.add(new ArrayList<>(permuteList));
            return;
        }
        for (int i = 0; i < hasVisited.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if (hasVisited[i]) {
                continue;
            }
            hasVisited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, permutes, hasVisited, nums);
            permuteList.remove(permuteList.size() - 1);
            hasVisited[i] = false;
        }
    }
}
