package m6

func change(amount int, coins []int) int {

	var dfs func(curr int) int
	dfs = func(curr int) int {
		if curr == 0 {
			return 1
		}
		if curr < 0 {
			return 0
		}

		cnt := 0
		for i := 0; i < len(coins); i++ {
			if coins[i] <= curr {
				cnt += dfs(curr - coins[i])
			}
		}
		return cnt
	}
	return dfs(amount)
}
