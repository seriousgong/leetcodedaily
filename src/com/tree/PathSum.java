package com.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode t = new TreeNode(-2, null, new TreeNode(-3, null, null));
        System.out.println(pathSum.pathSum(t, -5));
    }

    int ans;

    public int pathSum(TreeNode root, int sum) {
        return pathSumWithOlogn(root, sum);
    }

    private int pathSumWithOlogn(TreeNode root, int sum) {
        ArrayList<Integer> a = new ArrayList<>();
        int [] arr = new int[0];
        return recursionforOlogn(root, sum, arr);
    }

    public int recursionforOlogn(TreeNode node, int sum,int[] arr) {
        if (node != null) {
            int[] newArr = new int[arr.length+1];
            System.arraycopy(arr,0,newArr,0,arr.length);
            int result = 0;
            for (int i = 0; i < newArr.length; i++) {
                newArr[i]+= node.val;
                if (newArr[i] == sum) result++;
            }
            result += (recursionforOlogn(node.left, sum, newArr) + recursionforOlogn(node.right, sum, newArr));
            return result;
        }
        return 0;
    }

    private int pathSumWithOn(TreeNode root, int sum) {
        ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            recursion(node, sum);
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return ans;
    }

    public void recursion(TreeNode node, int sum) {
        if (node != null) {
            if (sum - node.val == 0) ans++;
            recursion(node.left, sum - node.val);
            recursion(node.right, sum - node.val);
        }

    }
}
