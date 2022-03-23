package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心算法
 * 763. 划分字母区间
 * @author 曾奕
 */
public class Test763 {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexOfChar = new int[26];
        // 记录每一个字母最后出现的下标
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[s.charAt(i) - 'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0, lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            lastIndex = Math.max(lastIndex, lastIndexOfChar[s.charAt(i) - 'a']);
            if (i == lastIndex) {
                partitions.add(lastIndex - firstIndex + 1);
                firstIndex = lastIndex + 1;
            }
        }

        return partitions;
    }
}
