package m4

func removeElement(nums []int, val int) int {
	i, j := 0, len(nums)-1
	for i < j {
		for ; i < j && nums[i] != val; i++ {
		}
		for ; i < j && nums[j] == val; j-- {
		}
		if i < j {
			nums[i], nums[j] = nums[j], val
		}
	}
	if nums[i] == val {
		return i - 1
	}
	return i
}
