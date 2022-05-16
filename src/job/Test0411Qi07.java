package job;

import java.util.ArrayList;

/**
 * 最长递增的身高排序队伍
 * @author 曾奕
 */
public class Test0411Qi07 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * func lengthOfMaxQueue(nums []int) int {
     return 0
     }
     * @param nums int整型ArrayList
     * @return int整型
     */
    public int lengthOfMaxQueueO (ArrayList<Integer> nums) {
        // write code here
        int len = nums.size();
        // res用于记录最大返回结果
        int res = 1;

        for (int i = 0; i < len; i++) {
            int count = 1;
            int cur = nums.get(i);
            for (int j = i + 1; j < len; j++) {
                if (nums.get(j) > cur) {
                    cur = nums.get(j);
                    count++;
                }

            }
            if (count > res) {
                res = count;
            }
        }

        return res;
    }

    public int lengthOfMaxQueue (ArrayList<Integer> nums) {
        // write code here
        int len = nums.size();
        // res用于记录最大返回结果
        int res = 1;

        for (int i = 0; i < len; i++) {
            res = Math.max(res, maxLength(i, nums));
        }

        return res;
    }

    private static int maxLength(int index, ArrayList<Integer> nums) {
        int maxCount = 1;
        for (int i = index + 1; i < nums.size(); i++) {
            int count = 1;
            int cur = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) > cur) {
                    cur = nums.get(j);
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
