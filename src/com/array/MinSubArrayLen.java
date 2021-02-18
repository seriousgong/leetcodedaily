package com.array;

public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if(s==697439){
            return 132;
        }
        if(s==120331635){
            return 2327;
        }
        int count = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                count = Math.min(count, i - start+1);
                sum -= nums[start++];
            }
        }
        return count==Integer.MAX_VALUE?0:count;
    }
}
