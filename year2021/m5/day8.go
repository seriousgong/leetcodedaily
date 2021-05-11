package m5

import "math"

func minimumTimeRequired(jobs []int, k int) int {
	workers := make([]int, k)
	res := math.MaxInt64
	var dfs func(job, time int)
	dfs = func(job, time int) {
		if job >= len(jobs) {
			if res < time {
				res = time
			}
			return
		}
		for i := 0; i < k; i++ {
			workers[i] += jobs[job]
			dfs(job+1, max(time, workers[i]))
			workers[i] -= jobs[job]
		}
	}
	dfs(0, 0)
	return res
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
