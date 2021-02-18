package com.dp;

import java.util.Arrays;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int length = grid.length;
        int length1 = grid[0].length;
        int[][] dp = new int[length][length1];
        dp[0][0] = 0;
        for (int i = 0; i < length; i++) {
            int[] ints = grid[i];
            for (int i1 = 0; i1 < ints.length; i1++) {
                if (i == 0 && i1 == 0) dp[0][0] = grid[i][i1];
                else if (i == 0) dp[i][i1] = dp[i][i1 - 1] + grid[i][i1];
                else if (i1 == 0) dp[i][i1] = dp[i - 1][i1] + grid[i][i1];
                else {
                    dp[i][i1] = Math.min(dp[i - 1][i1], dp[i][i1 - 1]) + grid[i][i1];
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[length - 1][length1 - 1];
    }
}
