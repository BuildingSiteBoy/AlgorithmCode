package job;

import java.util.Scanner;

/**
 * 标语
 * 小团接到了一个宣传任务。他需要根据给定的核心思想设计一条宣传标语。如果把核心思想和宣传标语都视为字符串，则他认为一条标语的有力程度体现在该标语有多少个连续子串中包含了核心思想作为其子序列。现在给出他收到的核心思想和他设计的标语，他想知道这条标语的有力程度。
 *
 * 一个字符串s的连续子串即从s的开头和结尾分别删去数个（可以是零个）字符所得的字符串。对于两个连续子串，即使逐字符相等，从开头和结尾分别删除的字符数量不同则被视为不同的连续子串。如abab有a,b,a,b,ab,ba,ab,aba,bab,abab这十个连续子串。
 *
 * 一个字符串s的子序列则是从s中删去一些（可以是零个，不能是所有）字符后所得的字符串。对于两个子序列，即使逐字符相等，删除的字符位置不同则被视为不同的子序列。如aba有a,b,a,ab,aa,ba,aba这7个子序列。
 *
 * 输入由两行字符串组成，第一行是小团设计的标语，第二条是小团收到的核心思想。
 *
 * 字符串均非空且仅由小写英文字母组成。标语的长度不超过5000，核心思想的长度不超过100。
 *
 * 输出一个整数，代表小团设计的标语的有力程度。
 * @author 曾奕
 */
public class Test0402MeiTuan03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入数据
        String str = in.nextLine();
        String target = in.nextLine();
        int lenS = str.length();
        int lenT = target.length();
        int count = 0;

        while (lenT <= lenS) {
            for (int i = 0; i + lenT <= lenS; i++) {
                String cur = str.substring(i, i + lenT);
                //if (i + lenT == lenS) {
                //    cur = str.substring(i);
                //} else {
                //    cur = str.substring(i, i + lenT);
                //}
                if (cur.contains(target)) {
                    //System.out.println(cur);
                    count++;
                }
            }
            lenT++;
        }

        System.out.println(count);
    }
}
