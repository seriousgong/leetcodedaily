package leetcode.oct;

import java.util.ArrayList;
import java.util.List;

public class day15 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    List<Node> nodes;

    public Node connect(Node root) {
        nodes = new ArrayList<>();
        dfs(root, 0);
        return root;
    }

    void dfs(Node node, int level) {
        if (node == null) return;
        if (nodes.size() <= level) {
            nodes.add(node);
        } else {
            nodes.get(level).next = node;
            nodes.set(level, node);
        }
        dfs(node.left, level);
        dfs(node.right, level);
    }
}
