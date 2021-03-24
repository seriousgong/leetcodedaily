package m3

import "math"

/*

	[1, 3, 2]
*/
func find132pattern(nums []int) bool {
	var mid int
	stack := []int{nums[len(nums)-1]}
	mid = math.MinInt64
	for i := len(nums) - 2; i >= 0; i-- {
		if mid > nums[i] {
			return true
		}
		for len(stack) > 0 && nums[i] > stack[len(stack)-1] {
			mid = stack[len(stack)-1]
			stack = stack[:len(stack)-1]
		}
		//到这可能性: stack 空 nums[i]<=stack[len(stack)-1]  =的话没必要append，去重
		if nums[i] > mid {
			stack = append(stack, nums[i])
		}

	}
	return false
}
