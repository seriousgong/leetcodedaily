package com.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public static void main(String[] args) {
        GenerateTrees g = new GenerateTrees();
        System.out.println(g.generateTrees(2));
    }

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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();

        return recall(n, 1, n);
    }

    private List<TreeNode> recall(int n, int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = recall(n, start, i-1);
            List<TreeNode> rightSubTrees = recall(n, i+ 1, end);

            for (int i1 = 0; i1 < leftSubTrees.size(); i1++) {
                for (int i2 = 0; i2 < rightSubTrees.size(); i2++) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftSubTrees.get(i1);
                    node.right = rightSubTrees.get(i2);
                    list.add(node);
                }
            }
        }
        return list;

    }
}
