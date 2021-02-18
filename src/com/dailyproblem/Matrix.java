package com.dailyproblem;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 存在转向的不确定因素
 */

public class Matrix {
    public static void main(String[] args) {

        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = updateMatrix(matrix);
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1]+" ");
            }
            System.out.println();
        }
    }

    /**
     *
     */
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        int[] xChange = {-1, 1, 0, 0};
        int[] yChange = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            /*取出零坐标*/
            int[] location = queue.poll();
            int x = location[0], y = location[1];
            /*向四个方向扩散*/
            for (int i = 0; i < 4; i++) {
                int newX = x+xChange[i];
                int newY = y+yChange[i];
                if(newX>=0&&newX<matrix.length&&newY>=0&&newY<matrix[0].length&&matrix[newX][newY]==-1){
                        matrix[newX][newY] = matrix[x][y]+1;
                        queue.offer(new int[]{newX,newY});
                }
            }

        }
        return matrix;
    }
}
