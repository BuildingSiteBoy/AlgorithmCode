package leetCode;

/**
 * 贪心算法、动态规划
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * */

public class Test55 {
    public static void main(String[] args) {

    }
}

class Solution55_01 {
    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n)
                n = 1;
            else
                n++;
        }

        if (n > 1)
            return false;
        else
            return true;
    }
}

class Solution55_02 {
    public boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;

        int max = 0;    //表示最远能够到达的距离
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1)
                return true;
        }

        return false;
    }
}

class Solution55_03 {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;

        for (int i = last; i >= 0; i--) {
            if (nums[i] + i >= last)
                last = i;
        }

        return last == 0;
    }
}