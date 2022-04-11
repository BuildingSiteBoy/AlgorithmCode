package job;

import java.util.Scanner;

/**
 * 单峰数组
 * 小美有一个长度为n的数组。小美觉得如果一个数组可以从中切开，使得前一段严格递增且后一段严格递减，那么这个数组是好的。
 *
 * 现在小美想通过往她所有的数组的某些元素上加上总和尽可能小的一些正整数从而让这个数组变好。
 *
 * 请你求出她需要加上总和至少为多少的正整数才能使数组变好。
 *
 * 一个数组是严格递增的当且仅当其中除第一个元素以外的任意一个元素都大于其前一个元素。
 *
 * 一个数组是严格递减的当且仅当其中除第一个元素以外的任意一个元素都小于其前一个元素。
 *
 *
 * 第一行有一个正整数n(1<=n<=100000)，代表小美所有的数组的长度。
 *
 * 第二行有n个空格隔开的正整数，代表小美所拥有的数组。
 *
 *
 * 输出一个整数，代表小美需要往她的数组中的某些元素上加上总和至少为多少的正整数才能使数组变好。
 *
 *
 * @author 曾奕
 */
public class Test0402MeiTuan02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入数据
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] flag = new int[n];
        flag[0] = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            if (i > 0) {
                if (nums[i] > nums[i - 1]) {
                    flag[i] = 1;
                } else {
                    flag[i] = -1;
                }
            }
        }

        if (n <= 2) {
            System.out.println(0);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++ ) {
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                res += Math.min(nums[i - 1], nums[i + 1]) - nums[i] + 1;
            }
        }
        System.out.println(res);
    }
}
