package com.dailyproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class reversePairs {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4, 6, 5}));
    }

    public static int merageSort(int[] nums, int left, int right,int[] temp) {
        if(left==right){
            return 0;
        }
        int middle =  left +(right-left)/2;
        int letcount = merageSort(nums, left, middle,temp);
        int rightcount = merageSort(nums, middle+1, right,temp);
//        while (left<right)
        return 0;

    }

    public static int reversePairs(int[] nums) {
//        维护一个hashmap，但value会冲突，所以值为一个list
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> integers = hashMap.get(nums[i]);
            if (integers == null) {
                integers = new ArrayList<>();
                hashMap.put(nums[i], integers);
            }
            integers.add(i);
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            ArrayList<Integer> integers = hashMap.get(nums[i]);
            for (Integer index : integers) {
                if (i - index > 0) {
                    count += (i - index);
                } else if (i - index == 0) {
                    count += 1;
                }
            }
        }
        System.out.println(hashMap);
        System.out.println(Arrays.toString(nums));
        return count;

    }

    public static void Partition(int[] array, int lower, int upper) {
        int mid = array[(lower + upper) >> 1];
        int pointer1 = lower, pointer2 = upper;
        do {
            while (array[pointer1] < mid)
                pointer1++;
            while (array[pointer2] > mid)
                pointer2--;
            if (pointer1 <= pointer2) {
                int tmp;
                tmp = array[pointer1];
                array[pointer1] = array[pointer2];
                array[pointer2] = tmp;
                pointer1++;
                pointer2--;
            }
        } while (pointer1 <= pointer2);
        if (lower < pointer2)
            Partition(array, lower, pointer2);
        if (pointer1 < upper)
            Partition(array, pointer1, upper);
    }
}
