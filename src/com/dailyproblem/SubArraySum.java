package com.dailyproblem;

public class SubArraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0));
    }
    public  static  int subarraySum(int[] nums, int k) {
        if (nums.length==1){
            return  nums[0]==k?1:0;
        }
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i+1; j<nums.length  ; j++) {
                if(sum==k) count++;
                sum+=nums[j];
            }
            count+=(sum==k?1:0);
        }
        return  count;
    }
}
