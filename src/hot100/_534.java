package hot100;

public class _534 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int a = dfs(node.left);
        int b = dfs(node.right);
        max = Math.max(a + b + 2, max);
        System.out.println(max);
        return Math.max(a + 1, b + 1);
    }

}
