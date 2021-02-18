package com.matrix;

import java.util.Arrays;

public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
//        System.out.println(Arrays.toString(spiralOrder.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
//        System.out.println(Arrays.toString(spiralOrder.spiralOrder(new int[][]{})));
//        System.out.println(Arrays.toString(spiralOrder.spiralOrder(new int[][]{{},{}})));
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(new int[][]{{1,2}})));
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(new int[][]{{1},{2}})));
    }

    public int[] spiralOrder(int[][] matrix) {
        int[] ans;
        int count = 0;
        int length = matrix.length;
        if (length == 0 || matrix[0].length == 0) {
            return ans = new int[0];
        } else {
            int width = matrix[0].length;
            ans = new int[length * width];
            int x = 0;
            int y = -1;
            int rightCount = 0;
            int leftCount = 0;
            int upCount = 0;
            int downCount = 0;
            while (count != ans.length) {
                /*向右*/
                for (int i = 1; i <= width - upCount - downCount; i++) {
                    ans[count] = matrix[x][++y];
                    count++;
                }
                rightCount++;
                /*向下*/
                for (int i = 1; i <= length - leftCount - rightCount; i++) {
                    ans[count] = matrix[++x][y];
                    count++;
                }
                downCount++;
                /*向左*/
                if(count==ans.length)break;
                for (int i = 1; i <= width - upCount - downCount; i++) {
                    ans[count] = matrix[x][--y];
                    count++;
                }
                leftCount++;
                /*向上*/
                for (int i = 1; i <= length - leftCount - rightCount; i++) {
                    ans[count] = matrix[--x][y];
                    count++;
                }
                upCount++;
            }
            return ans;
        }


    }
}
