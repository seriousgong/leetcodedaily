package leetcode.oct;

public class day12Simalier {
    public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int minDiffInBST(TreeNode root) {
        last = -1;
        ans = Integer.MAX_VALUE;
        inOrder(root);
        return ans;
    }

    int last;
    int ans;

    void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (last != -1) {
            ans = Math.min(node.val - last, ans);
        }
        last = node.val;
        inOrder(node.right);

    }
}
