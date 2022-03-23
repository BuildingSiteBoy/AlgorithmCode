package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 * 452. 用最少数量的箭引爆气球
 * @author 曾奕
 */
public class Test452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        //Arrays.sort(points, (a, b) -> (b[1] - a[1]));     插值太大导致栈溢出
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        System.out.println(points.length);
        int count = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            //System.out.println(points[i][0]);
            if (points[i][0] <= end) {
                continue;
            }
            count++;
            end = points[i][1];
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] nums = {{-2147483646, -2147483645}, {2147483646, 2147483647}};

        System.out.println(new Test452().findMinArrowShots(nums));
    }
}
