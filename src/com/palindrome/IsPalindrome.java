package com.palindrome;

import java.util.ArrayList;
import java.util.Stack;

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "";
        System.out.println(s == "");
        System.out.println(2.0 / 0); //浮点数除0/0.0 是一个无穷尽的结果
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(121));
        System.out.println(isPalindrome.isPalindrome(10));
        System.out.println(isPalindrome.isPalindrome(-10));
        System.out.println(isPalindrome.isPalindrome(0));
    }
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        else{
            int temp = x;
            int sum = 0;
            while (x!=0){
                sum=sum*10+x%10;
                x/=10;
            }
            System.out.println(sum);
            return temp==sum;
        }

    }
}
