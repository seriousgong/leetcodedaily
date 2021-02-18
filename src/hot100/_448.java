package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (nums[num - 1] != num) {
                int temp = nums[num];
                nums[num - 1] = num;
                num = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}
