package leetCode;

public class Test167 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 19, 24};
        Solution167 s = new Solution167();
        int[] res = s.twoSum(nums, 26);

        for (int n : res) {
            System.out.println(n);
        }
    }
}

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }
}
