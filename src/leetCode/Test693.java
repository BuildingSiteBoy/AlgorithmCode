package leetCode;

/**
 * 693. 交替位二进制数
 * @author 曾奕
 */
public class Test693 {
    public boolean hasAlternatingBits(int n) {
        int pre = 2;
        while (n != 0) {
            int cur = n % 2;
            if (cur == pre) {
                return false;
            }
            pre = cur;
            n /= 2;
        }
        return true;
    }
}
