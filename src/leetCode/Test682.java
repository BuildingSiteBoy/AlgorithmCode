package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 682. 棒球比赛
 * @author 曾奕
 */
public class Test682 {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if ("C".equals(s)) {
                list.remove(index);
                index--;
            } else if ("D".equals(s)) {
                list.add(list.get(index) * 2);
                index++;
            } else if ("+".equals(s)) {
                list.add(list.get(index) + list.get(index - 1));
                index++;
            } else {
                list.add(Integer.valueOf(s));
                index++;
            }
        }

        int res = 0;
        for (int l : list) {
            res += l;
        }
        return res;
    }
}
