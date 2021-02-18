package com.dailyproblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxmalSquqre {
    public static void main(String[] args) {
       char [][] matrix = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix,final int flag) {
            /*将0看成海洋，将1看成陆地，要找到面积为正方形的陆地*/
        int columns = matrix.length;
        if(columns==0)return 0;
        int rows = matrix[0].length;
        ArrayList<ArrayList<Integer>> lianxuArray = new  ArrayList<>(columns);
        for (int i = 0; i < columns; i++) {
            int start=0;
            int end=0;
            for (int i1 = 0; i1 < rows; i1++) {
                if(matrix[i][i1]==0){
                    start=i1;
                }
            }
        }


        return 0;
    }
    public static int maximalSquare(char[][] matrix) {
        /*一层一层来*/
        int columns = matrix.length;
        if(columns==0){
            return 0;
        }
        int rows = matrix[0].length;
        /*假设现在没有0的位置*/
        int maxSquare = 0;
        int [][] dp =new int[columns][rows];
        for (int start = 0; start < columns; start++) {
            for (int i = 0; i < matrix[start].length; i++) {
                if(matrix[start][i]=='1'){
                        if(start==0||i==0){
                            dp[start][i]=1;
                        }else {
                            dp[start][i]=Math.min(Math.min(dp[start-1][i],dp[start][i-1]),dp[start-1][i-1])+1;
                        }
                }
                maxSquare = Math.max(maxSquare,dp[start][i]*dp[start][i]);
            }
        }
        return maxSquare;
    }
}