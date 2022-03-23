package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：Backtracking
 * 78. 子集
 *  下一个90. 子集II
 * @author 曾奕
 */
public class Test78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            // 不同的子集大小
            backtracking(0, temp, subsets, size, nums);
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> temp, List<List<Integer>> subsets, int size, int[] nums) {
        if (temp.size() == size) {
            subsets.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(i + 1, temp, subsets, size, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
