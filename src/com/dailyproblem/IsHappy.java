package com.dailyproblem;

import java.util.ArrayList;
import java.util.HashSet;

public class IsHappy {
    public static boolean isHappy(int n) {
        int num2=0;
       while (n!=4&&n!=1){
           while (n!=0){
               num2+=(n%10)*(n%10);
               n/=10;
           }
           n=num2;
           num2=0;

       }
       return n==1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(89));
    }
}
