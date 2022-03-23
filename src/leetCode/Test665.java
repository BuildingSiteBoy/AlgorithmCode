package leetCode;

/**
 * 665. 非递减数列
 * @author 曾奕
 */
public class Test665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }

            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }

        return count <= 1;
    }
}
