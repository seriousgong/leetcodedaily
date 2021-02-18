package d12

func M(strs []string) [][]string {
	return groupAnagrams(strs)
}
func groupAnagrams(strs []string) [][]string {
	res := make([][]string, 0)
	alphet1 := make([]int, 26)
	alphet2 := make([]int, 26)
	for i := 0; i < len(strs); i++ {
		if strs[i] == "A" {
			continue
		}
		res = append(res, []string{})
		res[len(res)-1] = append(res[len(res)-1], strs[i])
		for i1 := 0; i1 < len(strs[i]); i1++ {
			alphet1[strs[i][i1]-'a']++
		}
		for i1 := i + 1; i1 < len(strs); i1++ {
			if len(strs[i1]) != len(strs[i]) {
				continue
			}
			if strs[i1] != "" && strs[i1] != "A" {
				for i2 := 0; i2 < len(strs[i1]); i2++ {
					alphet2[strs[i1][i2]-'a']++
				}
			}
			if compare(alphet1, alphet2) {
				res[len(res)-1] = append(res[len(res)-1], strs[i1])
				strs[i1] = "A"
			}
			clear(alphet2)
		}
		clear(alphet1)
	}
	return res
}

func clear(a []int) {
	for i := range a {
		a[i] = 0
	}
}
func compare(a, b []int) bool {
	for i, i2 := range a {
		if i2 != b[i] {
			return false
		}
	}
	return true
}
