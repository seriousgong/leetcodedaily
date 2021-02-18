package com.array;

import java.util.Arrays;
import java.util.Stack;

public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int target = nums[start];
            int l = start;
            int r = end;
            while (start < end) {
                while (start < end && nums[end] > target) {
                    end--;
                }
                while (start < end && nums[start] < target) {
                    start++;
                }
                if (start > end) break;
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            if (start == end) {
                nums[start] = target;
            }
            quickSort(nums, l, start - 1);
            quickSort(nums, start + 1, r);
        }
    }
}
