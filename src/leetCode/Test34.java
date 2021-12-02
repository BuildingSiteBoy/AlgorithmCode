package leetCode;

/**
 * 二分查找
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * */

public class Test34 {
    public static void main(String[] args) {

    }
}

class Solution_01 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                }

                res[1] = i;
            }
        }

        return res;
    }
}

class Solution_02 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = binarySearch(nums, target, true);      //true找左
        res[1] = binarySearch(nums, target, false);     //false找右
        return res;
    }

    private int binarySearch(int[] nums, int target, boolean flag) {
        int res = -1;
        int low = 0, high = nums.length - 1, mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target < nums[mid])
                high = mid - 1;
            else if (target > nums[mid])
                low = mid + 1;
            else {
                res = mid;
                if (flag)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return res;
    }
}