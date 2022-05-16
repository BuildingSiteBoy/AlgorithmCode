package job;

/**
 * 超市找零
 * @author 曾奕
 */
public class Test0411Qi08 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 实现找零方法总数输出
     * @param N int整型 找零金额
     * @return int整型
     */
    public int GiveChargeSum (int N) {
        // write code here
        if (N == 0) {
            return 1;
        } else if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 2;
        } else if (N == 4) {
            return 3;
        } else if (N < 10) {
            return GiveChargeSum(N - 1) + GiveChargeSum(N - 2) + GiveChargeSum(N - 5);
        } else {
            return GiveChargeSum(N - 1) + GiveChargeSum(N - 2) + GiveChargeSum(N - 5) + GiveChargeSum(N - 10);
        }
    }


}
