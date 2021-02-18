package leetcode.oct;

import java.util.HashMap;
import java.util.HashSet;

public class day28 {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> map = new HashSet<>();
        int[] arr1 = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            arr1[arr[i] + 1000]++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != 0) {
                if (!map.contains(arr1[i])) {
                    map.add(arr1[i]);
                }else return false;
            }
        }
        return true;
    }
}
