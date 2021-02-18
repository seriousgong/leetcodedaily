package leetcode.oct;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class day27 {


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

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null && !stack.empty()) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().left;
        }

        return ans;
    }

    private List<Integer> ans;

    private void dfs(TreeNode node) {
        if (node == null) return;
        ans.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
