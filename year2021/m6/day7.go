package m6

func findTargetSumWays(nums []int, target int) int {
	// 计算区间表达式上下限
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
	}
	if target > sum || target < -sum {
		return 0
	}
	var dfs func(index, sum1 int) int
	dfs = func(index, sum1 int) int {
		if index >= len(nums) {
			if sum1 == target {
				return 1
			}
			return 0
		}
		return dfs(index+1, sum1+nums[index]) + dfs(index+1, sum1-nums[index])

	}
	return dfs(0, 0)
}
