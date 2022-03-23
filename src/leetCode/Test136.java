package leetCode;

/**
 * 136. 只出现一次的数字
 * @author 曾奕
 */
public class Test136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
