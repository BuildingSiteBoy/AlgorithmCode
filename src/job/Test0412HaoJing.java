package job;

import java.util.Scanner;

/**
 * 返回最长子串
 * 掌握kpm算法
 * @author zZeng
 */
public class Test0412HaoJing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        // 返回最长子串
        System.out.print(maxLongSub(str1, str2));
    }

    // 暴力求解
    private static String maxLongSub(String s, String t) {
        // maxStr用于记录最长子串，curStr用于记录现在的子串
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    int x = i, y = j;
                    String curStr = "";
                    while (x < s.length() && y < t.length() && s.charAt(x) == t.charAt(y)) {
                        curStr += s.charAt(x);
                        x++;
                        y++;
                    }
                    if (curStr.length() > maxStr.length()) {
                        maxStr = curStr;
                    }
                } else {
                    continue;
                }
            }
        }

        return maxStr;
    }
}
