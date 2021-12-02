package leetCode;

/**
* 动态规划
* 746. 使用最小花费爬楼梯
* 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
* 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
* 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
* */

public class Test746 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new Solution746().minCostClimbingStairs(cost));
    }
}

class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] res = new int[n];

        res[0] = cost[0];
        res[1] = cost[1];

        for (int i = 2; i < n; i++) {
            res[i] = Math.min(res[i - 1] + cost[i], res[i - 2] + cost[i]);
        }

        return Math.min(res[n - 1], res[n - 2]);
    }
}
