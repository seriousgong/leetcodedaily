package m7

import "sort"

func maximumElementAfterDecrementingAndRearranging(arr []int) int {
	sort.Ints(arr)
	arr[0] = 1
	res := 1
	for i := 1; i < len(arr); i++ {
		if arr[i] < arr[i-1] {
			break
		} else if arr[i] > arr[i-1] {
			arr[i] = arr[i-1] + 1
		}
		res = arr[i]
	}
	return res
}
