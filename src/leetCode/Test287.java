package leetCode;

/**
 * 287. 寻找重复数
 * 找出数组中重复的数，数组值在 [1, n] 之间
 * @author 曾奕
 */
public class Test287 {
    /**
     * 原地哈希法
     * @param nums 数组
     * @return 重复数字
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * 要求不能修改数组，也不能使用额外的空间：二分查找法
     * @param nums 数组
     * @return 重复数字
     */
    public int findDuplicateE(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 要求不能修改数组，也不能使用额外的空间：双指针解法
     * @param nums 数组
     * @return 重复数字
     */
    public int findDuplicateO(int[] nums) {
        int l = nums[0], h = nums[nums[0]];
        while (l != h) {
            l = nums[l];
            h = nums[nums[h]];
        }
        h = 0;
        while (l != h) {
            l = nums[l];
            h = nums[h];
        }
        return l;
    }
}
