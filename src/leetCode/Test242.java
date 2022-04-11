package leetCode;

/**
 * 242. 有效的字母异位词
 * 可以用 HashMap 来映射字符与出现次数，然后比较两个字符串出现的字符数量是否相同。
 * 由于本题的字符串只包含 26 个小写字符，因此可以使用长度为 26 的整型数组对字符串出现的字符进行统计，
 * 不再使用 HashMap。
 * @author 曾奕
 */
public class Test242 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int n : count) {
            if (count[n] != 0) {
                return false;
            }
        }
        return true;
    }
}
