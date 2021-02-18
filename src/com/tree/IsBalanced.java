package com.tree;

import java.util.IllegalFormatCodePointException;

public class IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean flag;

    public boolean isBalanced(TreeNode root) {
        flag = true;
        isBalance(root, 0);
        return flag;
    }

    int isBalance(TreeNode node, int level) {
        if (node == null) return level;
        int len1 = isBalance(node.left, level + 1);
        int len2 = isBalance(node.left, level + 1);
        System.out.println(len1);
        System.out.println(len2);
        if (len1 - len2 > 1 || len1 - len2 < -1) flag = false;
        return Math.max(len1, len2);
    }
}
