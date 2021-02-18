package com.dp;

public class MaxProfit {
    public static void main(String[] args) {
        String s1 = "a" + "bc";
        String s2 = "ab" + "c";
        System.out.println(s1 == s2);
        String a = "a";
        String bc = "bc";
        String s3 = "a" + "bc";
        String s4 = a + bc;
        System.out.println(s3 == s4);
        final String a1 = "a";
        final String b1 = "bc";
        String s5 = "a" + "bc";
        String s6 = a1 + b1;
        System.out.println(s5 == s6);
        final String x = a;
        final String x1 = "bc";
        String x2 = x + x1;
        String s7 = "a" + "bc";
        System.out.println(s7 == x2);

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0]; //今天持股  1:昨天就持股  2：今天刚买入
        dp[0][1] = 0;   //今天卖出
        dp[0][2] = 0;  //不持股啥也不做 1:昨天买入，今天冷冻期啥也不能做  2:昨天不持股啥也没做，今天保持原样
        //存在第其他情况，及 持股，昨日有卖出
        //根据规定 买卖前提时卖出必须卖出全部，买卖不能同时进行 所以 买入卖出只有两种情况,所以只有三种情况
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[0][2] - prices[i], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
