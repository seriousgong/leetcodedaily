package com.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBipartite {
    public static void main(String[] args) {
        IsBipartite i = new IsBipartite();
        System.out.println(i.isBipartite(new int[][]{new int[]{1, 3}, new int[]{0, 2}, new int[]{1, 3}, new int[]{0, 2}}));
    }

    int[] marks;

    public boolean isBipartite(int[][] graph) {
        marks = new int[graph.length];
        Arrays.fill(marks, -1);

        for (int i = 0; i < graph.length; i++) {

            if (marks[i] == -1) {
                marks[i] = 1;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int next : graph[node]) {
                        if (marks[next] == -1) {
                            marks[next] = marks[node] ^ 1;
                            stack.push(next);
                        } else {
                            if (marks[next] == marks[node]) return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}
