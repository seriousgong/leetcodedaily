package leetcode.nov;

import java.util.Arrays;
import java.util.HashMap;

public class day14 {
    public static void main(String[] args) {
        day14 d = new day14();
        System.out.println(Arrays.toString(d.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length == arr2.length) return arr2;
        int[] a = new int[1001];
        for (int i : arr1) {
            a[i]++;
        }
        int index = 0;
        for (int i : arr2) {
            while (a[i] > 0) {
                arr1[index++] = i;
                a[i]--;
            }
        }
        int[] n = new int[arr1.length - index];
        int index1 = 0;
        for (int i = 0; i < a.length; i++) {
            while (a[i] != 0) {
                n[index1++] = i;
                a[i]--;
            }
        }
        Arrays.sort(n);
        System.arraycopy(n, 0, arr1, index, n.length);
        return arr1;
    }



}
