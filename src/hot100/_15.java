package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        ans = new ArrayList<>();
        temp = new LinkedList<>();
        dfs(nums, 0, 0);
        return ans;

    }

    List<List<Integer>> ans;
    LinkedList<Integer> temp;

    private void dfs(int[] nums, int sum, int index) {
        if (nums == null) return;
        if (temp.size() == 3) {
            if (sum == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        boolean loop = false;
        for (int i = index; i < nums.length; i++) {
            if (loop && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!loop) loop = true;
            if (temp.size() == 2) {
                if (sum + nums[i] == 0) {
                    temp.addLast(nums[i]);
                    ans.add(new ArrayList<>(temp));
                } else {
                    continue;
                }
            } else {
                dfs(nums, sum + nums[i], i + 1);
            }
            temp.removeLast();
        }
    }
}
