package m6

func peakIndexInMountainArray(arr []int) int {

	// 题目特性，波峰不会重复
	l, r := 0, len(arr)-1
	for l < r {
		mid := l + (r-l)/2
		if arr[mid] > arr[mid+1] {
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return l
}
