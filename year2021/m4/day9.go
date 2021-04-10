package m4

func findMin(nums []int) int {
	i, j := 0, len(nums)-1
	for i < j {
		// 因为原先是个升序含重复数组，有无论怎么旋转，如果[0]元素<[last]元素，那么 该数组即原数组
		if nums[i] == nums[j] && nums[j-1] <= nums[j] {
			i++
			j--
			continue
		}
		mid := (i + j) / 2
		if nums[mid] <= nums[j] {
			j = mid
		} else {
			i = mid + 1
		}
	}
	if nums[i] > nums[j] {
		return nums[j]
	}
	return nums[i]
}
