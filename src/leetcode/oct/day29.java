package leetcode.oct;

public class day29 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {

        ans = 0;
        dfs(root, 0);
        return ans;
    }

    int ans;

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum = sum * 10 + node.val;
        if (node.left != null) dfs(node.left, sum);
        if (node.right != null) dfs(node.right, sum);
        if (node.right == null && node.left == null) ans += sum;
    }
}
