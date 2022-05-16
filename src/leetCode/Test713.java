package leetCode;

/**
 * 713. 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * @author 曾奕
 */
public class Test713 {
    /**
     * 二分查找
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        int n = nums.length;
        double[] logPrefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            logPrefix[i + 1] = logPrefix[i] + Math.log(nums[i]);
        }

        double logK = Math.log(k);
        int res = 0;
        for (int j = 0; j < n; j++) {
            int l = 0;
            int r = j + 1;
            int index = j + 1;
            // double精度不够，得加 1e-10
            double val = logPrefix[j + 1] - logK + 1e-10;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (logPrefix[mid] > val) {
                    index = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res += j + 1 - index;
        }
        return res;
    }

    /**
     * 滑动窗口 / 双指针
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanKA(int[] nums, int k) {
        int n = nums.length, res = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
