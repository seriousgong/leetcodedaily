package leetcode.sept;

import java.util.*;

public class day29 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            if (pop == null) continue;
            ans.addLast(pop.val);

            stack.push(pop.left);

            stack.push(pop.right);
        }
        System.out.println(ans);
        return ans;
    }

    public List<Integer> preOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeNode node = root;
        List<Integer> ret = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node.right);
                // 先序遍历
                ret.add(node.val);
                node = node.left;
            }
            node = stack.pop();
        }
        return ret;
    }

    public List<Integer> inOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeNode node = root;
        List<Integer> ret = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ret.add(node.val);
            node = node.right;
        }
        return ret;
    }

    public List<Integer> postOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeNode node = root;
        List<Integer> ret = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            stack.push(node);
            node = node.right;
            ret.add(node.val);
        }
        return ret;
    }
}
