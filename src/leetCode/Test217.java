package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * @author 曾奕
 */
public class Test217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}
