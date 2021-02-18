package hot100;

public class _124 {
    public static class TreeNode {
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

    private int ans;

    public int maxPathSum(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int l1 = dfs(node.left);
        int l2 = dfs(node.right);
        int max1 = Math.max(l1 + node.val, l2 + node.val);
        max1 = Math.max(max1, node.val);
        int res = max1;
        ans = Math.max(ans, Math.max(max1, l1 + l2 + node.val));
        return res;
    }


}
