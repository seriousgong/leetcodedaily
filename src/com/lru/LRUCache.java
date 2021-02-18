package com.lru;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * LRU表示最近最少使用缓存机制*,只存储一段时间的数据，满数据删除/
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache;
//        ["LRUCache","put","get","put","get","get"]
//[[1],[2,1],[2],[3,2],[2],[3]]
        lruCache = new LRUCache(1);


        lruCache = new LRUCache(3);
        //        ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
//[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));

        lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
//        ["LRUCache","put","put","put","put","get","get"]
//[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }

    private int capacity;
    private HashMap<Integer, Node> kTims;
    Node header;
    Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.kTims = new HashMap<>(capacity);
        header = new Node();
        end = new Node();
        header.next = end;
        end.last = header;
    }

    public int get(int key) {
        Node node = kTims.get(key);
        if(node!=null){
            removeNode(node);
            addNode(node);
        }
        return node == null ? -1 : node.value;
    }

    private void addNode(Node node) {
        node.next = header.next;
        header.next.last=node;
        node.last = header;
        header.next = node;
    }

    private void removeNode(Node node) {
        Node last = node.last;
        Node next = node.next;
        last.next = next;
        next.last = last;
    }

    public void put(int key, int value) {
        Node tempNode = kTims.get(key);
        if (tempNode == null) {
            /*新增*/
            if (kTims.size() == capacity) {
                Node needRemoveNode = end.last;
                removeNode(needRemoveNode);
                kTims.remove(needRemoveNode.key);
            }
            Node node = new Node(key, value, header, null);
            addNode(node);
            kTims.put(key, node);
        } else {
            /*更新*/
            tempNode.value = value;//更新值
            removeNode(tempNode);
            addNode(tempNode);
        }

    }

    private static class Node {
        Integer key;
        Integer value;
        Node last;
        Node next;

        public Node() {
        }

        public Node(Integer key, Integer value, Node last, Node next) {
            this.key = key;
            this.value = value;
            this.last = last;
            this.next = next;
        }

    }

}
