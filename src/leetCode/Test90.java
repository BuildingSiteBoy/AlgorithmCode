package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法：Backtracking
 * 90. 子集II
 *
 * @author 曾奕
 */
public class Test90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int size = 0; size <= nums.length; size++) {
            // 不同的子集大小
            backtracking(0, temp, subsets, visited, size, nums);
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> temp, List<List<Integer>> subsets, boolean[] visited, int size, int[] nums) {
        if (temp.size() == size) {
            subsets.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i -1] && !visited[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            backtracking(i + 1, temp, subsets, visited, size, nums);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
