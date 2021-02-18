package com.tree;

public class IsSameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recursive(p, q);
    }

    boolean recursive(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        else if (n1 == null | n2 == null) return false;
        else {
            if (n1.val == n2.val) {
                return recursive(n1.left, n2.left) && recursive(n1.right, n2.right);
            } else return false;
        }
    }
}
