package leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day6 {

    int[] ans;
    int[] nodeNum;
    int num;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        num = N;
        ans = new int[N];
        nodeNum = new int[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        Arrays.fill(nodeNum, 1);
        postOrder(0, -1);
        return ans;
    }

    void postOrder(int number, int parent) {

        List<Integer> list = graph.get(number);
        for (Integer integer : list) {
            if (parent == integer) continue;
            postOrder(integer, number);
            nodeNum[number] += nodeNum[integer];
        }
        ans[number] = nodeNum[number];
    }

    void preOrder(int number, int parent) {
        List<Integer> list = graph.get(number);
        for (Integer integer : list) {
            if(parent==integer)continue;
            ans[integer] = ans[number] + nodeNum[integer] + (num - nodeNum[integer]);
            preOrder(integer, number);
        }
    }
}
