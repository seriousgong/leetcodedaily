package leetcode.nov;

import java.util.Arrays;
import java.util.Date;

public class day8 {
    public static void main(String[] args) {
        System.out.println(new Date());
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = -prices[i];
                dp[i][0] = 0;
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return dp[prices.length - 1][1];
    }
}
