package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 原地哈希 时间复杂度O(n) 空间复杂度O(1)
 * @author 曾奕
 */
public class Test442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] list = new int[n];
        for (int num : nums) {
            list[num - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (list[i] > 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public List<Integer> findDuplicatesE(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n && nums[i] <= 3 * n) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
