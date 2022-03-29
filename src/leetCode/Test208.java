package leetCode;

/**
 * 208. 实现 Trie (前缀树)
 * @author 曾奕
 */
public class Test208 {
}

class Trie {
    private class Node {
        Node[] child = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    public Trie() {}

    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node root) {
        if (root == null) {
            return;
        }
        if (word.length() == 0) {
            root.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (root.child[index] == null) {
            root.child[index] = new Node();
        }
        insert(word.substring(1), root.child[index]);
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node root) {
        if (root == null) {
            return false;
        }
        if (word.length() == 0) {
            return root.isLeaf;
        }
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), root.child[index]);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, Node root) {
        if (root == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        int index = indexForChar(prefix.charAt(0));
        return startsWith(prefix.substring(1), root.child[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}
