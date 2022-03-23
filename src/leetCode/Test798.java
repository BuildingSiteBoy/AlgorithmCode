package leetCode;

/**
 * 排序问题
 * 798. 得分最高的最小轮调
 * @author 曾奕
 */
public class Test798 {
    /**
     * 差分数组
     * @param nums
     * @return
     */
    public int bestRotation2(int[] nums) {
        int n = nums.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            diffs[low]++;
            diffs[high]--;
            if (low >= high) {
                diffs[0]++;
            }
        }

        int bestRes = 0;
        int max = 0;
        int point = 0;
        for (int i = 0; i < n; i++) {
            point += diffs[i];
            if (point > max) {
                bestRes = i;
                max = point;
            }
        }

        return bestRes;
    }

    public int bestRotation(int[] nums) {
        int bestRes = 0;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = getPointWithRotation(nums, i);
            if (point < t) {
                bestRes = i;
                point = t;
            }
        }

        return bestRes;
    }

    /**
     * 第二次尝试再次超时
     * @param nums
     * @param k
     * @return
     */
    private int getPointWithRotation(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[(i + k) % nums.length] <= i) {
                count++;
            }
        }
        return count;
    }


    /**
     * 以下方法超时=================
     * @param nums 数组
     * @param k 第k个
     * @return
     */
    private int[] rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[(i + k) % nums.length];
        }
        return res;
    }

    private int getPoint(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= i) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 0};
        System.out.println(new Test798().bestRotation(nums));

        int[] nums2 = {1, 3, 0, 2, 4};
        System.out.println(new Test798().bestRotation(nums2));
    }
}
