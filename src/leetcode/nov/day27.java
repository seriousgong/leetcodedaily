package leetcode.nov;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day27 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : A) {
            for (int i1 : B) {
                System.out.println(i + i1);
                map.put(i + i1, map.getOrDefault(i + i1, 0) + 1);
            }
        }
        System.out.println(map);
        int res = 0;
        for (int i : C) {
            for (int i1 : D) {
                res += map.getOrDefault(-i - i1, 0);
            }
        }
        return res;
    }


}
