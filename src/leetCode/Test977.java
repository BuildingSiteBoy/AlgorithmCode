package leetCode;

public class Test977 {
    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] nums2 = {-7, -3, 2, 3, 11};

        Solution977 s = new Solution977();
        //int[] arrs = s.sortedSquares(nums1);
        int[] arrs = s.sortedSquares(nums2);

        for (int arr : arrs) {
            System.out.println(arr);
        }
    }
}

class Solution977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        //排序
        //Arrays.sort(nums);
        //冒泡排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }
}
