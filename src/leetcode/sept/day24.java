package leetcode.sept;

import java.util.*;

public class day24 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map;

    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        max = 0;
        dfs(root);
        List<Integer> list = new ArrayList<>();
        int[] temp = new int[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                temp[index++] = entry.getKey();
            }
        }
        return index == map.size() ? temp : Arrays.copyOfRange(temp, 0, index);
    }

    int max = 0;

    void dfs(TreeNode node) {
        if (node == null) return;
        int i = map.getOrDefault(node.val, 0) + 1;
        max = Math.max(max, i);
        map.put(node.val, i);
        dfs(node.left);
        dfs(node.right);
    }
}
