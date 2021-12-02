package swordFingerOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 排序
 *
 * 剑指 Offer 45. 把数组排成最小的数
 *
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * */

public class Test45 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};

        System.out.println(new Solution45().minNumber(nums));
    }
}

class Solution45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        //重写排序方法
        //Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return (x + y).compareTo(y + x);
            }
        });

        StringBuilder res = new StringBuilder();
        for (String str : strs)
            res.append(str);

        return res.toString();
    }
}
