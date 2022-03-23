package leetCode;

/**
 * 完美二叉树
 * @author 曾奕
 */
public class TreeNodePerfect {
    int val;
    TreeNodePerfect left;
    TreeNodePerfect right;
    TreeNodePerfect next;

    public TreeNodePerfect() {
    }

    public TreeNodePerfect(int val) {
        this.val = val;
    }

    public TreeNodePerfect(int val, TreeNodePerfect left,
                           TreeNodePerfect right, TreeNodePerfect next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
