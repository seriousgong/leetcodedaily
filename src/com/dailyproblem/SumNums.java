package com.dailyproblem;

public class SumNums {
    static  int sum=0;
    public static void main(String[] args) {
        SumNums sumNums = new SumNums();

    }
    public int sumNums(int n) {
        return  n;
    }
    int Add(int x,int y){
        if(y==0)  { return x; } //没有进位时完成运算
        int sum,carry;
        sum=x^y;
        carry=(x&y)<<1;
        return Add(sum,carry); //递归相加
    }
    public int sumNumsDli(int n) {
        boolean b = n > 0 && (sum += sumNumsDli(n - 1)) > 0;
        return n;
    }
}
