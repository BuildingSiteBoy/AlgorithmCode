package leetCode;

/**
 * 动态规划
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * */

public class Test309 {
    public static void main(String[] args) {

    }
}

class Solution309_01 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        //[0]: 手上有股票，[1]: 手上没有股票，且处于冻结期，[2]: 手上没有股票，且不在冻结期
        int[][] res = new int[prices.length][3];
        res[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            res[i][0] = Math.max(res[i-1][0], res[i-1][2] - prices[i]);
            res[i][1] = res[i-1][0] + prices[i];
            res[i][2] = Math.max(res[i-1][1], res[i-1][2]);
        }

        return Math.max(res[prices.length-1][1], res[prices.length-1][2]);
    }
}
//309_1空间优化
class Solution309_02 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int n = prices.length;
        int res0 = -prices[0];
        int res1 = 0;
        int res2 = 0;
        for (int i = 1; i < n; i++) {
            int temp0 = Math.max(res0, res2 - prices[i]);
            int temp1 = res0 + prices[i];
            int temp2 = Math.max(res1, res2);

            res0 = temp0;
            res1 = temp1;
            res2 = temp2;
        }

        return Math.max(res1, res2);
    }
}