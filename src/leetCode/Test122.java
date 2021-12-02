package leetCode;

/**
 * 动态规划/贪心算法
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * */

public class Test122 {
    public static void main(String[] args) {

    }
}

//贪心算法
class Solution122_01 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        //贪心算法
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }

        return max;
    }
}

//动态规划
class Solution122_02 {
    public int maxProfit(int[] prices) {
        //天数+是否持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //动态规划公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);        //卖出股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);        //买入股票
        }

        return dp[prices.length - 1][0];
    }
}