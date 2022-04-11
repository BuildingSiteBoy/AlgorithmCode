package job;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 老张修路
 *
 *
 * 老张在一家工程公司担任规划师。一天，这个工程公司接到了市政府的道路翻新任务，需要在已有的路网上规划一些路段进行翻新，并保证规划中的翻新道路经过了所给路网上所有的结点（一段翻新道路经过其两端的结点），同时所有翻新的路段必须构成一棵树，也就是说不可以存在一段不与其他翻新路段相连的翻新路段。因为翻新成本与道路长度有关，所以需要规划翻新的道路长度和最小，老张想请你帮忙计算这个最小长度和。
 *
 *
 * 第一行有2个正整数n和m，表示所给路网的结点数和道路数。
 *
 * 接下来有3行，每一行有m个正整数，每行分别对应ui、vi、wi。
 *
 * 相同位置的一组<ui, vi, wi>表示结点ui和vi之间有一条长度为wi的道路。
 *
 * 输入中的数字，两两间均有空格隔开
 *
 * 1 ≤ ui, vi ≤ n，0 ≤ wi ≤ 1000，1 ≤ m ≤min{30000, n2}。
 *
 *
 * 输出1行，只包括1个整数，表示题目所求的最小长度和。
 * @author zZeng
 */
public class Test040236002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入数据
        int n = in.nextInt();
        int m = in.nextInt();
        // 定义记录权重的数组
        int[][] weighs = new int[n + 1][n + 1];
        int[] temp = new int[n];
        // 定义数据输入的数组
        int[][] nums = new int[3][m];
        // 输入权重
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < m; j++) {
                int x = in.nextInt();
                nums[i][j] = x;
                if (i == 2) {
                    temp[j] = x;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            weighs[nums[0][j]][nums[1][j]] = nums[2][j];
        }
        //print2D(weighs);

        int res = 0;
        Arrays.sort(temp);
        for (int i = 0; i < n - 1; i++) {
            res += temp[i];
        }

        System.out.println(res);
    }

    private static void print2D(int[][] weighs) {
        for (int i = 0; i < weighs.length; i++) {
            for (int j = 0; j < weighs[0].length; j++) {
                System.out.print(weighs[i][j] + " ");
            }
            System.out.println();
        }
    }
}
