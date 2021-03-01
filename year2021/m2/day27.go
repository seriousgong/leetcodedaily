package m2

func longestSubstring(s string, k int) int {
	return loop(0, len(s)-1, k, s)
}
func loop(start, end, k int, s string) int {
	alphet := make([]int, 26)
	res := 0
	if end-start+1 < k {
		return 0
	}
	for i := start; i <= end; i++ {
		alphet[s[i]-'a']++
	}

	for i := start; i <= end; i++ {
		if alphet[s[i]-'a'] < k {
			return max(loop(i+1, end, k, s), loop(start, i-1, k, s))

		}

	}
	return max(res, end-start+1)
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
