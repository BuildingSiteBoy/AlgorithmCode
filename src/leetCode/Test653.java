package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 * @author 曾奕
 */
public class Test653 {
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode653 root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        // DFS
        return findTarget(root.right, k) || findTarget(root.left, k);
    }

    public boolean findTargetE(TreeNode653 root, int k) {
        // 中序遍历
        inOrderTraversal(root);
        // 双指针查找两数之和
        int l = 0, h = list.size() - 1;
        while (l < h) {
            if (list.get(l) + list.get(h) == k) {
                return true;
            } else if (list.get(l) + list.get(h) < k) {
                l++;
            } else {
                h--;
            }
        }
        return false;
    }

    private void inOrderTraversal(TreeNode653 root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}


class TreeNode653 {
    int val;
    TreeNode653 left;
    TreeNode653 right;
    TreeNode653 next;

    public TreeNode653() {
    }

    public TreeNode653(int val) {
        this.val = val;
    }

    public TreeNode653(int val, TreeNode653 left,
                       TreeNode653 right, TreeNode653 next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
