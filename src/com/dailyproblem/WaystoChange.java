package com.dailyproblem;

public class WaystoChange {
    public static int waysToChange(int n) {

        int result = 0;
        for (int i = 0; 25*i<=n; i++) {
            int rest = n-25 * i;
            int max10 = rest / 10;
            int max5 = rest % 10 / 5;
            result = (result+ (max10 + max5 + 1)* (max10 + 1))%1000000007;

        }
        return  result;

    }
    public static int sum =0;
    public  static  int sumNums(int n){
        boolean b = n > 0 && (sum += sumNums(n - 1) + n) > 0;
        return sum;
    }
    public static void main (String[]args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(waysToChange(5));
        System.out.println(waysToChange(10));
        System.out.println(waysToChange(15));
        System.out.println(waysToChange(20));
        System.out.println(waysToChange(25));
        System.out.println(waysToChange(30));
        System.out.println(waysToChange(35));
        System.out.println(waysToChange(61));
        System.out.println(waysToChange(900750));

    }
}
