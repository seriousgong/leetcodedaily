package m4

func trap(height []int) int {
	stack, res, low := make([]int, 0), 0, 0
	for i := 0; i < len(height); i++ {
		for ; len(stack) > 0; stack = stack[:len(stack)-1] {
			val := height[stack[len(stack)-1]]
			if val > height[i] {
				val = height[i]
			}
			res += (val - low) * (i - stack[len(stack)-1] - 1)
			low = val
			if height[stack[len(stack)-1]] > height[i] {
				break
			}
		}
		stack = append(stack, i)
	}
	return res
}
