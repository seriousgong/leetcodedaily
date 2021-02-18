package com.array;

public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0)return new int[]{};
        if(shorter==longer)return new int[]{shorter*k};
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {//长板的数量
            ans[i] = i*longer+(k-i)*shorter;
        }
        return ans;

    }
}
