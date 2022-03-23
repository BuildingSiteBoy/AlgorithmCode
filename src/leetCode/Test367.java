package leetCode;

/**
 * 367. 有效的完全平方数
 *
 * @author 曾奕
 */
public class Test367 {
    public boolean isPerfectSquare(int num) {
        int subNum = 1;
        while (num > 0) {
            num -= subNum;
            subNum += 2;
        }
        return num == 0;
    }
}
