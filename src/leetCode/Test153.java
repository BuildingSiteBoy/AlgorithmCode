package leetCode;

/**
 * 二分查找
 * 153. 寻找旋转排序数组中的最小值
 *
 * 类似于插值符合条件的最左值
 *
 * @author 曾奕
 */
public class Test153 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
