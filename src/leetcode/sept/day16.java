package leetcode.sept;

public class day16 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    void reversal(TreeNode node) {
        if (node == null) return;
        TreeNode left = node.left;
        TreeNode right = node.right;
        reversal(node.left);
        reversal(node.right);
        node.left = right;
        node.right = left;

    }
}
