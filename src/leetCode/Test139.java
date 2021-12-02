package leetCode;

import java.util.List;

/**
 * 动态规划
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * */

public class Test139 {
    public static void main(String[] args) {

    }
}

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //flag[i] 表示s中以i-1结尾的字符串是否可被wordDict拆分
        boolean[] flag = new boolean[n + 1];
        flag[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && flag[j]) {
                    flag[i] = true;
                }
            }
        }

        return flag[n];
    }
}