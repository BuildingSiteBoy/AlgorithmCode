package leetCode;

import java.util.*;

/**
 * 819. 最常见的单词
 * @author 曾奕
 */
public class Test819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 将禁用列表存入set集合中
        Set<String> set = new HashSet<>();
        for (String str : banned) {
            set.add(str);
        }

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace(".", "");
        paragraph = paragraph.replace(",", "");
        paragraph = paragraph.replace("!", "");
        paragraph = paragraph.replace("?", "");
        String[] strs = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();

        // 记录结果即重复次数
        String res = "";
        int count = 0;

        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (!set.contains(str)) {
                if (count < map.get(str)) {
                    count = map.get(str);
                    res = str;
                }
            }
        }

        return res;
    }

    public String mostCommonWordE(String paragraph, String[] banned) {
        // 将禁用列表存入set集合中
        Set<String> set = new HashSet<>();
        for (String str : banned) {
            set.add(str);
        }

        char[] cs = paragraph.toCharArray();
        int n = cs.length;
        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ) {
            if (!Character.isLetter(cs[i]) && ++i >= 0) {
                continue;
            }
            int j = i;
            while (j < n && Character.isLetter(cs[j])) {
                j++;
            }
            String sub = paragraph.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub)) {
                continue;
            }
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) {
                ans = sub;
            }
        }
        return ans;
    }
}
