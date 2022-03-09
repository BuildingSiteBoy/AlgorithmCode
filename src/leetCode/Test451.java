package leetCode;

import java.util.*;

/**
 * 排序问题
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列
 * @author 曾奕
 */
public class Test451 {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = frequencyForNum.entrySet();
        // 小顶堆
        //PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        // 大顶堆
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> entry : entries) {
            queue.offer(entry);
        }

        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> node = queue.poll();
            for (int i = 0; i < node.getValue(); i++) {
                str.append(node.getKey());
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String s = "abbcccdddeeffffff";
        System.out.println(new Test451().frequencySort(s));
    }
}
