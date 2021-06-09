package dailypractice

func generateParenthesis(n int) []string {

	res := make([]string, 0)
	var dfs func(l, r int, arr []byte)
	dfs = func(l, r int, arr []byte) {
		if r == 0 {
			if l == 0 {
				ans := make([]byte, len(arr))
				copy(ans, arr)
				res = append(res, string(ans))
			}
			return
		}
		arr[2*n-l-r] = '('
		dfs(l-1, r, arr)
		if r > l {
			arr[2*n-l-r] = ')'
			dfs(l, r-1, arr)
		}
	}
	dfs(n, n, make([]byte, 2*n))
	return res
}
