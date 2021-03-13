package exam1

/*一开始递归超时，剪完枝就ok了*/
func isMatch(s string, p string) bool {
	dp := make([][]bool, len(s))
	for i := range dp {
		dp[i] = make([]bool, len(p))
	}
	var dfs func(i, j int) bool
	dfs = func(si, pi int) bool {
		if si >= len(s) || pi >= len(p) {
			for ; pi < len(p) && p[pi] == '*'; pi++ {
			}
			return pi == len(p) && si == len(s)
		}
		if dp[si][pi] {
			return false
		}
		dp[si][pi] = true
		if p[pi] == s[si] || p[pi] == '?' {
			return dfs(si+1, pi+1)
		} else if p[pi] == '*' {
			return dfs(si+1, pi) || dfs(si, pi+1)
		}
		return false
	}
	return dfs(0, 0)
}
