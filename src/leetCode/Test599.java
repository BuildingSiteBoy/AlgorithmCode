package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 599. 两个列表的最小索引总和
 * @author 曾奕
 */
public class Test599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (index.containsKey(list2[i])) {
                int j = index.get(list2[i]);
                if (i + j < indexSum) {
                    res.clear();
                    res.add(list2[i]);
                    indexSum = i + j;
                } else if (i + j == indexSum) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
