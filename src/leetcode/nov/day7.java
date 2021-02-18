package leetcode.nov;

public class day7 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int total = (1 + nums.length) * nums.length / 2;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum < lower && sum > upper) count++;
            }
        }
        return total - count;
    }
}
