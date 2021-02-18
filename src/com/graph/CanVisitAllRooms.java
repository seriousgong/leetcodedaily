package com.graph;

import java.util.ArrayList;
import java.util.List;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        size = rooms.size();
        isVist = new int[size];
        count = 0;
        dfs(rooms, 0);
        return ans;
    }

    void dfs(List<List<Integer>> rooms, int roomKey) {
        if (rooms == null || rooms.size() == 0) return;
        if (ans) return;

        if (isVist[roomKey] == 0) {
            isVist[roomKey] = 1;
            count++;
            if (count == size) {
                ans = true;
                return;
            }
            for (Integer key : rooms.get(roomKey)) {
                dfs(rooms, key);
            }
        }
    }

    int count;
    boolean ans;
    int[] isVist;
    int size;
}
