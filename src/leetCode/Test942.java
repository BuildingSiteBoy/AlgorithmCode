package leetCode;

/**
 * 942. 增减字符串匹配
 *  p[i] < p[i + 1], 则 s[i] = 'I';
 *  p[i] > p[i + 1], 则 s[i] = '
 *  算法思路：设numi=0,numd=S.length()，遇到D就把numd--推后，遇到I就把numi++推后
 *
 * @author 曾奕
 */
public class Test942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int l = 0, h = n;
        int[] res = new int[n + 1];

        for (int i = 0; i < n; i++) {
            res[i] = s.charAt(i) == 'I' ? l++ : h--;
        }
        res[n] = h;

        return res;
    }
}
