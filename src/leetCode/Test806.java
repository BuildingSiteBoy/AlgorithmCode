package leetCode;

/**
 * 806. 写字符串需要的行数
 * @author 曾奕
 */
public class Test806 {
    public int[] numberOfLines(int[] widths, String s) {
        // res数组用于记录结果
        int[] res = new int[2];

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += widths[s.charAt(i) - 'a'];
            if (count > 100) {
                res[0]++;
                count = widths[s.charAt(i) - 'a'];
            }
        }
        res[0]++;
        res[1] = count;
        return res;
    }
}
