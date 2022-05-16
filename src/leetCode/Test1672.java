package leetCode;

/**
 * 1672. 最富有客户的资产总量
 * @author 曾奕
 */
public class Test1672 {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int wealth = 0;
            for (int money : account) {
                wealth += money;
            }
            maxWealth = Math.max(wealth, maxWealth);
        }
        return maxWealth;
    }
}
