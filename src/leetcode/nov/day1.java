package leetcode.nov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class day1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }
        HashSet<Integer> hashSet1 = new HashSet();
        for (int i : nums2) {
            if (hashSet.contains(i)) hashSet1.add(i);
        }
        int[] res = new int[hashSet1.size()];
        int index = 0;
        for (Integer integer : hashSet1) {
            res[index++] = integer;
        }
        return res;
    }
}
