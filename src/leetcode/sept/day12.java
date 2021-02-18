package leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class day12 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> nums;
    List<Double> ans;

    public List<Double> averageOfLevels(TreeNode root) {
        nums = new ArrayList<>();
        ans = new ArrayList<>();
        dfs(root, 0);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) / nums.get(i));
        }
        return ans;
    }

    void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (nums.size() <= level) {
            nums.add(0);
        }
        if (ans.size() - 1 <= level) {
            ans.add(0.0);
        }
        nums.set(level, nums.get(level) + 1);
        ans.set(level, ans.get(level) + node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
