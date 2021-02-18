package leetcode.sept;

import java.util.*;

public class day18 {
    public static void main(String[] args) {
        day18 d = new day18();
        System.out.println(d.permuteUnique(new int[]{1, 1, 2, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        temp = new LinkedList<>();
        ans = new ArrayList<>();
        Arrays.sort(nums);
        recall(nums, new boolean[nums.length], 0);
        return ans;
    }

    List<List<Integer>> ans;
    LinkedList<Integer> temp;

    void recall(int[] nums, boolean[] booleans, int num) {
        if (num == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!booleans[i]) {
                if (last > -1 && nums[i] == last) continue;
                temp.addLast(nums[i]);
            } else continue;
            booleans[i] = true;
            recall(nums, booleans, num + 1);
            temp.removeLast();
            booleans[i] = false;
            last = nums[i];
        }
    }
}
