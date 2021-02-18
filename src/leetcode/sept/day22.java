package leetcode.sept;

public class day22 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minCameraCover(TreeNode root) {
        int dfs = dfs(root);
        if (dfs == 2) return ans + 1;
        else return ans;
    }

    //0 被监控
    //1 被观测
    //2 无状态

    int ans;

    int dfs(TreeNode node) {
        if (node == null) return 1;
        int val1 = dfs(node.left);
        int val2 = dfs(node.right);
        if (val1 == 1 && val2 == 1) return 2;
        else if (val1 == 2 || val2 == 2) {
            ans++;
            return 0;
        } else {
            return 1;
        }
    }

    // index 0  当前节点装监控
    // index 1  整棵树都符合要求
    // index 2  当前节点不符合要求
    int[] dfs1(TreeNode node) {
        if (node == null) return new int[]{10000, 0, 0};

        int[] val1 = dfs1(node.left);
        int[] val2 = dfs1(node.right);

        int stat0 = val1[1] + val2[1] + 1;
        int stat1 = Math.min(val1[0] + val2[1], val1[1] + val2[0]);
        int stat2 = Math.min(stat0, val1[1] + val1[2]);

        return new int[]{stat0, stat1, stat2};
    }


    int min(int... a) {
        int min = Integer.MAX_VALUE;
        for (int i : a) {
            min = Math.min(min, i);

        }
        return min;
    }
}

