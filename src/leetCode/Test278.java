package leetCode;

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

