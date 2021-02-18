package leetcode.sept;

public class day28 {
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

    public Node connect(Node root) {
        bfs(root);
        return root;
    }

    private void bfs(Node root) {
        if (root == null || (root.left == null && root.right == null)) return;
        Node temp = root;
        Node last = null;

        if (root.left != null && root.right != null) root.left.next = root.right;
        while (temp != null) {
            if (temp.left == null && temp.right != null) {
                if (last != null) {
                    last.next = temp.right;
                }
                last = root.right;
            } else if (root.right == null && temp.left != null) {
                if (last != null) {
                    last.next = temp.left;
                }
                last = root.left;
            } else {
                if (last != null) {
                    last.next = temp.left;
                }
                last = temp.right;
            }
            temp = temp.next;
        }
        bfs(root.right);
        bfs(root.left);

    }
}
