package swordFingerOffer;

import java.util.Arrays;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *
* */

public class Test11 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        System.out.println(new Solution11().minArray(nums));
    }
}

class Solution11 {
    public int minArray(int[] numbers) {
//        Arrays.sort(numbers);
//        return numbers[0];

        //二分查找
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            //只要右边比中间大，则右边有序
            if (numbers[right] > numbers[mid])
                right = mid;
            else if (numbers[right] < numbers[mid])
                left = mid + 1;
            else
                right--;        //去除相同的数字
        }

        return numbers[left];
    }
}
