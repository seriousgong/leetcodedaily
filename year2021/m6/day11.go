package m6

import "math"

func numSquares(n int) int {
	arr := make([]int, 0)
	for i := 1; i*i < n; i++ {
		arr = append(arr, i*i)
	}
	dp := make([]int, n+1)
	dp[0] = 1
	for i := 1; i <= n; i++ {
		tmp := math.MaxInt64
		for _, val := range arr {
			if i < val {
				break
			}
			tmp = min(dp[i-val], tmp)
		}
		dp[i] = tmp + 1
	}
	return dp[n]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a

}
