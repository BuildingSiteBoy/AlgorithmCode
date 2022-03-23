package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 贪心算法
 * 406. 根据身高重建队列
 * 先对身高排序，身高相同k小的排前面，再按k插入res即可
 * @author 曾奕
 */
public class Test406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}
