package com.tree;

public class MinDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int minLevel;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return 1 + left + right;
        }

        if (left > right) return 1 + right;
        else return 1 + left;


    }
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        minLevel = Integer.MAX_VALUE;
//        dfs(root, 1);
//        return minLevel;
//    }

    void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            minLevel = Math.min(level, minLevel);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
