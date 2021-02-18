package leetcode.oct;

import java.util.Arrays;

public class day16 {
    public static void main(String[] args) {
        day16 d = new day16();
//        d.sortedSquares(new int[]{-4, -1, 0, 3, 10});
//        System.out.println(Arrays.toString(d.sortedSquares(new int[]{-2, 0})));
        System.out.println(Arrays.toString(d.sortedSquares(new int[]{-3,-1, 0})));
    }

    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return A;

        if (A[0] >= 0) {
            for (int i = 0; i < A.length; i++) {
                A[i] *= A[i];
            }
            return A;
        } else if (A[A.length - 1] <= 0) {
            for (int i = 0; i <= A.length - 1 - i; i++) {
                int temp = A[i] * A[i];
                A[i] = A[A.length - 1 - i] * A[A.length - 1 - i];
                A[A.length - 1-i] = temp;
            }
            return A;
        } else {
            int temp = -1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= 0) {
                    temp = i;
                    break;
                }
            }
            System.out.println(temp);
            int[] ans = new int[A.length];
            int i = -1;
            int j = -1;
            int a = 0;
            if (A[temp] == 0) {
                i = temp - 1;
                j = temp + 1;
                ans[a++] = 0;
            } else {
                i = temp - 1;
                j = temp;
            }
            System.out.println(i);
            System.out.println(j);
            while (i != -1 || j != A.length) {
                int x = Integer.MAX_VALUE;
                int y = Integer.MAX_VALUE;
                if (i >= 0) x = A[i] * A[i];
                if (j < A.length) y = A[j] * A[j];
                if (x < y) {
                    ans[a++] = x;
                    i--;
                } else if (x == y && x != Integer.MAX_VALUE) {
                    ans[a++] = x;
                    ans[a++] = y;
                    i--;
                    j++;
                } else {
                    ans[a++] = y;
                    j++;
                }
            }
            return ans;
        }
    }
}
