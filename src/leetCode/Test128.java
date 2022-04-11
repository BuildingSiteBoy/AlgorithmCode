package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 * @author 曾奕
 */
public class Test128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, 1);
        }
        for (int num : nums) {
            forward(count, num);
        }
        return maxCount(count);
    }

    private int maxCount(Map<Integer, Integer> count) {
        int max = 0;
        for (int num : count.keySet()) {
            max = Math.max(max, count.get(num));
        }
        return max;
    }

    private int forward(Map<Integer, Integer> count, int num) {
        if (!count.containsKey(num)) {
            return 0;
        }
        int cnt = count.get(num);
        if (cnt > 1) {
            return cnt;
        }
        cnt = forward(count, num + 1) + 1;
        count.put(num, cnt);
        return cnt;
    }


}
