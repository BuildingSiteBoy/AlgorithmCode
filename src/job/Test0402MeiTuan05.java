package job;

import java.util.Scanner;

/**
 * 可旋转矩阵
 * n×n 个整数，排成n行，每行n个，这样就组成了一个方阵。小团喜欢无论从四个方向看上去都一模一样的方阵，也就是说，把这个方阵旋转90度若干次，它都和旋转前一模一样。
 *
 * 而小美有能力改变方阵里面数的值，但这需要花费一定时间。每把一个位置的数增大或减小1，所花费的时间都是1秒。现在小美想要改到这个矩阵让小团满意，但她也希望节省自己的时间，请计算要达到目标，所需要的最短时间。
 *
 * 第一行一个整数 n，1 <= n <= 100;
 *
 * 后面n行，每行n个空格隔开的整数 aij，0 <= aij <= 109。
 *
 * 一个整数，表示所需要的最小时间
 * @author 曾奕
 */
public class Test0402MeiTuan05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入数据
        int n = in.nextInt();
        int[][] nums = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = in.nextInt();
            }
        }

    }
}
