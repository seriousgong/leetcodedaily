package m3

func nextGreaterElements(nums []int) []int {

	res, stack := make([]int, len(nums)), make([]int, 0)
	for i := range res {
		res[i] = -1
	}
	for i := 0; i < 2*len(nums)-1; i++ {
		for len(stack) != 0 && nums[stack[len(stack)-1]] < nums[i%len(nums)] {
			res[stack[len(stack)-1]], stack = nums[i%len(nums)], stack[:len(stack)-1]
		}
		stack = append(stack, i%len(nums))
	}
	return res
}
