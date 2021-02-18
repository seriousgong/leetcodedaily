package leetcode.tree;


import java.util.Stack;

public class Traversal {

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

    /**
     * 前序遍历递归做法
     */
    public void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历迭代做法
     */
    public void preOrderOfiteration(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop().left;
        }

    }

    /**
     * 中序遍历递归做法
     */
    public void inOrder(TreeNode node) {
        if (node == null) return;
        preOrder(node.left);
        System.out.println(node.val);
        preOrder(node.right);
    }

    /**
     * 中序遍历迭代做法
     */
    public void inOrderOfiteration(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
        }

    }

}
