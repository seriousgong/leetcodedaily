package m4

func canCross(stones []int) bool {
	if stones[1]-stones[0] != 1 {
		return false
	}
	mp := map[int]bool{}
	mp2 := map[int]map[int]bool{}
	for _, val := range stones {
		mp[val] = true
	}
	max := stones[len(stones)-1]
	var dfs func(index, jump int) bool
	dfs = func(sum, jump int) bool {
		if sum == max {
			return true
		}
		if jump < 0 || !mp[sum] {
			return false
		}
		if val, ok := mp2[sum][jump]; ok {
			return val
		}
		res := false
		for i := jump - 1; i < jump+2; i++ {
			if i > 0 {
				res = res || dfs(sum+i, i)
			}
		}
		if mp2[sum] == nil {
			mp2[sum] = map[int]bool{}
		}
		if _, ok := mp2[sum][jump]; !ok {
			mp2[sum][jump] = res
		}
		return res
	}
	return dfs(stones[1], 1)

}
