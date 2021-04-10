package m4

func findMin(nums []int) int {
	i, j := 0, len(nums)-1
	for i < j {
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

	return nums[i]
}
