package m5

func numWays(steps int, arrLen int) int {
	var dfs func(step, index int) int
	dp := make([][]int32, steps+1)
	s := steps
	if steps > arrLen {
		s = arrLen
	}
	for i := range dp {
		dp[i] = make([]int32, s+1)
	}
	dfs = func(step, index int) int32 {
		if step == steps {
			if index == 0 {
				return 1
			}
			return 0
		}
		if steps-step < index {
			return 0
		}
		if dp[step][index] == -1 {
			return 0
		} else if dp[step][index] > 0 {
			return dp[step][index]
		}
		res := 0
		if index+1 < arrLen {
			res = (res + dfs(step+1, index+1)) % (10e9 + 7)

		}
		res = (res + dfs(step+1, index)) % (10e9 + 7)
		if index > 0 {
			res = (res + dfs(step+1, index-1)) % (10e9 + 7)
		}
		if res == 0 {
			dp[step][index] = -1
		} else {
			dp[step][index] = res
		}

		return res
	}
	return dfs(0, 0)
}
