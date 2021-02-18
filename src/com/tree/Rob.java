package com.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Rob {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    /*返回值 index 0  表示该节点未被选择 ; index 1 表示该节点被选择  */
    int[] dfs(TreeNode node) {
        int[] ans = new int[2];
        if (node != null) {
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            ans[1] = left[0] + right[0] + node.val; //该节点被标记则，子节点必须选择为不标记
            ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 该节点违背标记则自由组合取最大值
        }
        return ans;
    }
}
