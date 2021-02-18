package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Integer, Node> map;
//    Node[] isVisit;

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map = new HashMap<>();
//        isVisit = new Node[101];
        return dfs(node);
    }

    Node dfs(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        else {
            Node n = new Node(node.val, new ArrayList<>());
            map.put(node.val, n);
            for (Node neighbor : node.neighbors) {
                n.neighbors.add(dfs(neighbor));
            }
            return n;
        }
//        if (isVisit[node.val] == null) {
//            Node n = new Node(node.val, new ArrayList<>());
//            isVisit[node.val] = n;
//
//            for (Node neighbor : node.neighbors) {
//                n.neighbors.add(dfs(neighbor));
//            }
//            return n;
//        } else return isVisit[node.val];
    }

}
