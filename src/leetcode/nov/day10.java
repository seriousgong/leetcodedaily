package leetcode.nov;

public class day10 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int index = -1;

        /*找到最后一个递增区间，表示从i+1之后是非递增的区间，那么0-i是可以放着不动的*/
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        System.out.println(index);
        /*没有递增区间,则取最小字典序*/
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int index1 = -1;
        /*取后续区间中大于index的最小值*/
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                index1 = i;
                break;
            }
        }
        System.out.println(index1);
        /*交换*/
        int temp = nums[index];
        nums[index] = nums[index1];
        nums[index1] = temp;
        /*index位变成了第二小的数，只需将index-nums.length区间翻转*/

        reverse(nums, index, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {

        for (int i = l; i < r; i++) {
            int temp = nums[i];
            nums[i] = nums[r];
            nums[r--] = temp;
        }
    }


}
