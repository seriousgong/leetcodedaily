package m8

func findUnsortedSubarray(nums []int) int {

	max := nums[0]
	start := -1
	end := -1
	for i := 1; i < len(nums); i++ {
		if nums[i] < max {
			if start == -1 {
				start = i - 1
				for start >= 0 && nums[start] == max {
					start--
				}
			}
			end = i
		} else {
			max = nums[i]
		}
	}
	if end != -1 {
		return end - start + 1
	}
	return 0
}
