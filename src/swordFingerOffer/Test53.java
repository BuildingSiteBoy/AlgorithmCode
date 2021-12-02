package swordFingerOffer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 注：有序数组的搜索问题均要使用二分法！！！
 * */

public class Test53 {
    public static void main(String[] args) {

    }
}

class Solution53_01 {
    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) >> 1;

            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        while (left < nums.length && nums[left++] == target)
            count++;
        return count;
    }
}

class Solution53_02 {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}