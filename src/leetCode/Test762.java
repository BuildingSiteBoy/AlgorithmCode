package leetCode;

/**
 * 762. 二进制表示中质数个计算置位
 * @author 曾奕
 */
public class Test762 {
    public int countPrimeSetBits(int left, int right) {
        int resCount = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                resCount++;
            }
        }
        return resCount;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
