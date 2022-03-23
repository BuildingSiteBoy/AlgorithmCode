package leetCode;

/**
 * 二分查找
 * 278. 第一个错误的版本
 *
 * 如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；否则第一个错误的版本在 [m + 1, h] 之
 * 间，令 l = m + 1。
 * 因为 h 的赋值表达式为 h = m，因此循环条件为 l < h
 *
 * @author 曾奕
 */
public class Test278 {
    public static void main(String[] args) {

    }

    public static class Solution {
        public int firstBadVersion(int n) {
            int low = 0;
            int high = n;
            int mid;

            while (low <= high) {
                mid = low + (high - low) / 2;

//                if (isBadVersion(mid)) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
            }
            return low;
        }
    }
}

