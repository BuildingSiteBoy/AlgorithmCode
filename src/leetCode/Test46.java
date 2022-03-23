package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列
 *
 * @author 曾奕*/
public class Test46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] numss = {111, 222, 333, 444, 555};

        System.out.println(new Solution46().permute(nums));
        System.out.println(new Solution46().permute(numss));
    }
}

class Solution46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        //回溯
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backtracking(nums);
                path.removeLast();
            }
        }
    }
}
