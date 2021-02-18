package com.array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandy {
    public static void main(String[] args) {
        System.out.println(0.3f == 0.3f);
        KidsWithCandy kidsWithCandy = new KidsWithCandy();
        System.out.println(kidsWithCandy.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWithCandy.kidsWithCandies(new int[]{4,2,1,1,2}, 1));
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max=Math.max(max,candy);
        }
        List<Boolean> list = new ArrayList<>();
        for (int candy : candies) {
            if(max<=candy+extraCandies)list.add(true);
            else list.add(false);
        }

        return  list;
    }
}
