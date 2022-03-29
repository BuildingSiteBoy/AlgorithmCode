package leetCode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * @author 曾奕
 */
public class Test108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int sIdx, int eIdx) {
        if (sIdx > eIdx) {
            return null;
        }
        int m = (sIdx + eIdx) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = toBST(nums, sIdx, m - 1);
        root.right = toBST(nums, m + 1, eIdx);
        return root;
    }
}
