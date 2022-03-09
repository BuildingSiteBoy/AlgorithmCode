package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2100. 适合打劫银行的日子
 * @author 曾奕
 */
public class Test2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        //List<Integer> res = new ArrayList<>();
        //int n = security.length;
        //// 计算递减序列
        //int[] pre = new int[n + 1];
        //
        //pre[0] = 0;
        //pre[1] = 0;
        //
        //for (int i = 2; i <= n; i++) {
        //    if (security[i - 1] <= security[i - 2]) {
        //        pre[i] = pre[i - 1] + 1;
        //    }
        //}
        //
        //int[] aft = new int[n + 1];
        //aft[n] = 0;
        //aft[n - 1] = 0;
        //for (int i = n - 2; i >= 0; i--) {
        //    if (security[i] <= security[i + 1]) {
        //        aft[i] = aft[i + 1] + 1;
        //    }
        //}
        //
        //for (int i = time; i < n - time; i++) {
        //    if (pre[i + 1] >= time && aft[i] >= time){
        //        res.add(i);
        //    }
        //}
        //
        //return res;
        List<Integer> res = new ArrayList<>();
        int n = security.length;

        // 计算非递增序列
        int[] pre = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            }
        }

        // 计算非递减序列
        int[] aft = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                aft[i] = aft[i + 1] + 1;
            }
        }

        for (int i = time; i < n; i++) {
            if (pre[i] >= time && aft[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
