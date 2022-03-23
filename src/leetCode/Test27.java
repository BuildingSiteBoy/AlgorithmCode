package leetCode;

/**
 * 27. 移除元素
 * @author 曾奕
 */
public class Test27 {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
