package leetcode.sept;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day20 {
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        temp = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++) {
            recall(nums, i, 0);
        }
        return ans;
    }

    LinkedList<Integer> temp;
    List<List<Integer>> ans;

    void recall(int[] nums, int count, int index) {
        if (count == temp.size()) {
            ans.add(new ArrayList<>(temp));
        }
        if (count - temp.size() > nums.length - index) return;
        for (int i = index; i < nums.length; i++) {
            temp.addLast(nums[i]);
            recall(nums, count, i + 1);
            temp.removeLast();
        }
    }


}
