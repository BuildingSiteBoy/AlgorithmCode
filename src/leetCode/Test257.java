package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：Backtracking
 * 257. 二叉树的所有路径
 * @author 曾奕
 */
public class Test257 {
    public List<String> binaryTreePaths(TreeNode257 root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    private void backtracking(TreeNode257 root, List<Integer> values, List<String> paths) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        if (isLeaf(root)) {
            paths.add(buildPath(values));
        } else {
            backtracking(root.left, values, paths);
            backtracking(root.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }

    private boolean isLeaf(TreeNode257 root) {
        return root.left == null && root.right == null;
    }
}

class TreeNode257 {
    int val;
    TreeNode257 left;
    TreeNode257 right;

    public TreeNode257() {
    }

    public TreeNode257(int val) {
        this.val = val;
    }

    public TreeNode257(int val, TreeNode257 left, TreeNode257 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
