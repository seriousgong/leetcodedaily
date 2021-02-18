package com.dfs;

import java.util.Arrays;

public class MinPathSum {
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        dp = new int[grid.length][grid[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs(grid, grid.length - 1, grid[0].length - 1);

    }

    int[][] dp;

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        if (dp[x][y] != -1) return dp[x][y];
        if (x == 0 && y == 0) return grid[x][y];
        int min = Math.min(dfs(grid, x - 1, y), dfs(grid, x, y - 1));
        if (min == Integer.MAX_VALUE) return grid[x][y];
        dp[x][y] = min + grid[x][y];
        return dp[x][y];


    }
}
