package swordFingerOffer;

/**
 *剑指 Offer 04. 二维数组中的查找
 *在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
* */

public class Test04 {
    public static void main(String[] args) {
        int[][] matrix = { {1,4,7,11,15},
                           {2,5,8,12,19},
                           {3,6,9,16,22},
                           {10,13,14,17,24},
                           {18,21,23,26,29}};

        System.out.println(new Solution04().findNumberIn2DArray(matrix, 20));
        System.out.println(new Solution04().findNumberIn2DArray(matrix, 5));

    }
}

class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
                return false;

        int x = matrix[0].length;
        int y = matrix.length;
        int row = 0, col = x - 1;
        while (row < y && col >= 0) {
            if (matrix[row][col] > target)
                col--;
            else if (matrix[row][col] < target)
                row++;
            else
                return true;
        }

        return false;
    }
}