package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：Backtracking
 * 93. 复原 IP 地址
 * @author 曾奕
 */
public class Test93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        doRestore(0, temp, addresses, s);
        return addresses;
    }

    private void doRestore(int k, StringBuilder temp, List<String> addresses, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                addresses.add(temp.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (temp.length() != 0) {
                    part = "." + part;
                }
                temp.append(part);
                doRestore(k + 1, temp, addresses, s.substring(i + 1));
                temp.delete(temp.length() - part.length(), temp.length());
            }
        }
    }
}
