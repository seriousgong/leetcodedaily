package dailypractice

func trap(height []int) int {

	stack := make([]int, len(height))
	res := 0
	for i := 0; i < len(height); i++ {
		if len(stack) == 0 || stack[len(stack)-1] >= height[i] {
			stack = append(stack, i)
			continue
		}
		for {
			l := -1
			for len(stack) > 0 && height[stack[len(stack)-1]] < height[i] {
				if l != -1 && height[l] < height[stack[len(stack)-1]] {
					res += min(height[i], height[stack[len(stack)-1]]) * (i - stack[len(stack)-1] - 1)
				}
				l = stack[len(stack)-1]
				stack = stack[:len(stack)-1]
			}
			if len(stack) > 0 {
				res += height[i] * (i - stack[len(stack)-1] - 1)
				if height[i] == height[stack[len(stack)-1]] {
					stack = stack[:len(stack)-1]
				}
			}
			if len(stack) == 0 || stack[len(stack)-1] > height[i] {
				break
			}
		}
		stack = append(stack, i)
	}
	return res
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
