package com.array;

public class FindLength {
    public static void main(String[] args) {
        FindLength findLength = new FindLength();
//        System.out.println(findLength.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
//        System.out.println(findLength.findLength(new int[]{0, 1, 1, 1, 0}, new int[]{1, 1, 1, 1, 1}));
        System.out.println(findLength.findLength(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0}));
    }

    public int findLength(int[] A, int[] B) {
//        return findLengthOn3(A, B);
//        return findLengthOn2_dp(A, B);
        return findLengthOn2_window(A, B);
    }

    public int findLengthOn3(int[] A, int[] B) {

        int maxLen = 0;
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                int len = 0;
                int index = i;
                int index1 = i1;
                while (index < A.length && index1 < B.length && A[index] == B[index1]) {
                    len++;
                    index++;
                    index1++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }

    public int findLengthOn2_dp(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int maxLen = 0;
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                if (A[i] == B[i1]) {
                    if (i - 1 >= 0 && i1 - 1 >= 0) {
                        dp[i][i1] = 1 + dp[i - 1][i1 - 1];
                    } else {
                        dp[i][i1] = 1;
                    }
                    maxLen = Math.max(dp[i][i1], maxLen);
                }
            }
        }
        return maxLen;
    }

    public int findLengthOn2_window(int[] A, int[] B) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int index = 0;
            while (index < B.length) {

                while (index < B.length && B[index] != A[i]) {
                    index++;
                }
                if (index >= B.length) continue;
                int index1 = i;
                int len = 0;
                while (index < B.length && index1 < A.length && B[index] == A[index1]) {
                    index++;
                    index1++;
                    len++;
                }
                ans = Math.max(len, ans);
            }
        }
        for (int i = 0; i < B.length; i++) {
            int index = 0;
            while (index < A.length) {

                while (index < A.length && A[index] != B[i]) {
                    index++;
                }
                if (index >= A.length) continue;
                int index1 = i;
                int len = 0;
                while (index < A.length && index1 < B.length && B[index1] == A[index]) {
                    index++;
                    index1++;
                    len++;
                }
                ans = Math.max(len, ans);
            }
        }
        return ans;
    }
}
