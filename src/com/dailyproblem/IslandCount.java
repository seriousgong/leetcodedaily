package com.dailyproblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IslandCount {
    public  static int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int colLen = grid.length;
        int isLandCount = 0;
        /*将陆地置为1表示未访问,访问后替换为2*/
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    queue.offer(new int[]{i,j});
                    while (!queue.isEmpty()){
                        int[] isLand = queue.poll();if(grid[isLand[0]][isLand[1]]=='2') continue;
                        grid[isLand[0]][isLand[1]]='2';
                        if(isLand[0]-1>=0&&grid[isLand[0]-1][isLand[1]]=='1')queue.offer(new int[]{isLand[0]-1,isLand[1]});
                        if(isLand[0]+1<colLen&&grid[isLand[0]+1][isLand[1]]=='1')queue.offer(new int[]{isLand[0]+1,isLand[1]});
                        if(isLand[1]-1>=0&&grid[isLand[0]][isLand[1]-1]=='1')queue.offer(new int[]{isLand[0],isLand[1]-1});
                        if(isLand[1]+1<grid[0].length&&grid[isLand[0]][isLand[1]+1]=='1')queue.offer(new int[]{isLand[0],isLand[1]+1});
                    }
                    isLandCount++;
                }
            }
        }
        return isLandCount;
    }

    public static void main(String[] args) {
//        System.out.println(numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));

    }
}
