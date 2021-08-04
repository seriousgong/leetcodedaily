package m8

import (
	"fmt"
	"testing"
)

func Test2(t *testing.T) {
	fmt.Println(networkDelayTime([][]int{{2, 1, 2}, {2, 3, 1}, {3, 4, 2}, {1, 4, 1}}, 4, 2))
}
func networkDelayTime(times [][]int, n int, k int) int {
	graph := make([][]int, n+1)
	minArr := make([]int, n+1)
	for i := range graph {
		graph[i] = make([]int, n+1)
		minArr[i] = 100*n + 1
	}
	for i := range times {
		graph[times[i][0]][times[i][1]] = times[i][2] + 1
	}
	for i := 1; i <= n; i++ {

	}
	res := 0

	for i := 1; i < len(minArr); i++ {
		if i == k {
			continue
		} else if minArr[i] == 100*n+1 {
			return -1
		}
		if res < minArr[i] {
			res = minArr[i]
		}
	}
	return res
}
