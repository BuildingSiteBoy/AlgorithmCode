package leetCode;

/**
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 * 根据删除规则，删除任意一个 A 不会影响可被删删除的 B 的数量，反之亦然。
 *
 * 因此直接统计「可删除的 A 的数量」和「可删除的 B 的数量」，分别记为 aa 和 bb，比较 aa 和 bb 的大小即可得到答案（只有 a > ba>b 时，先手获胜）
 *
 * @author 曾奕
 */
public class Test2038 {
    public boolean winnerOfGame(String colors) {
        char[] cs = colors.toCharArray();
        int a = 0, b = 0;
        for (int i = 1; i < cs.length - 1; i++) {
            if (cs[i] == 'A' && cs[i - 1] == 'A' && cs[i + 1] == 'A') {
                a++;
            }
            if (cs[i] == 'B' && cs[i - 1] == 'B' && cs[i + 1] == 'B') {
                b++;
            }
        }
        return a > b;
    }
}
