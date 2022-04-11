package job;

import java.util.Scanner;
import java.util.Stack;

/**
 * 放他去修仙
 * 求解最短加权路径
 * @author zZeng
 */
public class Test0409BiJiTe02 {
    public static void main(String[] args) {
        // 求解图的最短加权路径
        Scanner in = new Scanner(System.in);
        // 仙境数量
        int n = in.nextInt();
        // 路径数量
        int m = in.nextInt();
        // 仙界地图
        int[][] map = new int[n + 1][n + 1];
        // 记录总路程
        int dis = 0;
        // 输入仙界地图
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            map[a][b] = c;
            dis += c;
        }

        // 记录路过次数
        int[] flag = new int[n + 1];
        // System.out.println(dis);
        int minSum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0) {
                    flag[i]++;
                    flag[j]++;
                    minSum += Math.min(dfs(flag, map, i), dfs(flag, map, j));
                }
            }
        }
        System.out.println(minSum);
    }

    private static int dfs(int[] flag, int[][] map, int index) {
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            res = map[index][i];
            flag[i]++;
        }
        return res;
    }
}
