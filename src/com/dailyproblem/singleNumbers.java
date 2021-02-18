package com.dailyproblem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class singleNumbers {
    public int[] singleNumbers(int[] nums) {
        /*整组异或运算*/
        int n=0;
        for (int num : nums) {
            n^=num;
        }
        /*此时n的值为两个出现次数为1的数的二进制位区别的值*/
        /*取其中一位不同的值作为区分*/
        int diffBit = n&(-n);
        int a =0;
        for (int num : nums) {
            if((num&diffBit)==0)a^=num;
        }
        return new int[]{a,(a^diffBit)};
    }

public static  int firstValue=0 ;
    public static void main(String[] args) {
        xor(4);
        xor(1);
        xor(4);
        xor(6);
        xor(4);
        xor(3);
        xor(7);
        xor(14);
        xor(2);
        System.out.println(7 ^ 1);
        System.out.println(14 & 1);
//        System.out.println(5 ^ 4 ^ 5 ^ 4 ^ 3 ^ 2 ^ 1);
    }

    private static void xor(int i) {
        firstValue^=i;
        System.out.println(firstValue);
    }
}
