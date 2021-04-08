package m4

func findMin(nums []int) int {
	i, j := nums[0], nums[len(nums)-1]
	// 因为原先是个升序数组，所有无论怎么旋转，如果[0]元素<[last]元素，那么 该数组即原数组
	if i <= j {
		return nums[i]
	}
	for i, j = 0, len(nums)-1; i < j; {
		mid := (i + j) / 2
		if nums[mid] < nums[len(nums)-1] {
			j = mid
		} else {
			i = mid + 1
		}
	}
	return nums[i]
}
