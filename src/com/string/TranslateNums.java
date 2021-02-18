package com.string;

import java.util.ArrayList;
import java.util.Arrays;

public class TranslateNums {
    public static void main(String[] args) {
        TranslateNums translateNums  = new TranslateNums();
        System.out.println(translateNums.translateNum(12258));
        System.out.println(translateNums.translateNum(25));
        System.out.println(translateNums.translateNum(1));
    }
    public int translateNum(int num) {
        if(num<10)return 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (num!=0){
            arrayList.add(0,num%10);
            num/=10;
        }
        int b=1;
        int a=arrayList.get(0)*10+arrayList.get(1)>25?b:b+1;
        for (int i = 2; i < arrayList.size(); i++) {
            Integer val1 = arrayList.get(i);
            Integer val2 = arrayList.get(i-1);
            if(val1+val2*10>25||val2==0){
                int c = a;
                b=a;
                a=c;
            }else {
               int c = a+b;
               b=a;
               a=c;
            }
        }
        return a;
    }

}
