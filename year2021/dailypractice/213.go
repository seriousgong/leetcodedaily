package dailypractice

/*打家劫舍2*/
func rob(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	dp := make([]int, len(nums))
	dp1 := make([]int, len(nums))
	dp[0] = nums[0]
	dp[1] = max(nums[0], nums[1])
	for i := 2; i < len(nums)-1; i++ {
		dp[i] = max(dp[i-1], dp[i-2]+nums[i])
	}
	dp1[1] = nums[1]
	if len(nums) > 2 {

		dp1[2] = max(nums[1], nums[2])
		for i := 3; i < len(nums); i++ {
			dp1[i] = max(dp1[i-1], dp1[i-2]+nums[i])
		}
	}
	return max(dp[len(nums)-2], dp1[len(nums)-1])
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
