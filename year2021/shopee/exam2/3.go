package exam1

func longestPalindrome(s string) string {
	isPalindRome := func(i, j int) (int, int) {
		for i >= 0 && s[i] == s[j] && j < len(s) {
			i--
			j++
		}
		return i + 1, j - 1
	}
	x, y := 0, 0
	for i := 0; i < len(s); i++ {
		x1, y1 := isPalindRome(i, i)
		x2, y2 := isPalindRome(i, i+1)
		if y-x < y1-x1 {
			y = y1
			x = x1
		}
		if y-x < y2-x2 {
			y = y2
			x = x2
		}
	}
	return s[x : y+1]
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
