package m3

import (
	"sort"
)

/*没完全想出来*/
func maxEnvelopes(envelopes [][]int) int {
	sort.Slice(envelopes, func(i, j int) bool {
		return envelopes[i][0] < envelopes[j][0] || envelopes[i][0] == envelopes[j][0] && envelopes[i][1] < envelopes[j][1]
	})
	//fmt.Println(envelopes)
	dp, res := make([]int, len(envelopes)), 0
	for i := range dp {
		dp[i] = 1
	}
	for i := 1; i < len(envelopes); i++ {
		for j := 0; j < i; j++ {
			if envelopes[i][1] > envelopes[j][1] {
				if dp[i] < dp[j]+1 {
					dp[i] = dp[j] + 1
				}
			}
		}
	}
	for _, val := range dp {
		if val > res {
			res = val
		}
	}
	return res
}
