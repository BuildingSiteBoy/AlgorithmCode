package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 * @author 曾奕
 */
public class Test728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivNum(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDivNum(int i) {
        int temp = i;
        while (temp > 0) {
            int div = temp % 10;
            if (div == 0) {
                return false;
            }
            if (i % div != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}
