package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 * 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，
 * 我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * */

public class Test784 {
    public static void main(String[] args) {
        String s1 = "a1b2";
        String s2 = "12345";

        System.out.println(new Solution784().letterCasePermutation(s1));
        System.out.println(new Solution784().letterCasePermutation(s2));
    }
}

class Solution784 {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] str = s.toCharArray();
        backtracking(str, 0);
        return res;
    }

    private void backtracking(char[] str, int start) {
        res.add(new String(str));

        for (int i = start; i < str.length; i++) {
            if (str[i] < 'A')
                continue;       //0~9不需要经行操作

            // ASCII码表中 a = 1100001 A = 1000001
            // 与32 = 100000 进行异或操作(不同则为1)则可进行字母的大小写转换
            str[i] ^= 32;
            backtracking(str, i + 1);
            str[i] ^= 32;       //还原
        }
    }
}