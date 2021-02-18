package com.dailyproblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsSubTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(4, new TreeNode(1, new TreeNode(0), null), new TreeNode(2)), new TreeNode(5));
        TreeNode treeNode1 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(toString(treeNode));
        System.out.println(toString(treeNode1));
        System.out.println(isSubtree(treeNode, treeNode1));
        treeNode=new TreeNode(1,new TreeNode(2),null);
        treeNode1 = new TreeNode(2);
        System.out.println(treeNode);
        System.out.println(treeNode1);
        System.out.println(toString(treeNode));
        System.out.println(toString(treeNode1));
        System.out.println(isSubtree(treeNode, treeNode1));

    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(t.left==null&&t.right==null){

        }
        return toString(s).contains(toString(t));
    }
    public static boolean isSubtree_DFS(TreeNode s, TreeNode t) {
        if(t.left==null&&t.right==null){

        }
        return toString(s).contains(toString(t));
    }

    public  static String  toString(TreeNode treeNode){
        if(treeNode==null){
            return null;
        }
        return     "{" +
                "" + treeNode.val +
                "" + toString(treeNode.left) +
                "" + toString(treeNode.right) +
                '}';
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

       public TreeNode(int x) {
            val = x;
        }

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
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

}
