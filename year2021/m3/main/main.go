package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(maxEnvelopes([][]int{{30, 50}, {12, 2}, {3, 4}, {12, 15}}))
}

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
