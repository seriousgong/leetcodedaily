package leetcode.sept;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        sum1 = sum;
        temp = new LinkedList<>();
        ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, 0);
        return ans;
    }

    int sum1;

    List<List<Integer>> ans;
    LinkedList<Integer> temp;

    void dfs(TreeNode node, int sum) {
        if (node == null) return;
        if (node.left == null && node.right == null && sum + node.val == sum1) {
            temp.addLast(node.val);
            ans.add(new ArrayList<>(temp));
            temp.removeLast();
            return;
        }
        temp.addLast(node.val);
        dfs(node.left, sum + node.val);
        dfs(node.right, sum + node.val);
        temp.removeLast();
    }
}
