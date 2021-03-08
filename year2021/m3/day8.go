package m3

/*基于昨天的改进直接超时，看题解对数据做预处理(最长回文子串，动态规划)后，在求最小切割次数动态规划问题*/
func minCut(s string) int {
	l, dp := len(s), make([][]bool, len(s))
	for i := 0; i < l; i++ {
		dp[i] = make([]bool, l)
		for j := 0; j < l; j++ {
			dp[i][j] = true
		}
	}
	for i := l - 1; i >= 0; i-- {
		for j := i + 1; j < l; j++ {
			dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
		}
	}
	dp2 := make([]int, l)
	for i := 0; i < l; i++ {
		if !dp[0][i] {
			dp2[i] = dp2[i-1] + 1
			for j := 0; j < i; j++ {
				if dp[j+1][i] && dp2[j]+1 < dp2[i] {
					dp2[i] = dp2[j] + 1
				}
			}
		}
	}
	return dp2[l-1]
}
