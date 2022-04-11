package leetCode;

/**
 * 205. 同构字符串
 * 记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
 * @author 曾奕
 */
public class Test205 {
    public boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            // 查看同位置的字符前一个位置是否相同
            if (preIndexOfS[cs] != preIndexOfT[ct]) {
                return false;
            }
            preIndexOfS[cs] = i + 1;
            preIndexOfT[ct] = i + 1;
        }
        return true;
    }
}
