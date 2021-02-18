package hot100;

public class _283 {
    public void moveZeroes(int[] nums) {

        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[l] = nums[i];
                l++;
            }

        }
    }
}
