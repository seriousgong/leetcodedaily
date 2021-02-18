package com.dailyproblem;

public class MySqrt {
    public static  int mySqrt(int x) {
        int start = 1;
        int end = x/2;
        int n=0;
        while (true){
            int middle = (start+end)/2;
            if(end-start==1){
                n=end*end<=x?end:start;
                break;
            }else {
                if(middle*middle>x)end=middle;
                else start=middle;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(4));
    }
}
