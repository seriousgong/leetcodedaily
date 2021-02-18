package d12

import (
	"fmt"
	"sort"
)

func Day31(i [][]int) int {
	return eraseOverlapIntervals(i)
}
func eraseOverlapIntervals(intervals [][]int) int {
	//qc(intervals, 0, len(intervals)-1)
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})
	fmt.Println(intervals)
	i1 := intervals[0][1]
	res := 0
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] < i1 {
			res++
		} else {
			i1 = intervals[i][1]
		}
	}
	return res
}

func qc(intervals [][]int, l, r int) {

	if l > r || l < 0 || l >= len(intervals) || r < 0 || r >= len(intervals) {
		return
	}
	s := l
	e := r
	std := intervals[s]
	for s < e {
		for s < e && (intervals[e][1] > std[1] || (intervals[e][1] == std[1] && intervals[e][0] > std[0])) {
			e--
		}
		for s < e && (intervals[s][1] < std[1] || (intervals[s][1] == std[1] && intervals[s][0] <= std[0])) {
			s++
		}
		if s < e {
			temp := intervals[s]
			intervals[s] = intervals[e]
			intervals[e] = temp
		}
	}
	temp := intervals[l]
	intervals[l] = intervals[s]
	intervals[s] = temp
	qc(intervals, l, s-1)
	qc(intervals, s+1, r)
}
