package leetcode.nov;

import java.util.Arrays;

public class day26 {
    public static void main(String[] args) {
        Long asd = 2L;
        System.out.println(asd.toString());
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
