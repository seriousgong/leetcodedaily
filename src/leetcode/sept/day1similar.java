package leetcode.sept;

/**
 * question 887 石子游戏
 */
public class day1similar {
    public boolean stoneGame(int[] piles) {
        if (piles == null || piles.length == 0) return true;
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];//表示每次最后剩下一个石子堆
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
            return dp[0][n-1]>=0;
    }
}
