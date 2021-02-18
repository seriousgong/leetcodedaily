package leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class day4 {


    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }

    }


    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, new StringBuilder());
        return ans;
    }

    List<String> ans;

    void dfs(TreeNode root, StringBuilder subStr) {
        if (root == null) {
            return;
        }
        subStr.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(subStr.substring(2));
        } else {
            dfs(root.left, new StringBuilder(subStr));
            dfs(root.right, new StringBuilder(subStr));
        }
    }
}
