package main

import "fmt"

func main() {
	fmt.Println(numDecodings("12"))
	fmt.Println(numDecodings("226"))
}
func numDecodings(s string) int {
	if s[0] == '0' {
		return 0
	}
	dp := make([]int, len(s))
	dp[0] = 1
	for i := 1; i < len(s); i++ {
		if s[i] != '0' {
			dp[i] += dp[i-1]
		}
		if (s[i-1] == '2' && s[i] <= '6') || s[i-1] == '1' {
			if i == 1 {
				dp[i] += 1
			} else {
				dp[i] += dp[i-2]
			}
		}
	}
	return dp[len(s)-1]
}
