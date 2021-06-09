package m5

func maxUncrossedLines(nums1 []int, nums2 []int) int {
	n, m := len(nums1), len(nums2)
	dp := make([][]int, n+1)

	for i := range dp {
		dp[i] = make([]int, m+1)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			dp[i+1][j+1] = dp[i][j]
			if nums1[i] == nums2[j] {
				dp[i+1][j+1]++
			}
			dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1], dp[i+1][j+1])
		}
	}
	return dp[n][m]
}
func max(arr ...int) int {
	var max = arr[0]
	for i := 0; i < len(arr); i++ {
		if max < arr[i] {
			max = arr[i]
		}
	}
	return max
}
