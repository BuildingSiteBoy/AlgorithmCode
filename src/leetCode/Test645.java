package leetCode;

/**
 * 645. 错误的集合
 * 一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
 *
 * 主要思想是通过交换数组元素，使得数组上的元素在正确的位置上。
 * @author 曾奕
 */
public class Test645 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[nums[i] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (list[i] == 0) {
                res[1] = i + 1;
            }
            if (list[i] == 2) {
                res[0] = i + 1;
            }
        }
        return res;
    }

    public int[] findErrorNumsO(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) {
                res[0] = i + 1;
            }
            if (nums[i] <= n) {
                res[1] = i + 1;
            }
        }

        return res;
    }

    public int[] findErrorNumsE(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                /*nums[i] = nums[nums[i] - 1] + nums[i];
                nums[nums[i] - 1] = nums[i] - nums[nums[i] - 1];
                nums[i] -= nums[nums[i] - 1];*/
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] -= nums[j];
    }
}
