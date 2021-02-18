package com.dichotomy;

public class MinArray {
    public static void main(String[] args) {
        MinArray m = new MinArray();
//        System.out.println(m.minArray(new int[]{1, 3, 5}));
//        System.out.println(m.minArray(new int[]{3,4,5,1,2}));
//        System.out.println(m.minArray(new int[]{3,4,5,1,2}));
//        System.out.println(m.minArray(new int[]{2,2,2,0,1}));
        System.out.println(m.minArray(new int[]{10,1,10,10,10}));
    }
    public int minArray(int[] numbers) {
        if(numbers==null)return 0;
        if(numbers.length<=2)return numbers.length==2?Math.min(numbers[0],numbers[1]):numbers[0];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if(numbers[mid]<numbers[end]){
                end=mid;
            }else if(numbers[mid]>numbers[end]){
                start=mid+1;
            }else {
                end--;
            }
        }
        return numbers[start];
    }
}
