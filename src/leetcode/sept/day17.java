package leetcode.sept;

public class day17 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        /*题目规定二维数组包含了一颗树和一条不想关边，树节点与边的关系为n个节点有n-1条边，那么该有向图的节点数为n*/
        int[] parents = new int[edges.length + 1];
        int[] ancestor = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;/*都指向自己*/
            ancestor[i] = i;
        }
        int doublePars = -1;
        int cycle = -1;
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (parents[y] != y) {
                doublePars = i;
            } else {
                parents[y] = x;
                int a = find(ancestor, x);
                int b = find(ancestor, y);
                if (a == b) {
                    cycle = i;
                } else {
                    ancestor[a] = ancestor[b];
                }
            }
        }
        if (doublePars < 0) {
            /*存在环，则删除形成环的最后一条边*/
            return edges[cycle];
        } else if (cycle >= 0) {
            /*存在双父节点且存在环，那么应该删除双父节点的前一条边
             * */
            return new int[]{parents[edges[doublePars][1]], edges[doublePars][1]};
        } else {
            /*没有环，只有双父节点，最后形成父节点的那条边*/
            return edges[doublePars];
        }

    }

    int find(int[] ancestor, int x) {
        while (ancestor[x] != x) {
            x = ancestor[x];
        }
        return ancestor[x];
    }


    void dfs(int[][] edges) {

    }
}
