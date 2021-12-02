package leetCode;

/**
 * 贪心、动态规划
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * */

public class Test45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution45().jump(nums));
    }
}

class Solution45 {
    public int jump(int[] nums) {
        if (nums.length < 2)
            return 0;

        int dis = 0;
        int nextDis = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            nextDis = Math.max(nextDis, i + nums[i]);
            if (nextDis >= nums.length - 1)
                return count + 1;

            if (i == dis) {
                count++;        //当遍历到之前数组能够走到的位置时，次数+1
                dis = nextDis;
            }
        }

        return count;
    }
}