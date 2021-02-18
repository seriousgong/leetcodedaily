package leetcode.sept;

public class day27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) return null;
        return dfs(root, p.val, q.val);
    }

    TreeNode dfs(TreeNode node, int p, int q) {

        if (node == null) return null;
        if (node.val == p || node.val == q) {
            return node;
        }
        if (node.val > p && node.val > q) {
            return dfs(node.left, p, q);
        } else if (node.val < p && node.val < q) {
            return dfs(node.right, p, q);
        } else return node;

    }
}
