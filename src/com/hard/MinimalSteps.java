//package com.hard;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;
//
//public class MinimalSteps {
//    int len;
//    int wide;
//
//    public int minimalSteps(String[] maze) {
//        len = maze.length;
//        wide = maze[0].length();
//        /*找到S起点*/
//        int[] start = new int[2];
//        /*T终点*/
//        int[] end = new int[2];
//        /*找到M的数量*/
//        List<int[]> Ms = new ArrayList<>();
//        /*找到O的数量*/
//        List<int[]> Os = new ArrayList<>();
//        for (int i = 0; i < maze.length; i++) {
//            String s = maze[i];
//            for (int i1 = 0; i1 < s.length(); i1++) {
//                if (s.charAt(i1) == 'S') {
//                    start[0] = i;
//                    start[1] = i1;
//                } else if (s.charAt(i1) == 'M') {
//                    Ms.add(new int[]{i, i1});
//                } else if (s.charAt(i1) == 'O') {
//                    Os.add(new int[]{i, i1});
//                } else if (s.charAt(i1) == 'T') {
//                    end[0] = i;
//                    end[1] = i1;
//                }
//            }
//        }
//        int[][] dis_S = bfs(start, maze); //起点到每个点的距离
//        int[][] dis_T = bfs(end, maze); //起点到每个点的距离
//        List<int[][]> Ms_dis = new ArrayList<>(); //每个机关点到每个点的距离
//        for (int i = 0; i < Ms.size(); i++) {
//            Ms_dis.add(bfs(Ms.get(i), maze));
//        }
//        List<int[][]> Os_dis = new ArrayList<>(); //每个石头堆到每个点的距离
//        for (int i = 0; i < Os.size(); i++) {
//            Os_dis.add(bfs(Os.get(i), maze));
//        }
//
//        for (int i = 0; i < Os_dis.size(); i++) {
//
//        }
//
//    }
//
//    private int[][] bfs(int[] location, String[] maze) {
//
//        int[][] dis = new int[maze.length][maze[0].length()];
//        for (int[] di : dis) Arrays.fill(di, -1);
//        dis[location[0]][location[1]] = 0;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(location);
//        while (!queue.isEmpty()) {
//            int[] lo = queue.poll();
//            int x = lo[0];
//            int y = lo[1];
//            int[][] four = new int[][]{new int[]{x, y - 1}, new int[]{x - 1, y}, new int[]{x, y + 1}, new int[]{x + 1, y}};
//            for (int i = 0; i < four.length; i++) {
//                int a = four[i][0];
//                int b = four[i][1];
//                if (inBound(a, b) && dis[a][b] == -1 && maze[a].charAt(b) != '#') {
//                    dis[a][b] = dis[x][y] + 1;
//                    queue.offer(four[i]);
//                }
//            }
//        }
//        return dis;
//    }
//
//    boolean inBound(int x, int y) {
//        return x <= len && x >= 0 && y <= wide && y >= 0;
//    }
//}
