package leetcode.sept;

public class day21 {


    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }

    }

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        dfs(root);
        return root;
    }


    int sum;

    void dfs(TreeNode node) {
        if (node == null) return;
        int val = node.val;
        dfs(node.right);
        node.val += sum;
        sum += val;
        dfs(node.left);
    }
}
