package leetcode.sept;

public class day19 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }


    int dfs(TreeNode node, boolean flag) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null && flag) {
            return node.val;
        }
        return dfs(node.left, true) + dfs(node.right, false);
    }

}
