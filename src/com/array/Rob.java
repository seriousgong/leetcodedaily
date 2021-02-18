package com.array;


public class Rob {
    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob.rob(new int[]{2, 1, 1, 2}));
        System.out.println(rob.rob(new int[]{4, 1, 2, 7, 5, 3, 1}));
        System.out.println(rob.robMemoryDP(new int[]{4, 1, 2, 7, 5, 3, 1}));
        System.out.println(rob.robMemoryDP(new int[]{1, 2, 3, 1}));
        System.out.println(rob.robMemoryDP(new int[]{2, 1, 1, 2}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        if (nums.length == 1) return nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }

    public int robMemoryDP(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int maxSum = Math.max(nums[0], nums[1]);
        int lastSum = nums[0];
        int temp;
        for (int i = 2; i < nums.length; i++) {
            lastSum = Math.max(lastSum + nums[i], lastSum);
            temp = maxSum;
            maxSum = Math.max(lastSum, maxSum);
            lastSum = temp;
        }
        return maxSum;
    }
}
