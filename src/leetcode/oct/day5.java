package leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class day5 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        arr = nums;
        temp = new LinkedList<>();
        ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) continue;
            list.add(i);
        }
        System.out.println(list);
        dfs(list, 0, target, 0);
        return ans;
    }

    int[] arr;
    List<List<Integer>> ans;
    LinkedList<Integer> temp;

    void dfs(List<Integer> nums, int index, int target, int num) {
        if (nums == null) return;
        if (num == 4 && target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (num >= 4) return;
        int flag = 0;
        for (int i = index; i < nums.size(); i++) {
            if (flag != 0 && arr[nums.get(i)] == arr[nums.get(i - 1)]) {
                continue;
            }
            if (num == 3 && target - arr[nums.get(i)] != 0) continue;
            temp.addLast(arr[nums.get(i)]);
            dfs(nums, i + 1, target - arr[nums.get(i)], num + 1);
            temp.removeLast();
            flag++;
        }
    }
}
