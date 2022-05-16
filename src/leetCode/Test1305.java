package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * @author 曾奕
 */
public class Test1305 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);
        Collections.sort(res);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
