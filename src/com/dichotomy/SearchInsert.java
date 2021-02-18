package com.dichotomy;

public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert s = new SearchInsert();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 1));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(s.searchInsert(new int[]{1, 3}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3,5}, 4));
        System.out.println(s.searchInsert(new int[]{1, 3}, 3));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) return 0;
        else if (nums[nums.length - 1] < target) return nums.length;
        else{
            return search(nums, target);
        }
    }

    private int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
            while (start<end){
                if(target==nums[start]){
                    return start;
                }else if(target==nums[end]){
                    return end;
                }else{
                    if(start+1==end){
                        if(nums[start]<target&&nums[end]>target)return start+1;
                    }
                    int mid = start+(end-start)/2;
                    if(target>nums[mid]){
                        start=mid+1;
                    }else if(target==nums[mid]){
                        return mid;
                    }else {
                        end=mid-1;
                    }
                }
            }
            if(target>nums[start])return start+1;
            else if(target<nums[end])return start;
            else return start;
    }
}
