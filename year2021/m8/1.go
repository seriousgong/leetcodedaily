package m8

import (
	"sort"
	"strconv"
)

type sortable struct {
	row   int
	count int
}

func (s sortable) String() string {
	return "row:" + strconv.Itoa(s.row) + ", count:" + strconv.Itoa(s.count) + ";"
}
func kWeakestRows(mat [][]int, k int) []int {
	res, arr := make([]int, len(mat)), make([]sortable, len(mat))
	for i := 0; i < len(mat); i++ {
		arr[i].row = i
		for j := 0; j < len(mat[0]); j++ {
			arr[i].count += mat[i][j] & 1
		}
	}
	sort.Slice(arr, func(i, j int) bool {
		a, b := arr[i], arr[j]
		return a.count < b.count || (a.count == b.count && a.row < b.row)
	})
	for i := 0; i < len(res); i++ {
		res[i] = arr[i].row
	}
	return res[:k]
}
