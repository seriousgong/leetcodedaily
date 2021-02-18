package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArraysDivByK {
    public static void main(String[] args) {
        System.out.println(-3 % -5);
        SubArraysDivByK subArraysDivByK = new SubArraysDivByK();  // 4    9   9  7    4  5
        System.out.println(subArraysDivByK.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(subArraysDivByK.subarraysDivByK(new int[]{5}, 9));
        System.out.println(subArraysDivByK.subarraysDivByK(new int[]{-5}, 5));
        System.out.println(subArraysDivByK.subarraysDivByK(new int[]{0, -5}, 10));
        System.out.println(subArraysDivByK.subarraysDivByK(new int[]{1, -10, 5}, 9));
    }

    public int subarraysDivByK(int[] A, int K) {

        int []mods = new int[K];
        int sum = 0;
        int count = 0;
        mods[0]=1;//自身能被K整除，不需要等到找到第二个余数相等的时候，才+1
        for (int i : A) {
            sum += i;
            int mod = (sum % K + K) % K;//取余的绝对值
            count += mods[mod]++;/*取出上次余数相同的情况次数,并自增*/
        }

        return count;
    }

}
