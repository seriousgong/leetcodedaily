package leetcode.oct;

import com.dailyproblem.Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class day11 {
    public boolean canPartition(int[] nums) {

        failed = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        target = sum / 2;
        if (sum % 2 != 0) return false;
        ans = false;
        dfs(nums, 0, 0);
        return ans;
    }


    boolean ans;
    HashSet<Integer> failed;
    int target;

    void dfs(int[] nums, int index, int sum) {
        if (failed.contains(sum)) return;
        if (nums == null) return;
        if (ans) return;
        if (sum == target) {
            ans = true;
            return;
        }
        if (sum > target || index >= nums.length) {
            failed.add(sum);
            return;
        }
        dfs(nums, index + 1, sum + nums[index]);
        dfs(nums, index + 1, sum);
    }
}
