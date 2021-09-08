package leetCode;

public class Test283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution283().moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i< nums.length; i++) {
            nums[i] = 0;
        }
    }
}
