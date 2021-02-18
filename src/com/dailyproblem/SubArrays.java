package com.dailyproblem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SubArrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -0;
        int ans = 0, sum = 0;
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        for (int i : nums) {
            sum += i & 1;
            map[sum]++;
            if (sum >= k) ans += map[sum - k];
        }
        return ans;
    }

    public static int numberOfSubarrays(int[] nums, int k, int flag) {
        int start = 0;
        int end = 0;
        int count = 0;
        for (int num : nums) {
            count += num & 1;
            end++;
            if (count == k) {
                break;
            }
        }
//        System.out.println(end);
        /*所以现在start-end 是刚好组成奇数为k个的子数组，接下来滑动数组*/
        int sum=0;
        while (end <= nums.length - 1) {
            int leftPointMoveCount =0;
            int rightPointMoveCount ;
            int temp = end;
            /*滑动右指针*/
            while (end<nums.length&&(nums[end]&1)==0){
                end++;
            }
            rightPointMoveCount=end-temp+1;
            /*滑动左指针*/
            while ((nums[start]&1)==0){
                start++;
                leftPointMoveCount++;
            }
            sum+=(leftPointMoveCount)*(rightPointMoveCount);
            start++;
            count--;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3,2));
        System.out.println(numberOfSubarrays(new int[]{2, 4, 6}, 1,2));
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2, 2));
    }
}
