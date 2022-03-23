package leetCode;

/**
 * 326. 3 的幂
 * @author 曾奕
 */
public class Test326 {
    public boolean isPowerOfThree(int n) {
        // 判断是否为最大 3 的幂的约数
        return n > 0 && (1162261467 % n == 0);
    }

    public boolean isPowerOfThreeE(int n) {
        // 超时
        int temp = 1;
        while (temp < n) {
            temp *= 3;
        }
        return temp == n;
    }

    public boolean isPowerOfThreeO(int n) {
        // 试除法
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThreeNb(int n) {
        switch (n) {
            case 1:
                return true;
            case 3:
                return true;
            case 9:
                return true;
            case 27:
                return true;
            case 81:
                return true;
            case 243:
                return true;
            case 729:
                return true;
            case 2187:
                return true;
            case 6561:
                return true;
            case 19683:
                return true;
            case 59049:
                return true;
            case 177147:
                return true;
            case 531441:
                return true;
            case 1594323:
                return true;
            case 4782969:
                return true;
            case 14348907:
                return true;
            case 43046721:
                return true;
            case 129140163:
                return true;
            case 387420489:
                return true;
            case 1162261467:
                return true;
            default:
                return false;
        }
    }
}
