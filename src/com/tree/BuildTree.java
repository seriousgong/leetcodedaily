package com.tree;

import java.util.Stack;

public class BuildTree {
    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        System.out.println(buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        System.out.println(buildTree.buildTree(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println(buildTree.buildTree(new int[]{}, new int[]{}));
        System.out.println(buildTree.buildTree(new int[]{1, 3, 4, 5, 2}, new int[]{4, 3, 5, 1, 2}));
    }

    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*中序确定左右顺序*/
        /*前序确定根节点*/
        index = 0;
        return recursion(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int[] inoeder, int start, int end) {
        if (index > inoeder.length - 1 || start > end) {
            return null;
        }
        int nodeValue = preorder[index++];
        TreeNode treeNode = new TreeNode(nodeValue);
        int parentNodeIndex = findParentNode(inoeder, nodeValue, start, end);
        treeNode.left = recursion(preorder, inoeder, start, parentNodeIndex - 1);
        treeNode.right = recursion(preorder, inoeder, parentNodeIndex + 1, end);
        return treeNode;
    }

    private int findParentNode(int[] array, int value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        TreeNode(int x) {
            val = x;
        }

    }

}
