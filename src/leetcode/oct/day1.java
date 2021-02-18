package leetcode.oct;

public class day1 {
    public static void main(String[] args) {
        day1 d = new day1();
        System.out.println(d.minimumOperations("yry"));
    }

    public int minimumOperations(String leaves) {
        if (leaves == null || leaves.equals("")) return 0;
        int[][] dp = new int[leaves.length()][3];
        dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        dp[0][1] = dp[0][2] = dp[1][2] = 10000000;
        for (int i = 1; i < leaves.length(); i++) {
            char c = leaves.charAt(i);
            if (c == 'r') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + 1;
                if (i > 1)
                    dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]);
            } else if (c == 'y') {
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]);
                dp[i][0] = dp[i - 1][0] + 1;
                if (i > 1)
                    dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + 1;
            }
        }
        return dp[leaves.length() - 1][2];
    }
}
