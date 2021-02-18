package com.array;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int i1 = i+1; i1 < nums.length; i1++) {
                if(nums[i1]<nums[i])count++;
            }
                ans.add(count);
        }
        return ans;
    }
}
