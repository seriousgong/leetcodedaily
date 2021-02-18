package com.array;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(dailyTemperatures.hashCode());
        System.out.println(dailyTemperatures);
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] T) {
        if (T == null) return null;
        else if (T.length == 0) return new int[]{0};
        int[] ans = new int[T.length];
        for (int i = T.length-2; i >=0; i--) {
            int next=i+1;
            while (true){
                if(T[next]>T[i]){
                    /*找到变热的日期*/
                    ans[i]=next-i;
                    break;
                }else {
                    if(ans[next]==0){
                        /*往后没有变热的日期*/
                        ans[i]=0;
                        break;
                    }else {
                        /*继续往后找*/
                        next=ans[next]+next;
                    }
                }
            }
        }
        return ans;
    }
}
