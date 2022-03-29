package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 利用中序遍历统计个数
 * @author 曾奕
 */
public class Test501 {
    private int curCount = 1;
    private int maxCount = 1;
    private TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCountNums = new ArrayList<>();
        inOrder(root, maxCountNums);
        int[] res = new int[maxCountNums.size()];
        int i = 0;
        for (int num : maxCountNums) {
            res[i++] = num;
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> maxCountNums) {
        if (root == null) {
            return;
        }
        inOrder(root.left, maxCountNums);
        if (pre != null) {
            if (pre.val == root.val) {
                curCount++;
            } else {
                curCount = 1;
            }
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            maxCountNums.clear();
            maxCountNums.add(root.val);
        } else if (curCount == maxCount) {
            maxCountNums.add(root.val);
        }
        pre = root;
        inOrder(root.right, maxCountNums);
    }
}
