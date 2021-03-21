package week233

func maxAscendingSum(nums []int) int {
	sum, tmp := nums[0], nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			tmp += nums[i]
		} else {
			if sum < tmp {
				sum = tmp
			}
			tmp = nums[i]
		}
	}
	if sum < tmp {
		return tmp
	}
	return sum
}
