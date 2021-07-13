package dailypractice

/*最长递增子序列*/
func lengthOfLIS(nums []int) int {
	var dfs func(index, last, cnt int) int
	dfs = func(index, last, cnt int) int {
		if index == len(nums) {
			return cnt
		}
		maxCnt := 0
		for i := index; i < len(nums); i++ {
			if nums[i] > last {
				if ct := dfs(index+1, nums[i], cnt+1); ct > maxCnt {
					maxCnt = ct
				}
			}
		}
		return maxCnt
	}
	return dfs(0, -100000, 0)
}
