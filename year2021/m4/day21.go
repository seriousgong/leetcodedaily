package m4

func numDecodings(s string) int {

	var dfs func(index int) int
	dfs = func(index int) int {
		if index >= len(s) {
			return 1
		}
		val := 0
		val += dfs(index + 1)
		if index < len(s)-1 {
			if s[index] == 2 && s[index+1] <= 6 || s[index] < 2 {
				val += dfs(index + 2)
			}
		}
		return val
	}

	return dfs(0)
}
