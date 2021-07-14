package m7

import (
	"fmt"
	"sort"
	"testing"
)

func Test14(t *testing.T) {
	fmt.Println(minAbsoluteSumDiff([]int{1, 7, 5}, []int{2, 3, 5}))
	fmt.Println(minAbsoluteSumDiff([]int{1, 10, 4, 4, 2, 7}, []int{9, 3, 5, 1, 7, 4}))
}
func minAbsoluteSumDiff(nums1 []int, nums2 []int) int {
	var cp []int
	cp = append(cp, nums1...)
	sort.Ints(cp)
	sum, maxDiff := 0, 0
	for i, val := range nums2 {
		diff := abs(nums1[i] - nums2[i])
		sum += diff
		index := search(cp, val)
		tmp := diff - abs(cp[index]-nums2[i])
		if index > 0 {
			if tmp1 := diff - abs(cp[index-1]-nums2[i]); tmp1 > tmp {
				tmp = tmp1
			}
		}
		if maxDiff < tmp {
			maxDiff = tmp
		}
	}
	return (sum - maxDiff) % (1e9 + 7)
}
func search(arr []int, target int) int {
	l, r := 0, len(arr)-1
	for l < r {
		mid := l + (r-l)/2
		if arr[mid] <= target {
			l = mid + 1
		} else {
			r = mid
		}
	}
	return l
}
func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
