package leetCode;

/**
 * 二分查找
 * 540. 有序数组中的单一元素
 *
 * 令 index 为 Single Element 在数组中的位置。如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m +
 * 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
 * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m
 * + 2；如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
 * 因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式
 *
 * @author 曾奕
 */
public class Test540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                // 保证查找的为偶数
                m--;
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
