package com.array;


import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        /*创建ans数组，不计入空间复杂度*/
        int[] ans = new int[nums.length];
        int maxProduct=1;
        for (int i = 0; i < nums.length; i++) {
            ans[i]=maxProduct;
            maxProduct*=nums[i];
        }
        System.out.println(Arrays.toString(ans));
        int proxuct=1;
        for (int i = nums.length-1; i >= 0; i--) {
            ans[i]*=proxuct;
            proxuct*=nums[i];
        }
        return ans;

    }

    private int mod(int product, int num) {
            int count=0;
            while (product!=0){
                product-=num;
                count++;
            }
            return count;
    }


}
