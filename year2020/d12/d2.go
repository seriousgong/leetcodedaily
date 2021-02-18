package d12

import "fmt"

func MaxNumber(nums1 []int, nums2 []int, k int) []int {
	var res = make([]int, 0)
	for i := 0; i <= len(nums1) && i <= k; i++ {
		if i+len(nums2) < k {
			continue
		}
		maxArr = make([]int, i)
		max = 0
		findMaxSubSequence(nums1, i, 0, 0, 0, make([]int, i))
		max1 := maxArr
		maxArr = make([]int, k-i)
		max = 0
		findMaxSubSequence(nums2, k-i, 0, 0, 0, make([]int, k-i))
		max2 := maxArr
		fmt.Println(max1)
		fmt.Println(max2)
		temp := merge(max1, max2)
		if lexicographicalLess(res, temp) {
			res = temp
		}
	}
	return res
}
func lexicographicalLess(a, b []int) bool {
	for i := 0; i < len(a) && i < len(b); i++ {
		if a[i] != b[i] {
			return a[i] < b[i]
		}
	}
	return len(a) < len(b)
}

func merge(a, b []int) []int {
	merged := make([]int, len(a)+len(b))
	for i := range merged {
		if lexicographicalLess(a, b) {
			merged[i], b = b[0], b[1:]
		} else {
			merged[i], a = a[0], a[1:]
		}
	}
	return merged
}

var maxArr []int
var max int

func findMaxSubSequence(arr []int, n int, index int, i1 int, sum int, temp []int) {
	if len(arr) < n {
		return
	}
	if n == 0 {
		if max < sum {
			maxArr = temp
			max = sum
		}
		return
	}
	last := 0
	for i := index; i < len(arr) && len(arr)-i >= n; i++ {

		if sum*10+arr[i] > last {
			temp[i1] = arr[i]
			findMaxSubSequence(arr, n-1, i+1, i1+1, sum*10+arr[i], temp)
			last = sum*10 + arr[i]
		}
	}
}
