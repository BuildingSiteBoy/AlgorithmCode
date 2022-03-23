package leetCode;

import java.util.Arrays;

/**
 * 贪心算法
 * 455. 分发饼干
 * 给一个孩子的饼干应当尽量小又能满足该孩子，贪心策略就是最优策略
 * @author 曾奕
 */
public class Test455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gCount = 0, sCount = 0;
        while (gCount < g.length && sCount < s.length) {
            if (g[gCount] <= s[sCount]) {
                gCount++;
            }
            sCount++;
        }
        return gCount;
    }
}
