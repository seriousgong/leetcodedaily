package leetcode.sept;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day9 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        dfs(candidates, target, 0, 0);
        return ans;
    }

    List<List<Integer>> ans;
    LinkedList<Integer> temp;

    void dfs(int[] arr, int target, int sum, int index) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = index; i < arr.length; i++) {
            if (sum + arr[i] > target) continue;
            temp.addLast(arr[i]);
            dfs(arr, target, sum + arr[i], i);
            temp.removeLast();
        }
    }

}
