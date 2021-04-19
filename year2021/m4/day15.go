package m4

func rob(nums []int) int {
	if len(nums) <= 2 {
		return max(nums[0], nums[len(nums)-1])
	}
	a, b, a1, b1 := nums[0], max(nums[0], nums[1]), nums[1], max(nums[1], nums[2])
	for i := 2; i < len(nums); i++ {
		if i < len(nums)-1 {
			b, a = max(a+nums[i], b), b
		}
		if i > 2 {
			b1, a1 = max(a1+nums[i], b1), b1
		}
	}
	return max(a, b, a1, b1)
}
func max(a ...int) (res int) {
	for _, i2 := range a {
		if i2 > res {
			res = i2
		}
	}
	return
}
