package com.dailyproblem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static int heightFlag = 0;

    public static List<Integer> rightSideView(TreeNode root, int height) {
        if (root != null) {
            if (heightFlag == height) {
                arrayList.add(root.val);
                heightFlag++;
            }
                rightSideView(root.right, height+1);
                rightSideView(root.left, height+1);

        }
        return arrayList;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        System.out.println(rightSideView(treeNode, 0));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
