package swordFingerOffer;

/**
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * @author 曾奕
 */
public class TestM0105 {
    public boolean oneEditAway(String first, String second) {
        int l1 = first.length();
        int l2 = second.length();
        if (Math.abs(l1 - l2) > 1) {
            return false;
        } else if (l1 - l2 == 1) {
            return oneChange(second, first);
        } else if (l2 - l1 == 1) {
            return oneChange(first, second);
        } else {
            boolean flag = false;
            for (int i = 0; i < l1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!flag) {
                        flag = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private boolean oneChange(String shortStr, String longStr) {
        int l1 = shortStr.length(), l2 = longStr.length();
        int i1 = 0, i2 = 0;
        while (i1 < l1 && i2 < l2) {
            if (shortStr.charAt(i1) == longStr.charAt(i2)) {
                i1++;
            }
            i2++;
            if (i2 - i1 > 1) {
                return false;
            }
        }
        return true;
    }
}
