package leetCode;

import java.util.*;

/**
 * 1606. 找到处理最多请求的服务器
 * @author 曾奕
 */
public class Test1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> ava = new TreeSet<>();
        for (int i = 0; i < k ; i++) {
            ava.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                ava.add(busy.poll()[1]);
            }
            if (ava.isEmpty()) {
                continue;
            }
            Integer p = ava.ceiling(i % k);
            if (p == null) {
                p = ava.first();
            }
            requests[p]++;
            busy.offer(new int[] {arrival[i] + load[i], p});
            ava.remove(p);
        }

        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                res.add(i);
            }
        }
        return res;
    }
}
