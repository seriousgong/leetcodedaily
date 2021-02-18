package com.array;

import org.w3c.dom.css.CSSRuleList;

public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicateBinarySearch(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate.findDuplicateBinarySearch(new int[]{ 3, 4, 2, 3,3}));
//        System.out.println(findDuplicate.findDuplicate(new int[]{3,1,3,4,2}));
//        System.out.println(findDuplicate.findDuplicate(new int[]{1,1}));
//        System.out.println(findDuplicate.findDuplicate(new int[]{1,1,2}));
//        System.out.println(findDuplicate.findDuplicate(new int[]{2,1,1}));
        System.out.println(findDuplicate.findDuplicateBinarySearch(new int[]{26, 2, 9, 20, 31, 7, 14, 32, 37, 15, 29, 6, 12, 38, 48, 22, 19, 45, 42, 40, 1, 12, 25, 36, 39, 30, 35, 4, 27, 12, 49, 16, 47, 3, 44, 41, 8, 17, 21, 23, 10, 43, 12, 34, 24, 28, 33, 13, 46, 11}));
    }

    public int findDuplicate(int[] nums) {
        /*空间复杂度为O1 ，且不允许操作原数组*/
        /*n+1个整数 位于[1,n]之间，规定只有一个数重复，且该数>=2*/
        /*仅有一个数重复，那么该数组只有一个回环，(n+1个整数在1+n之间比有一个重复，如果在1-n+1之间不重复，那么没有回环可以直接归位)*/
        /*因此只有一个回环代表只有一个数是重复的，那么找到改回环的起点或终点即可，优化：因为起点比终点小，所以找起点*/
        int slow = 0;//慢指针走一步
        int fast = 0;//快指针每次走2，3，4步其实都可以
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);
        System.out.println(slow);
        System.out.println(nums[slow]);
        System.out.println(fast);
        System.out.println(nums[fast]);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public int findDuplicateBinarySearch(int[] nums) {

        int maxNumber = nums.length - 1;
        int start=0;
        while (start<=maxNumber){
            int middleNum = (start+maxNumber )/ 2;
            int count = 0;

            for (int num : nums) {
                if(num<=middleNum){
                    count++;
                }
            }
            if(count<=middleNum){
                start=middleNum+1;
            }else {
                maxNumber=middleNum-1;

            }
        }
        return maxNumber+1;
    }
}
