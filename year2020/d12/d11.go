package d12

import "fmt"

func uniquePaths(m int, n int) int {
	dp := make([][]int, m)
	for x := range dp {
		dp[x] = make([]int, n)
		for y := 0; y < n; y++ {
			var sum int
			if x > 1 {
				sum += dp[x-1][y]
			}
			if y > 1 {
				sum += dp[x][y-1]
			}
			if sum == 0 {
				sum++
			}
			dp[x][y] = sum
		}
	}
	fmt.Println(dp)
	return dp[m-1][n-1]

}
