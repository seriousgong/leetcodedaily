package leetcode.nov;

import java.util.Arrays;

public class day12 {
    public static void main(String[] args) {
        day12 s = new day12();
        s.sortArrayByParityII(new int[]{4, 2, 5, 7});
    }

    public int[] sortArrayByParityII(int[] A) {
        /*偶数*/
        int even = 0;
        /*奇数*/
        int odd = 1;
        for (int i = 0; i < A.length; i++) {
            if ((i & 1) == 0 && (A[i] & 1) == 1) {
                while (odd < A.length && (A[odd] & 1) == 1) {
                    odd += 2;
                }
                if (odd < A.length) {
                    int temp = A[i];
                    A[i] = A[odd];
                    A[odd] = temp;
                }

            } else if ((i & 1) == 1 && (A[i] & 1) == 0) {
                while (even < A.length && (A[even] & 1) == 0) {
                    even += 2;
                }
                if (even < A.length) {
                    int temp = A[i];
                    A[i] = A[even];
                    A[even] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(A));
        return A;
    }
}
