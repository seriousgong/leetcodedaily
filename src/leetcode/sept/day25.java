package leetcode.sept;

import java.util.HashMap;

public class day25 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        mid = inorder;
        post = postorder;
        root = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1);
    }

    HashMap<Integer, Integer> map;
    int[] mid;
    int[] post;
    int root;

    TreeNode dfs(int x, int y) {
        if (x > y) return null;
        TreeNode node = new TreeNode(post[root]);
        Integer rootIndex = map.get(post[root]);
        root--;
        node.right = dfs(rootIndex + 1, y);
        node.left = dfs(x, rootIndex -1);
        return node;
    }
}
