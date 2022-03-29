package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 * 和谐序列中最大数和最小数只差正好为 1，应该注意的是序列的元素不一定是数组的连续元素。
 * @author 曾奕
 */
public class Test594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int longest = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                longest = Math.max(longest, map.get(num) + map.get(num + 1));
            }
        }
        return longest;
    }
}
