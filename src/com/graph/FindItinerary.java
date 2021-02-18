package com.graph;

import java.util.*;

public class FindItinerary {


    /**
     * 欧拉图与半欧拉图
     * 欧拉图: 恰好有一条能连通所有节点的回路(欧拉回路)
     * 半欧拉图: 有一条连通所有节点的通路(欧拉通路),且没有欧拉回路
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) map.put(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        ans = new LinkedList<>();
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }

    HashMap<String, PriorityQueue<String>> map;
    LinkedList<String> ans;

    void dfs(String ticket) {
        while (map.containsKey(ticket) && map.get(ticket).size() > 0) {
            PriorityQueue<String> queue = map.get(ticket);
            String next = queue.poll();//推出队列顶端即字典序最小的机票
            dfs(next);
        }
        /*路线走完*/
        ans.addFirst(ticket);
    }
}
