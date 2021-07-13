package m6

import "fmt"

func permutation(s string) []string {
	runes := []rune(s)
	choose := make([]bool, len(runes))
	mp := map[rune]int{}
	for _, key := range runes {
		mp[key]++
	}
	index := 0
	for key, cnt := range mp {
		for i := 0; i < cnt; i++ {
			runes[index] = key
			index++
		}
	}
	fmt.Println(runes)
	res := make([]string, 0)
	var dfs func(cnt int, tmp []rune)
	dfs = func(cnt int, tmp []rune) {
		if cnt == len(runes) {
			res1 := make([]rune, len(tmp))
			copy(res1, tmp)
			res = append(res, string(res1))
			return
		}
		var last rune
		for i := 0; i < len(runes); i++ {
			if choose[i] || runes[i] == last {
				continue
			}
			choose[i] = true
			tmp = append(tmp, runes[i])
			dfs(i+1, tmp)
			tmp = tmp[:len(tmp)-1]
			choose[i] = false
			last = runes[i]
		}
	}
	dfs(0, []rune{})
	return res
}
