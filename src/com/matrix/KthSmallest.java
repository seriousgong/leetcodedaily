package com.matrix;

public class KthSmallest {
    public static void main(String[] args) {
        int[][] a =new int[][]{new int[]{1, 5, 9}, new int[]{10, 11, 13}, new int[]{12, 13, 15}};
        KthSmallest s = new KthSmallest();
//        System.out.println(s.kthSmallest(a, 8));
        System.out.println(s.kthSmallest(new int[][]{new int[]{5}}, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0)return -1;
        int[] index = new int[matrix.length];
        int min;
        int count = 0;
        while (true) {
            min=Integer.MAX_VALUE;
            int flag = 0;
            for (int i = 0; i < index.length; i++) {
                if (index[i] < matrix[0].length) {
                    if (matrix[i][index[i]] < min) {
                        min = matrix[i][index[i]];
                        flag=i;
                    }
                }
            }
            index[flag]++;
            count++;
            if(count==k) break;
        }
        return min;
    }
}
