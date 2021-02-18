package com.matrix;

import java.util.Arrays;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            int[] ints = obstacleGrid[i];
            for (int i1 = 0; i1 < ints.length; i1++) {
                if (obstacleGrid[i][i1] == 1) {
                    dp[i][i1] = 0;
                    continue;
                }
                if (i == 0 && i1 == 0) dp[i][i1] = 1;
                if (i == 0) dp[i][i1] += dp[i][i1 - 1];
                else if (i1 == 0) dp[i][i1] += dp[i - 1][i1];
                else {
                    dp[i][i1] += dp[i - 1][i1];
                    dp[i][i1] += dp[i][i1 - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
