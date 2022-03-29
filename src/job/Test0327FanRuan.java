package job;

/**
 * @author zZeng
 */
public class Test0327FanRuan {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix int整型二维数组
     * @return int整型一维数组
     */
    public int[] isRectangleCover (int[][] matrix) {
        // write code here
        int[] res = new int[2];
        int countArea = 0;
        int lx = matrix[0][0], ly = matrix[0][1], hx = matrix[0][2], hy = matrix[0][3];
        for (int i = 0; i < matrix.length; i++) {
            countArea += culArea(matrix[i]);
            if (matrix[i][0] < lx) {
                lx = matrix[i][0];
            }
            if (matrix[i][1] < ly) {
                ly = matrix[i][1];
            }
            if (matrix[i][2] > hx) {
                hx = matrix[i][2];
            }
            if (matrix[i][3] > hy) {
                hy = matrix[i][3];
            }
        }

        res[0] = -1;
        res[1] = (hx - lx) * (hy - ly);
        boolean flagL = false;
        boolean flagH = false;
        if (countArea == res[1]) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == lx && matrix[i][1] == ly) {
                    flagL = true;
                }
                if (matrix[i][2] == hx && matrix[i][3] == hy) {
                    flagH = true;
                }
            }
        }
        if (flagL && flagH) {
            res[0] = 1;
        }

        return res;
    }

    private int culArea(int[] rectangle) {
        return (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 找出第n个幸运数，返回字符串表示的数字
     * @param n int整型 第n个
     * @return string字符串
     */
    public String findLuckyNum (int n) {
        // write code here
        int i = 2;
        int res = 0;
        while (n > 0) {
            if (isLuckyNum(i)) {
                n--;
                res = i;
                System.out.println(res);
            }
            i++;
        }
        return Integer.toString(res);
    }

    private boolean isLuckyNum (int n) {
        int num = n;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 7 == 0) {
                num /= 7;
            } else {
                return false;
            }
        }
        return true;
    }

    public String findLuckyNumE (int n) {
        return "";
    }

    public static void main(String[] args) {
        Test0327FanRuan test = new Test0327FanRuan();
        System.out.println(test.findLuckyNum(1));
    }
}
