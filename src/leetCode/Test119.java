package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * */

public class Test119 {
    public static void main(String[] args) {
        System.out.println(new Solution119().getRow(8));
    }
}

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long n = 1;

        for (int i = 0; i <= rowIndex; i++) {
            res.add((int)n);
            n = n * (rowIndex - i) / (i + 1);
        }

        return res;
    }
}