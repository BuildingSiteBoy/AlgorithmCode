package swordFingerOffer;

/**
 * 动态规划
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * */

public class Test63 {
    public static void main(String[] args) {

    }
}

//暴力破解
class Solution63_01 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max;
    }
}

//动态规划
class Solution63_02 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int[] dp = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            //选择最低的股价
            min = Math.min(min, prices[i]);
        }

        return dp[prices.length - 1];
    }
}