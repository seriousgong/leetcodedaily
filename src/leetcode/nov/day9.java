package leetcode.nov;

import java.util.Arrays;

public class day9 {
    public int[][] kClosest(int[][] points, int K) {
        k = K;
        flag = false;
        quick(points, 0, points.length - 1);
        int[][] ans = new int[K][2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = points[i];
        }
        return Arrays.copyOf(points, K);
    }

    int k;
    boolean flag;

    void quick(int[][] points, int start, int end) {
        if (flag) return;
        if (start < 0 || start > end || end >= points.length) return;
        int l = start;
        int r = end;
        int[] s = points[start];
        int sum = s[0] * s[0] + s[1] * s[1];
        while (l < r) {
            while (l < r && (points[r][0] * points[r][0] + points[r][1] * points[r][1]) > sum) {
                r--;
            }
            while (l < r && (points[l][0] * points[l][0] + points[l][1] * points[l][1]) <= sum) {
                l++;
            }
            if (l < r) {
                int[] temp = points[l];
                points[l] = points[r];
                points[r] = temp;
            }
        }
        /*基准数归位*/
        int[] temp = points[start];
        points[start] = points[l];
        points[l] = temp;
        if (l == k) {
            flag = true;
            return;
        }
        if (l < k) quick(points, l + 1, end);
        else quick(points, start, l - 1);
    }
}
