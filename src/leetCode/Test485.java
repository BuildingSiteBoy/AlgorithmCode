package leetCode;

/**
 * 485. 最大连续 1 的个数
 * @author 曾奕
 */
public class Test485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int n : nums) {
            cur = n == 1 ? cur + 1 : 0;
            max = Math.max(max, cur);
        }
        return max;
    }
}
