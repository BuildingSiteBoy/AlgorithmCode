package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 寻找所有丢失的元素
 * @author 曾奕
 */
public class Test448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] list = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[nums[i] - 1]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list[i] == 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public List<Integer> findDisappearedNumbersE(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
