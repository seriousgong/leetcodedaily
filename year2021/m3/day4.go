package m3

import (
	"sort"
)

/*没完全想出来*/
func maxEnvelopes(envelopes [][]int) int {
	sort.Slice(envelopes, func(i, j int) bool {
		return envelopes[i][0] < envelopes[j][0] || envelopes[i][1] < envelopes[j][0]
	})
	return loop(envelopes, 0, []int{0, 0})
}

func loop(envelopes [][]int, curr int, last []int) int {
	if curr == len(envelopes) {
		return 0
	}
	m1, m2 := 0, 0
	if envelopes[curr][0] > last[0] && envelopes[curr][1] > last[1] {
		m1 = max(loop(envelopes, curr+1, envelopes[curr])+1, loop(envelopes, curr+1, envelopes[curr]))
	}
	m2 = loop(envelopes, curr+1, envelopes[curr])
	return max(m1, m2)

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
