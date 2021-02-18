package leetcode.oct;

import java.util.Arrays;

public class day26 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[101];

        for (int i = 0; i < nums.length; i++) {
            ans[nums[i]]++;
        }
        int last = 0;
        for (int i = 0; i < ans.length; i++) {
            int an = ans[i];
            if(an==0)continue;
            ans[i] = last;
            last += an;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[nums[i]];
        }
        return nums;
    }
}
