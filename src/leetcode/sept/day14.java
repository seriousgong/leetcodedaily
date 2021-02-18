package leetcode.sept;

import java.util.*;


public class day14 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inorder(root);
        loop(root);
        return ans;
    }

    private void loop(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node = node.right;
        }

    }

    List<Integer> ans;

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        ans.add(node.val);
        inorder(node.right);
    }
}
