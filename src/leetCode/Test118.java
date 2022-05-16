package leetCode;

/*
* 杨辉三角形
* 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
* 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
* 1 0 0 0 0 0
* 1 1 0 0 0 0
* 1 2 1 0 0 0
* 1 3 3 1 0 0
* 1 4 6 4 1 0
* 1 5 10 10 5 1
* */

import java.util.ArrayList;
import java.util.List;

/**
 * @author 曾奕
 */
public class Test118 {
    public static void main(String[] args) {
        System.out.println(new Solution118().generate(10));
    }
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] nums = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                }
//                System.out.print("\t" + nums[i][j]);
                list.add(nums[i][j]);
            }

//            System.out.println();
            result.add(list);
        }

        return result;
    }
}
