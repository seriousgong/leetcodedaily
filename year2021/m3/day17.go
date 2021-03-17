package m3

// 看了题解
func numDistinct(s string, t string) int {
	dp := make([][]int, len(s)+1)
	for i := range dp {
		dp[i] = make([]int, len(t)+1)
	}
	for i := 0; i <= len(s); i++ {
		for j := 0; j <= len(t); j++ {
			if j == 0 {
				// j=0 always match set 1
				dp[i][j] = 1
			} else if i != 0 {
				if s[i-1] == t[j-1] {
					dp[i][j] = dp[i-1][j-1]
				}
				// add prefix match
				dp[i][j] += dp[i-1][j]
			}
		}
	}
	return dp[len(s)][len(t)]
}
