package leetcode.sept;

import java.util.Arrays;

public class day1 {
    public static void main(String[] args) {
        day1 d = new day1();
//        System.out.println(d.PredictTheWinner(new int[]{1}));
//        System.out.println(d.PredictTheWinner(new int[]{1,2}));
        System.out.println(d.PredictTheWinner(new int[]{1, 5, 2}));
    }

    public boolean PredictTheWinner(int[] nums) {

        if (nums == null || nums.length == 0) return true;

//        return dliver(nums, 0, nums.length - 1, 1) >= 0;
        return dp(nums);
    }

    boolean dp(int[] nums) {

        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        /*从后遍历，从最后一个*/
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                dp[i][i1] = Math.max(nums[i] - dp[i + 1][i1], nums[i1] - dp[i][i1 - 1]);
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[0][len - 1] >= 0;
    }

    boolean dp1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        /*从后遍历，从最后一个*/
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                System.out.println(Arrays.toString(dp));
                dp[i1] = Math.max(nums[i] - dp[i + 1], nums[i1] - dp[i1 - 1]);
            }
        }
        return dp[len - 1] >= 0;
    }

    int dliver(int[] nums, int left, int right, int choose) {
        if (left == right) {
            return nums[left] * choose;
        }

        int num = nums[left] * choose + dliver(nums, left + 1, right, choose * -1);
        int num1 = nums[right] * choose + dliver(nums, left, right - 1, choose * -1);
        /*不论是哪个玩家都要取最大的数，那么是先手玩家就要取正数最大,后手玩家就要取负数最小的*/
        if (choose == 1) {
            return Math.max(num, num1);
        } else {
            return Math.min(num, num1);
        }
//        return Math.max(num * choose,? num1 * choose) * choose;

    }
}
