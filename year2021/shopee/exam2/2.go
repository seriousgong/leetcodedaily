package exam1

func checkValidString(s string) bool {
	mx, min := 0, 0
	for i, val := range s {
		switch val {
		case '(':
			if len(s)-i < min {
				return false
			}
			mx++
			min++
		case ')':
			mx--
			min = max1(0, min-1)
			if mx < 0 {
				return false
			}
		default:
			min = max1(0, min-1)
			mx++
		}
	}
	return mx >= 0
}

func max1(a, b int) int {
	if a > b {
		return a
	}
	return b
}
