package leetCode;

/**
 * 204. Count Primes (Easy)
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量
 * 埃拉托斯特尼筛法在每次找到一个素数时，将能被素数整除的数排除掉
 * @author 曾奕
 */
public class Test204 {
    public int countPrimes(int n) {
        boolean[] noPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (noPrimes[i]) {
                continue;
            }
            count++;
            for (long j = (long) (i) * i; j < n; j += i) {
                noPrimes[(int) j] = true;
            }
        }
        return count;
    }
}
