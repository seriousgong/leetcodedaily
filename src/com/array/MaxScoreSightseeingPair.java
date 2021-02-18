package com.array;

import java.util.Stack;

public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
        MaxScoreSightseeingPair maxScoreSightseeingPair = new MaxScoreSightseeingPair();
        System.out.println(maxScoreSightseeingPair.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }
    public int maxScoreSightseeingPair(int[] A) {

        int maxi=A[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            ans=Math.max(ans,maxi+A[i]-i);
            maxi=Math.max(maxi,A[i]+i);
        }

        return  ans;

    }
}
