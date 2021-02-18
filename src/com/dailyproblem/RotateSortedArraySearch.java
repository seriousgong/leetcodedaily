package com.dailyproblem;

public class RotateSortedArraySearch {
    public static int index ;

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        index=-1;
        binarySort(nums,0,nums.length-1,target);
        return index;
    }

    private static void binarySort(int[] nums, int start ,int end,int target) {

        int mid = (end - start) / 2 + start;
        if(start<=end-1){
//            先判断有序无序数组
            if(nums[start]<nums[mid]){
                /*该出为有序数组*/
                if(target>=nums[start]&&target<=nums[mid]){
                    binarySort(nums,start,start+(end-start)/2,target);
                }else{
                    binarySort(nums,start+(end-start)/2+1,end,target);
                }
            }else{
                /*该出为有序数组*/
                if(target>=nums[start+(end-start)/2+1]&&target<=nums[end]){
                    binarySort(nums,start+(end-start)/2+1,end,target);
                }else{
                    binarySort(nums,start,start+(end-start)/2,target);
                }
            }
        }else {
            if (nums[start]==target){
                index=start;
            }
        }
    }
}
