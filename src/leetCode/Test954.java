package leetCode;

import java.util.*;

/**
 * 954. 二倍数对数组
 * @author 曾奕
 */
public class Test954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : arr) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // 如果零的个数不是偶数个，排除
        if (count.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> nums = new ArrayList<>();
        for (int n : count.keySet()) {
            nums.add(n);
        }
        Collections.sort(nums, (a, b) -> Math.abs(a) - Math.abs(b));
        for (int n : nums) {
            if (count.getOrDefault(2 * n, 0) < count.get(n)) {
                return false;
            }
            // 将2 * n 抵消掉 n 存在的个数
            count.put(2 * n, count.getOrDefault(2 * n, 0) - count.get(n));
        }
        return true;
    }
}
