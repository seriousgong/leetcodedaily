package com.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    public static void main(String[] args) {
        IsBipartite i = new IsBipartite();
        System.out.println(i.isBipartite(new int[][]{new int[]{1, 3}, new int[]{0, 2}, new int[]{1, 3}, new int[]{0, 2}}));
    }

    int[] marks;

    public boolean isBipartite(int[][] graph) {
        marks = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            if (marks[i] == 0) {
                marks[i] = 1;

                while (!queue.isEmpty()) {
                    Integer node = queue.poll();

                    for (int i1 : graph[node]) {
                        if (marks[i1] == 0) {
                            marks[i1] = -marks[node];
                            queue.offer(i1);
                        } else {
                            if (marks[i1] == marks[node]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
